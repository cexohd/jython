/* Copyright (c)2012 Jython Developers */
package org.python.modules._io;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

import org.python.core.ArgParser;
import org.python.core.BuiltinDocs;
import org.python.core.Py;
import org.python.core.PyBuffer;
import org.python.core.PyException;
import org.python.core.PyJavaType;
import org.python.core.PyLong;
import org.python.core.PyNewWrapper;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyType;
import org.python.core.PyUnicode;
import org.python.core.io.FileIO;
import org.python.core.io.RawIOBase;
import org.python.expose.ExposedGet;
import org.python.expose.ExposedMethod;
import org.python.expose.ExposedNew;
import org.python.expose.ExposedType;

import com.kenai.constantine.platform.Errno;

@ExposedType(name = "_io.FileIO", base = PyRawIOBase.class)
public class PyFileIO extends PyRawIOBase {

    public static final PyType TYPE = PyType.fromClass(PyFileIO.class);

    /** The FileIO to which we delegate operations not complete locally. */
    private final FileIO ioDelegate;

    /** The name of the file */
    @ExposedGet(doc = BuiltinDocs.file_name_doc)
    protected PyObject name;

    /*
     * Implementation note: CPython fileio does not use the base-class, possibly overridden,
     * readable(), writable() and seekable(). Instead it sets local variables for readable and
     * writable using the open mode, and returns these as readable() and writable(), while using
     * them internally. The local variable seekable (and seekable()) is worked out from a one-time
     * trial seek.
     */
    /** Set true when stream must be <code>readable = reading | updating</code> */
    private boolean readable;

    /** Set true when stream must be <code>writable = writing | updating | appending</code> */
    private boolean writable;

    /** Set true when we have made the seekable test */
    private boolean seekableKnown;

    /** Set true when stream is seekable */
    private boolean seekable;

    /** Whether to close the underlying stream on closing this object. */
    @ExposedGet
    public final boolean closefd;

    /** The mode as a PyString based on readable and writable */
    @ExposedGet(doc = BuiltinDocs.file_mode_doc)
    public final PyString mode;

    private static final PyString defaultMode = new PyString("r");

    /**
     * Construct an open <code>_io.FileIO</code> starting with an object that may be a file name or
     * a file descriptor (actually a {@link RawIOBase}). Only the relevant flags within the parsed
     * mode object are consulted (so that flags meaningful to this sub-class need not be processed
     * out).
     *
     * @param fd on which this should be constructed
     * @param mode type of access specified
     * @param closefd if <code>false</code>, do not close <code>fd</code> on call to
     *            <code>close()</code>
     */
    public PyFileIO(PyObject file, OpenMode mode, boolean closefd) {
        this(TYPE, file, mode, closefd);
    }

    /**
     * Construct an open <code>_io.FileIO</code> for a sub-class constructor starting with an object
     * that may be a file name or a file descriptor (actually a {@link RawIOBase}). Only the
     * relevant flags within the parsed mode object are consulted (so that flags meaningful to this
     * sub-class need not be processed out).
     *
     * @param subtype for which construction is occurring
     * @param file on which this should be constructed
     * @param mode type of access specified
     * @param closefd if <code>false</code>, do not close <code>file</code> on call to
     *            <code>close()</code>
     */
    public PyFileIO(PyType subtype, PyObject file, OpenMode mode, boolean closefd) {
        super(subtype);
        this.ioDelegate = getFileIO(file, mode, closefd);
        this.closefd = closefd;
        this.name = file;

        readable = mode.reading | mode.updating;
        writable = mode.writing | mode.updating | mode.appending;

        // The mode string of a raw file always asserts it is binary: "rb", "rb+", or "wb".
        if (readable) {
            this.mode = new PyString(writable ? "rb+" : "rb");
        } else {
            this.mode = new PyString("wb");
        }
    }

    /**
     * Helper function that turns the arguments of the most general constructor, or
     * <code>__new__</code>, into a {@link FileIO}. This places the logic of those several
     * operations in one place.
     * <p>
     * In many cases (such as construction from a file name, the FileIO is a newly-opened file. When
     * the file object passed in is a file descriptor, the FileIO may be created to wrap that
     * existing stream.
     *
     * @param file name or descriptor
     * @param mode parsed file open mode
     * @param closefd must be true if file is in fact a name (checked, not used)
     * @return
     */
    private static FileIO getFileIO(PyObject file, OpenMode mode, boolean closefd) {

        if (file instanceof PyString) {
            // Open a file by name
            if (!closefd) {
                throw Py.ValueError("Cannot use closefd=False with file name");
            }
            String name = file.asString();
            return new FileIO(name, mode.forFileIO());

        } else {
            /*
             * Build an _io.FileIO from an existing "file descriptor", which we may or may not want
             * closed at the end. A CPython file descriptor is an int, but this is not the natural
             * choice in Jython, and file descriptors should be treated as opaque.
             */
            Object fd = file.__tojava__(Object.class);
            if (fd instanceof RawIOBase) {
                // It is the "Jython file descriptor" from which we can get a channel.
                /*
                 * If the argument were a FileIO, could we return it directly? I think not: there
                 * would be a problem with close and closefd=False since it is not the PyFileIO that
                 * keeps state.
                 */
                Channel channel = ((RawIOBase)fd).getChannel();
                if (channel instanceof FileChannel) {
                    if (channel.isOpen()) {
                        FileChannel fc = (FileChannel)channel;
                        return new FileIO(fc, mode.forFileIO());
                    } else {
                        // File not open (we have to check as FileIO doesn't)
                        throw Py.OSError(Errno.EBADF);
                    }
                }
            }
            // The file was a type we don't know how to use
            throw Py.TypeError(String.format("invalid file: %s", file.__repr__().asString()));
        }
    }

    private static final String[] openArgs = {"file", "mode", "closefd"};

    /**
     * Create a {@link PyFileIO} and its <code>FileIO</code> delegate from the arguments.
     */
    @ExposedNew
    static PyObject FileIO___new__(PyNewWrapper new_, boolean init, PyType subtype,
            PyObject[] args, String[] keywords) {

        ArgParser ap = new ArgParser("FileIO", args, keywords, openArgs, 1);
        PyObject file = ap.getPyObject(0);
        PyObject m = ap.getPyObject(1, defaultMode);
        boolean closefd = Py.py2boolean(ap.getPyObject(2, Py.True));

        // Decode the mode string and check it
        OpenMode mode = new OpenMode(m.asString()) {

            {
                invalid |= universal | text;    // These other modes are invalid
            }
        };
        mode.checkValid();

        if (subtype == TYPE) {
            return new PyFileIO(subtype, file, mode, closefd);
        } else {
            return new PyFileIODerived(subtype, file, mode, closefd);
        }

    }

    /*
     * ===========================================================================================
     * Exposed methods in the order they appear in CPython's fileio.c method table
     * ===========================================================================================
     */

    // _RawIOBase.read is correct for us
    // _RawIOBase.readall is correct for us

    @Override
    public PyObject readinto(PyObject buf) {
        return FileIO_readinto(buf);
    }

    @ExposedMethod(doc = readinto_doc)
    final PyLong FileIO_readinto(PyObject buf) {

        if (!readable) {            // ... (or closed)
            throw tailoredValueError("read");
        }

        // Perform the operation through a buffer view on the object
        PyBuffer pybuf = writablePyBuffer(buf);
        try {
            PyBuffer.Pointer bp = pybuf.getBuf();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bp.storage, bp.offset, pybuf.getLen());
            int count;
            synchronized (ioDelegate) {
                count = ioDelegate.readinto(byteBuffer);
            }
            return new PyLong(count);

        } finally {
            // Must unlock the PyBuffer view from client's object
            pybuf.release();
        }
    }

    @Override
    public PyObject write(PyObject buf) {
        return FileIO_write(buf);
    }

    @ExposedMethod(doc = write_doc)
    final PyLong FileIO_write(PyObject obj) {

        if (!writable) {            // ... (or closed)
            throw tailoredValueError("writ");
        }

        // Get or synthesise a buffer API on the object to be written
        PyBuffer pybuf = readablePyBuffer(obj);
        try {
            // Access the data as a java.nio.ByteBuffer [pos:limit] within possibly larger array
            PyBuffer.Pointer bp = pybuf.getBuf();
            ByteBuffer byteBuffer = ByteBuffer.wrap(bp.storage, bp.offset, pybuf.getLen());
            int count;
            synchronized (ioDelegate) {
                count = ioDelegate.write(byteBuffer);
            }
            return new PyLong(count);

        } finally {
            // Even if that went badly, we should release the lock on the client buffer
            pybuf.release();
        }
    }

    @Override
    public long seek(long pos, int whence) {
        return FileIO_seek(pos, whence);
    }

    @ExposedMethod(defaults = "0", doc = seek_doc)
    final long FileIO_seek(long pos, int whence) {
        if (__closed) {
            throw closedValueError();
        }
        synchronized (ioDelegate) {
            return ioDelegate.seek(pos, whence);
        }
    }

    // _IOBase.tell() is correct for us

    @Override
    public long truncate() {
        return _truncate();
    }

    @Override
    public long truncate(long size) {
        return _truncate(size);
    }

    @ExposedMethod(defaults = "null", doc = truncate_doc)
    final long FileIO_truncate(PyObject size) {
        return (size != null) ? _truncate(size.asLong()) : _truncate();
    }

    /** Common to FileIO_truncate(null) and truncate(). */
    private final long _truncate() {
        if (!writable) {            // ... (or closed)
            throw tailoredValueError("writ");
        }
        synchronized (ioDelegate) {
            return ioDelegate.truncate(ioDelegate.tell());
        }
    }

    /** Common to FileIO_truncate(size) and truncate(size). */
    private final long _truncate(long size) {
        if (!writable) {            // ... (or closed)
            throw tailoredValueError("writ");
        }
        synchronized (ioDelegate) {
            return ioDelegate.truncate(size);
        }
    }

    /**
     * Close the underlying ioDelegate only if <code>closefd</code> was specified as (or defaulted
     * to) <code>True</code>.
     */
    @Override
    public void close() {
        FileIO_close();
    }

    @ExposedMethod
    final synchronized void FileIO_close() {
        // Close this object to further input (also calls flush)
        super.close();
        // Now close downstream (if required to)
        if (closefd) {
            ioDelegate.close();
        }
        // This saves us doing two tests for each action (when the file is open)
        readable = false;
        writable = false;
    }

    @Override
    public boolean seekable() {
        return FileIO_seekable();
    }

    @ExposedMethod(doc = seekable_doc)
    final boolean FileIO_seekable() {
        if (__closed) {
            throw closedValueError();
        }
        if (!seekableKnown) {
            seekable = ioDelegate.seek(0, 0) >= 0;
            seekableKnown = true;
        }
        return seekable;
    }

    @Override
    public boolean readable() throws PyException {
        return FileIO_readable();
    }

    @ExposedMethod(doc = readable_doc)
    final boolean FileIO_readable() {
        if (__closed) {
            throw closedValueError();
        }
        return readable;
    }

    @Override
    public boolean writable() throws PyException {
        return FileIO_writable();
    }

    @ExposedMethod(doc = writable_doc)
    final boolean FileIO_writable() {
        if (__closed) {
            throw closedValueError();
        }
        return writable;
    }

    @Override
    public PyObject fileno() {
        return FileIO_fileno();
    }

    @ExposedMethod(doc = fileno_doc)
    final PyObject FileIO_fileno() {
        return PyJavaType.wrapJavaObject(ioDelegate.fileno());
    }

    @ExposedMethod(doc = isatty_doc)
    final boolean FileIO_isatty() {
        if (__closed) {
            throw closedValueError();
        }
        return ioDelegate.isatty();
    }

    // fileio.c has no flush(), but why not, when there is fdflush()?
    // And it is a no-op for Jython io.FileIO, but why when there is FileChannel.force()?
    @Override
    public void flush() {
        FileIO_flush();
    }

    @ExposedMethod(doc = "Flush write buffers.")
    final void FileIO_flush() {
        if (writable()) {
            // Check for *downstream* close. (Locally, closed means "closed to client actions".)
            ioDelegate.checkClosed();
            ioDelegate.flush();
        }
    }

    @ExposedMethod(names = {"__str__", "__repr__"}, doc = BuiltinDocs.object___str___doc)
    final String FileIO_toString() {
        if (closed()) {
            return "<_io.FileIO [closed]>";
        } else if (name instanceof PyString) {
            String xname = name.asString();
            if (name instanceof PyUnicode) {
                xname = PyString.encode_UnicodeEscape(xname, false);
            }
            return String.format("<_io.FileIO name='%s' mode='%s'>", xname, mode);
        } else {
            return String.format("<_io.FileIO fd=%s mode='%s'>", fileno(), mode);
        }
    }

    @Override
    public String toString() {
        return FileIO_toString().toString();
    }

    /**
     * Convenience method providing the exception when an method requires the file to be open, and
     * it isn't.
     *
     * @return ValueError to throw
     */
    private PyException closedValueError() {
        return Py.ValueError("I/O operation on closed file");
    }

    /**
     * Convenience method providing the exception when an method requires the file to be open,
     * readable or writable, and it isn't. If the file is closed, return the message for that,
     * otherwise, one about reading or writing.
     *
     * @param action type of operation not valid ("read" or "writ" in practice).
     * @return ValueError to throw
     */
    private PyException tailoredValueError(String action) {
        if (action == null || __closed) {
            return closedValueError();
        } else {
            return Py.ValueError("File not open for " + action + "ing");
        }
    }

}

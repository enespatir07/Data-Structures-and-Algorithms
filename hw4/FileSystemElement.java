import java.sql.Timestamp;

/**
 * Abstract class representing a file system element.
 */
public abstract class FileSystemElement {

    /** The name of the file system element. */
    protected String name;

    /** The date and time when the file system element was created. */
    protected Timestamp dateCreated;

    /** The parent directory of the file system element. */
    protected FileSystemElement parent;

    /**
     * Constructs a new FileSystemElement with the specified name and parent
     * directory.
     *
     * @param name   the name of the file system element
     * @param parent the parent directory of the file system element
     */
    public FileSystemElement(String name, FileSystemElement parent) {
        this.name = name;
        this.dateCreated = new Timestamp(System.currentTimeMillis());
        this.parent = parent;
    }

    /**
     * Returns the name of the file system element.
     *
     * @return the name of the file system element
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the date and time when the file system element was created.
     *
     * @return the date and time when the file system element was created
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Returns the parent directory of the file system element.
     *
     * @return the parent directory of the file system element
     */
    public FileSystemElement getParent() {
        return parent;
    }

    /**
     * Sets the parent directory of the file system element.
     *
     * @param parent the new parent directory of the file system element
     */
    public void setParent(FileSystemElement parent) {
        this.parent = parent;
    }

    /**
     * This method must be implemented by subclasses
     *
     * @param prefix the prefix to be printed before the file system element
     *               representation
     */
    public abstract void print(String prefix);
}

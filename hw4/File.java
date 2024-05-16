/**
 * Represents a file in a file system.
 */
public class File extends FileSystemElement {

    /**
     * Constructs a new File with the specified name and parent directory.
     *
     * @param name   the name of the file
     * @param parent the parent directory of the file
     */
    public File(String name, FileSystemElement parent) {
        super(name, parent);
    }

    /**
     * Prints the representation of the file with the specified prefix.
     *
     * @param prefix the prefix to be printed before the file representation
     */

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "File: " + name);
    }
}

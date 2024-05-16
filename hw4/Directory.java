import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a directory in a file system.
 */
public class Directory extends FileSystemElement {

    /**
     * The list of children elements (files and subdirectories) contained within
     * this directory.
     */
    private LinkedList<FileSystemElement> children;

    /**
     * Constructs a new Directory with the specified name and parent directory.
     *
     * @param name   the name of the directory
     * @param parent the parent directory of the directory
     */
    public Directory(String name, FileSystemElement parent) {
        super(name, parent);
        children = new LinkedList<>();
    }

    /**
     * Adds a file system element (file or subdirectory) to this directory.
     *
     * @param element the file system element to be added
     */
    public void addElement(FileSystemElement element) {
        children.add(element);
        element.setParent(this);
    }

    /**
     * Removes a file system element (file or subdirectory) from this directory.
     *
     * @param element the file system element to be removed
     */
    public void removeElement(FileSystemElement element) {
        children.remove(element);
        element.setParent(null);
    }

    /**
     * Returns the list of children elements (files and subdirectories) contained
     * within this directory.
     *
     * @return the list of children elements
     */
    public LinkedList<FileSystemElement> getChildren() {
        return children;
    }

    /**
     * Returns a list of children elements (files and subdirectories) sorted by
     * their creation date and time.
     *
     * @return the sorted list of children elements
     */
    public List<FileSystemElement> getSortedChildrenByDateCreated() {
        List<FileSystemElement> sortedChildren = new ArrayList<>(children);
        Collections.sort(sortedChildren, new Comparator<FileSystemElement>() {
            @Override
            public int compare(FileSystemElement o1, FileSystemElement o2) {
                return o1.getDateCreated().compareTo(o2.getDateCreated());
            }
        });
        return sortedChildren;
    }

    /**
     * Prints the representation of the directory and its children with the
     * specified prefix.
     * Each child element's representation is printed recursively.
     *
     * @param prefix the prefix to be printed before the directory representation
     */
    @Override
    public void print(String prefix) {
        System.out.println(prefix + "Directory: " + getName());
        for (FileSystemElement elem : children) {
            elem.print(prefix + "    ");
        }
    }

}

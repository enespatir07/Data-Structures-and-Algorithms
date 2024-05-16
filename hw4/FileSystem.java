import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Represents a file system containing directories and files.
 * Allows operations such as creating, deleting, moving, and listing files and
 * directories.
 */
public class FileSystem {

    /** The root directory of the file system. */
    private Directory root;

    /** The current working directory in the file system. */
    private Directory currentDirectory;

    /**
     * Constructs a new FileSystem with a root directory named "root"
     * and a current directory named "home" within the root.
     */
    public FileSystem() {
        this.root = new Directory("root", null);
        this.currentDirectory = new Directory("home", this.root);
        root.addElement(currentDirectory);
    }

    /**
     * Creates a new file or directory with the specified name and type
     * in the current directory.
     *
     * @param type the type of the file system element ("f" for file, "d" for
     *             directory)
     * @param name the name of the file or directory to be created
     * @return the created file system element
     */

    public FileSystemElement createFD(String type, String name) {
        FileSystemElement item;
        if (type.equals("f")) {
            item = new File(name, currentDirectory);
            currentDirectory.addElement(item);
            System.out.println("File created: " + name);
        } else {
            item = new Directory(name, currentDirectory);
            currentDirectory.addElement(item);
            System.out.println("Directory created: " + name + "/");
        }

        return item;
    }

    /**
     * Prints the hierarchical representation of the file system starting from the
     * root directory.
     */
    public void printTree() {
        printTreeHelper(root, "");
    }

    private void printTreeHelper(FileSystemElement item, String space) {
        if (item instanceof Directory) { // to print * and /
            if (item == currentDirectory) {
                System.out.println(space + "* " + item.getName() + "/" + " (Current Directory)");
                listContent(space + "    "); // I should stop here after I print the current directory contents
                return;
            } else {// printing other directories
                System.out.println(space + "* " + item.getName() + "/");
            }

            for (FileSystemElement child : ((Directory) item).getChildren()) {
                printTreeHelper(child, space + "    "); // incrementing the space and calling the currents childs
            }
        } else if (item instanceof File) { // printing files
            System.out.println(space + item.getName());
        }
    }

    /**
     * Searches for a file system element with the specified name starting from the
     * root directory.
     *
     * @param name the name of the file system element to search for
     * @return the found file system element, or null if not found
     */

    public FileSystemElement search(String name) {
        return searchHelper(root, name);
    }

    private FileSystemElement searchHelper(FileSystemElement item, String name) {
        if (item instanceof Directory) {
            if (item.getName().equals(name)) { // base condition
                return item;
            }

            for (FileSystemElement child : ((Directory) item).getChildren()) {
                FileSystemElement result = searchHelper(child, name);
                if (result != null) {
                    return result; // Returns if found
                }
            }
        } else {
            // Checking for files
            if (item.getName().equals(name)) {
                return item;
            }
        }

        // If not found , return null
        return null;
    }

    /**
     * Finds the path of the given file system element till the home
     * directory.
     *
     * @param current the file system element for which to find the path
     * @return the path of the file system element til the home
     */

    public String findPath(FileSystemElement current) {
        String path = "";
        while (current != null && !current.getName().equals("root")) {
            path = "/" + current.getName() + path;
            current = (Directory) current.getParent();
        }
        return path;
    }

    /**
     * Lists the content (files and directories) of the current directory.
     */
    public void listContent(String space) {
        for (int i = 0; i < currentDirectory.getChildren().size(); i++) {
            if (currentDirectory.getChildren().get(i) instanceof Directory) {
                System.out.print(space + "* ");
                System.out.print(currentDirectory.getChildren().get(i).getName());
                System.out.println("/");
            } else
                System.out.println(space + currentDirectory.getChildren().get(i).getName());
        }
    }

    /**
     * Sorts the files and directories in the current directory by their creation
     * date and time.
     */
    public void sort() {
        if (currentDirectory.getChildren().isEmpty()) {
            System.err.println("No File/Directory found in current directory");
            return;
        }
        List<FileSystemElement> sortedChildren = currentDirectory.getSortedChildrenByDateCreated();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FileSystemElement element : sortedChildren) {
            String formattedDate = dateFormat.format(element.getDateCreated());
            if (element instanceof Directory) {
                System.out.println("* " + element.getName() + "/ (" + formattedDate + ")");
            } else if (element instanceof File) {
                System.out.println(element.getName() + " (" + formattedDate + ")");
            }
        }
    }

    /**
     * Changes the current working directory to the specified path.
     *
     * @param newPath the path of the directory to change to
     */

    public void changeDirectory(String newPath) {
        Directory targetDirectory = this.findDirectory(newPath);
        if (targetDirectory == null) {
            System.out.println("Directory not found.");
        } else {
            this.currentDirectory = targetDirectory;
            System.out.println("Directory changed to: " + findPath(currentDirectory));
        }
    }

    private Directory findDirectory(String path) {
        // split the path into array
        String[] paths = path.split("/");
        Directory current = (Directory) this.root.getChildren().get(0);
        for (String part : paths) {
            if (part.isEmpty() || part.equals(current.getName()))
                continue;
            boolean flag = false;
            for (FileSystemElement element : current.getChildren()) {
                if (element instanceof Directory && element.getName().equals(part)) { // directory found in the path
                    current = (Directory) element;
                    flag = true;
                    break;
                }
            }
            if (!flag)// directory not found in the path
                return null;
        }
        return current;
    }

    /**
     * Deletes the file or directory with the specified name from the current
     * directory.
     *
     * @param input the name of the file or directory to delete
     * @return true if deletion is successful, false otherwise
     */
    public boolean delete(String input) {
        return deleteHelper(0, input);
    }

    private boolean deleteHelper(int index, String input) {
        if (index == currentDirectory.getChildren().size()) // base condition
            return false;
        if (currentDirectory.getChildren().get(index).getName().equals(input)) {
            if (currentDirectory.getChildren().get(index) instanceof Directory) {
                System.out.println("Directory deleted: " + currentDirectory.getChildren().get(index).getName() + "/");
            } else {
                System.out.println("File deleted: " + currentDirectory.getChildren().get(index).getName());
            }
            currentDirectory.removeElement(currentDirectory.getChildren().get(index));
            return true;
        }

        return deleteHelper(++index, input); // go to next child
    }

    /**
     * Moves a file or directory with the specified name to the new directory.
     *
     * @param elementName      the name of the file or directory to move
     * @param newDirectoryPath the path of the directory to move to
     * @return true if the move operation is successful, false otherwise
     */

    public boolean move(String elementName, String newDirectoryPath) {
        FileSystemElement elementToMove = search(elementName);
        if (elementToMove == null) { // checking if element to move exist
            System.out.println("Not found: " + elementName);
            return false;
        }

        Directory targetDirectory = findDirectory(newDirectoryPath);
        if (targetDirectory == null) { // checking if the target directory exist
            System.out.println("Target Not found: " + newDirectoryPath);
            return false;
        }

        if (elementToMove.getParent() == targetDirectory) { // checking if the element to move is under the target directory
            System.out.println("The element is already in the target directory.");
            return false;
        }

        
        if (elementToMove.getParent() instanceof Directory) { // Remove the element from its parent
            ((Directory) elementToMove.getParent()).removeElement(elementToMove);
        }

        // Add the element to its new parent
        targetDirectory.addElement(elementToMove);
        elementToMove.setParent(targetDirectory);
        System.out.println("Moved " + elementName + " to " + newDirectoryPath);

        return true;
    }

    /**
     * Retrieves the root directory of the file system.
     *
     * @return the root directory
     */
    public Directory getRoot() {
        return root;
    }

    /**
     * Retrieves the current working directory of the file system.
     *
     * @return the current working directory
     */
    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

}

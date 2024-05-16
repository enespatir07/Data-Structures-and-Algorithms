import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        System.out.println("===== File System Management Menu =====");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Change directory");
            System.out.println("2. List directory contents");
            System.out.println("3. Create file/directory");
            System.out.println("4. Delete file/directory");
            System.out.println("5. Move file/directory");
            System.out.println("6. Search file/directory");
            System.out.println("7. Print directory tree");
            System.out.println("8. Sort contents by date created");
            System.out.println("9. Exit");
            System.out.print("Please select an option: ");

            String choice = scanner.nextLine();
            System.out.println();

            if (choice.equals("1")) {
                System.out.print("Current directory: " + fs.findPath(fs.getCurrentDirectory()) + "\n");
                System.out.print("Enter new directory path: ");
                String newPath = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
                String regex = "^/home(?:/[^/]+)*$"; // Adjust based on your specific base path and requirements
                if (!Pattern.matches(regex, newPath)) {
                    System.out.println(
                            "Invalid format.\n");
                    continue;
                }
                fs.changeDirectory(newPath);
            }

            else if (choice.equals("2")) {
                System.out.println("Listing contents of " + fs.findPath(fs.getCurrentDirectory()) + ":");
                fs.listContent("");
            }

            else if (choice.equals("3")) {
                System.out.print("Create file or directory (f/d): ");
                String type = scanner.nextLine();
                if (!(type.equals("f") || type.equals("d"))) {
                    System.err.println("Invalid option");
                    continue;
                }
                System.out.print("Enter name for new " + (type.equals("d") ? "directory" : "file") + ": ");
                String name = scanner.nextLine();
                if (name.equals("root") || name.equals("home")) {
                    System.out.println("Invalid\n");
                    continue;
                }
                fs.createFD(type, name);
            }

            else if (choice.equals("4")) {

                System.out.println("Current directory: " + fs.findPath(fs.getCurrentDirectory()));
                System.out.print("Enter name of file/directory to delete: ");
                String input = scanner.nextLine();
                if (input.equals("home") || input.equals("root")) {
                    System.err.println("Invalid");
                    continue;
                }
                if (!fs.delete(input)) {
                    System.out.println("Not found");
                    continue;
                }
            }

            else if (choice.equals("5")) {
                System.out.println("Current directory: " + fs.findPath(fs.getCurrentDirectory()));
                System.out.print("Enter name of file/directory to move: ");
                String fd_name = scanner.nextLine();
                System.out.print("Enter new directory path: ");
                String newPath = scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
                String regex = "^/home(?:/[^/]+)*$"; // Adjust based on your specific base path and requirements
                if (!Pattern.matches(regex, newPath)) {
                    System.out.println(
                            "Invalid format.\n");
                    continue;
                }
                fs.move(fd_name, newPath);
            }

            else if (choice.equals("6")) {
                System.out.print("Search query: ");
                String query = scanner.nextLine();
                FileSystemElement result = fs.search(query);
                if (result != null) {
                    System.out.println("Found " + fs.findPath(result));
                } else {
                    System.out.println("Not found");
                }
            } else if (choice.equals("7")) {
                System.out.println("Path to current directory from root: ");
                fs.printTree();
            } else if (choice.equals("8")) {

                System.out.println("Sorted contents of " + fs.findPath(fs.getCurrentDirectory()) + " by date created:");
                fs.sort();
            }

            else if (choice.equals("9")) {
                break;
            }

            else {
                continue;
            }

            System.out.println();
        }
        scanner.close();

    }
}

import java.util.Scanner;

/**
 * Main class for testing the program
 * 
 */
public class Main {
    /**
     * The main method
     *
     * @param args
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome to the Electronics Inventory Management System!\n");
        // Main menu loop
        while (true) {
            // Display the main menu options
            System.out.println("Please select an option:\r\n" + //
                    "1. Add a new device\r\n" + //
                    "2. Remove a device\r\n" + //
                    "3. Update device details\r\n" + //
                    "4. List all devices\r\n" + //
                    "5. Find the cheapest device\r\n" + //
                    "6. Sort devices by price\r\n" + //
                    "7. Calculate total inventory value\r\n" + //
                    "8. Restock a device\r\n" + //
                    "9. Export inventory report\r\n" + //
                    "0. Exit");

            input = scanner.nextLine();

            // Exit the program if user chooses option 0
            if (input.equals("0")) {
                System.out.println("Exiting program...");
                break;
            }
            // Add a new device to the inventory
            else if (input.equals("1")) {
                System.out.print("\nEnter category name: ");
                String category = scanner.nextLine();
                if (!(category.equals("Smart Phone") || category.equals("Laptop")
                        || category.equals("TV")
                        || category.equals("Smart Watch") || category.equals("Headphones"))) {
                    System.out.println("Error: Undefined Category Name\n");
                    continue;
                }

                System.out.print("Enter device name: ");
                String name = scanner.nextLine();

                double price = 0;
                int quantity = 0;
                try {
                    System.out.print("Enter price: ");
                    price = Double.parseDouble(scanner.nextLine());
                    if (price <= 0) {
                        System.out.println("Error: Price must be greater than 0.\n");
                        continue;
                    }
                    System.out.print("Enter quantity: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                    if (quantity <= 0) {
                        System.out.println("Error: Quantity must be greater than 0.\n");
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Error: Price and quantity must be numeric values.\n");
                    continue;
                }

                if (category.equals("Smart Phone")) {
                    inventory.addDevice(new SmartPhone(name, price, quantity));
                } else if (category.equals("Laptop")) {
                    inventory.addDevice(new Laptop(name, price, quantity));
                } else if (category.equals("TV")) {
                    inventory.addDevice(new TV(name, price, quantity));
                } else if (category.equals("Smart Watch")) {
                    inventory.addDevice(new SmartWatch(name, price, quantity));
                } else if (category.equals("Headphones")) {
                    inventory.addDevice(new Headphones(name, price, quantity));
                }
                System.out.println(category + ", " + name + ", " + price + "$, " + quantity + " amount added...\n");

            }

            // Remove a device from the inventory
            else if (input.equals("2")) {
                System.out.print("\nEnter device name to remove: ");
                String name = scanner.nextLine();

                if (inventory.deviceExists(name)) {
                    inventory.removeDevice(name);
                    System.out.println(name + " removed from inventory.\n");

                } else {
                    System.out.println("Error: Device named " + name + " does not exist in the inventory.\n");
                    continue;
                }

            }
            // Update device details
            else if (input.equals("3")) {
                System.out.print("\nEnter the name of the device to update: ");
                String nameToUpdate = scanner.nextLine();

                if (inventory.deviceExists(nameToUpdate)) {
                    // Fetch the device from the inventory
                    Device deviceToUpdate = inventory.getDeviceByName(nameToUpdate);

                    // Input for new price
                    double newPrice = 0;
                    System.out.print("Enter new price (leave blank to keep current price): ");
                    String newPriceInput = scanner.nextLine();
                    if (!newPriceInput.isBlank()) {
                        try {
                            newPrice = Double.parseDouble(newPriceInput);
                            if (newPrice <= 0) {
                                System.out.println("Error: Price must be a numeric value greater than 0.\n");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Price must be a numeric value greater than 0.\n");
                            continue;
                        }
                    } else {
                        // Keep the original price if the user leaves the field blank
                        newPrice = deviceToUpdate.getPrice();
                    }

                    // Input for new quantity
                    int newQuantity = 0;
                    System.out.print("Enter new quantity (leave blank to keep current quantity): ");
                    String newQuantityInput = scanner.nextLine();
                    if (!newQuantityInput.isBlank()) {
                        try {
                            newQuantity = Integer.parseInt(newQuantityInput);
                            if (newQuantity <= 0) {
                                System.out.println("Error: Quantity must be a numeric value greater than 0.\n");
                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Quantity must be a numeric value greater than 0.\n");
                            continue;
                        }
                    } else {
                        // Keep the original quantity if the user leaves the field blank
                        newQuantity = deviceToUpdate.getQuantity();
                    }

                    // Update the device details
                    inventory.updateDevice(nameToUpdate, newPrice, newQuantity);
                    System.out.println(
                            nameToUpdate + " details updated: Price - " + newPrice + "$" + ", Quantity - " + newQuantity
                                    + "\n");
                } else {
                    System.out.println("Error: Device named " + nameToUpdate + " does not exist in the inventory.\n ");
                    continue;
                }
            }

            // List all devices in the inventory
            else if (input.equals("4")) {

                if (inventory.isEmpty()) {
                    System.out.println("\nError: No devices in inventory.\n");
                    continue;
                } else {
                    System.out.println("\nDevice List:");
                    inventory.displayDevices();
                    System.out.println();
                }
            }
            // Find the cheapest device in the inventory
            else if (input.equals("5")) {

                if (inventory.isEmpty()) {
                    System.out.println("\nError: No devices in inventory.\n");
                    continue;
                } else {
                    System.out.println("The cheapest device is:");
                    inventory.displayDevice(inventory.findCheapestDevice());
                    System.out.println();
                }

            }
            // Sort devices by price
            else if (input.equals("6")) {
                if (inventory.isEmpty()) {
                    System.out.println("\nError: No devices in inventory.\n");
                    continue;
                } else {
                    System.out.println("Devices sorted by price:\n");
                    inventory.sortDevicesByPrice();
                }
            }
            // Calculate total inventory value
            else if (input.equals("7")) {
                System.out.println("\nTotal inventory value: $" + inventory.calculateTotalValue() + "\n");
            }

            // Restock a device in the inventory
            else if (input.equals("8")) {
                if (inventory.isEmpty()) {
                    System.out.println("\nError: No devices in inventory.\n");
                    continue;
                } else {
                    System.out.print("\nEnter the name of the device to restock: ");
                    String name = scanner.nextLine();
                    if (!inventory.deviceExists(name)) {
                        System.out.println("Error: Device named " + name + " does not exist in the inventory.\n");
                        continue;
                    }

                    System.out.print("Do you want to add or remove stock? (Add/Remove): ");
                    String operation = scanner.nextLine();
                    if (!(operation.equals("Add") || operation.equals("Remove"))) {
                        System.out.println("Invalid operation.\n");
                        continue;
                    }
                    System.out.print("Enter the quantity: ");
                    int quantity;
                    try {
                        quantity = Integer.parseInt(scanner.nextLine());
                        if (quantity <= 0) {
                            System.out.println("Error: Quantity must be an integer greater than 0.\n");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid quantity. Please enter an integer.\n");
                        continue;

                    }

                    if (operation.equals("Add")) {
                        inventory.restockDevice(name, quantity);
                        System.out.println(
                                name + " restocked. New quantity: " + inventory.getDeviceQuantity(name) + "\n");
                    } else if (operation.equals("Remove")) {
                        inventory.restockDevice(name, -1 * quantity);
                        System.out.println(
                                name + " stock reduced. New quantity: " + inventory.getDeviceQuantity(name) + "\n");
                    }
                }
            }

            // Export inventory report
            else if (input.equals("9")) {
                if (inventory.isEmpty()) {
                    System.out.println("\nError: Inventory is empty\n");
                    continue;
                } else {
                    System.out.println();
                    inventory.exportInventoryReport();
                    System.out.println();
                }
            }

            else {
                System.err.println("Undefined Option\n");
                continue;
            }
        }

        scanner.close(); // Close scanner outside the loop
    }

}

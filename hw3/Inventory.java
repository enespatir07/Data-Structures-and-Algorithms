import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * The Inventory class manages a collection of devices, providing methods for
 * adding, removing, updating, and displaying devices.
 */
public class Inventory {

    private LinkedList<ArrayList<Device>> devices;

    /**
     * Constructs an Inventory object.
     * Time complexity: O(1)
     * 
     */
    public Inventory() {
        this.devices = new LinkedList<>();
    }

    /**
     * Adds a new device to the inventory.
     * Time complexity: O(1), because max length devices can be is 5 so it is
     * contant
     * 
     * @param device The device to be added.
     * 
     */
    public void addDevice(Device device) {
        boolean foundCategory = false;

        for (ArrayList<Device> categoryList : devices) {
            if (categoryList.get(0).getCategory().equals(device.getCategory())) {
                categoryList.add(device);
                foundCategory = true;
                break;
            }
        }
        if (!foundCategory) {
            ArrayList<Device> newCategory = new ArrayList<>();
            newCategory.add(device);
            devices.add(newCategory);
        }
    }

    /**
     * Removes a device from the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @param name The name of the device to be removed.
     */
    public void removeDevice(String name) {
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getName().equals(name)) {
                    categoryList.remove(device);
                    return;
                }
            }
        }
    }

    /**
     * Checks if a device exists in the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @param name The name of the device to check.
     * @return true if the device exists, otherwise false.
     */
    public boolean deviceExists(String name) {
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getName().equals(name)) {
                    return true; // Device found
                }
            }
        }
        return false; // Device not found
    }

    /**
     * Updates the details of a device in the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @param name     The name of the device to be updated.
     * @param price    The new price of the device.
     * @param quantity The new quantity of the device.
     */
    public void updateDevice(String name, double price, int quantity) {
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getName().equals(name)) {
                    device.setPrice(price);
                    device.setQuantity(quantity);
                    return;
                }
            }
        }
    }

    /**
     * Displays a list of all devices in the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     */
    public void displayDevices() {
        int index = 1;
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                System.out.println(index + ". Category: " + device.getCategory() +
                        ", Name: " + device.getName() +
                        ", Price: " + device.getPrice() + "$" +
                        ", Quantity: " + device.getQuantity());
                index++;
            }
        }
    }

    /**
     * Displays details of a specific device.
     * Time complexity: O(1)
     * 
     * @param device The device to display details for.
     */
    public void displayDevice(Device device) {
        System.out.println("Category: " + device.getCategory() +
                ", Name: " + device.getName() +
                ", Price: " + device.getPrice() + "$" +
                ", Quantity: " + device.getQuantity());
    }

    /**
     * Finds and returns the device with the minimum price in the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @return The device with the minimum price.
     */
    public Device findCheapestDevice() {
        Device cheapestDevice = null;
        double minPrice = Double.MAX_VALUE;
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getPrice() < minPrice) {
                    minPrice = device.getPrice();
                    cheapestDevice = device;
                }
            }
        }
        return cheapestDevice;
    }

    /**
     * Sorts the devices in the inventory by price (ascending order)
     * Time complexity: O(n + n*log(n)), n for iterating over arraylist, n*logn for
     * java collection.sort but over all O(n*log(n))
     * 
     */
    public void sortDevicesByPrice() {
        // copy elements of original devices into tempDevices
        ArrayList<Device> tempDevices = new ArrayList<Device>();
        for (ArrayList<Device> deviceTypeList : devices) {
            for (Device device : deviceTypeList) {
                tempDevices.add(device);
            }
        }

        // Sort
        Collections.sort(tempDevices, Comparator.comparingDouble(Device::getPrice));

        // Print the sorted devices
        for (Device device : tempDevices) {
            System.out.println("Category: " + device.getCategory() +
                    ", Name: " + device.getName() +
                    ", Price: " + device.getPrice() + "$" +
                    ", Quantity: " + device.getQuantity());
        }
        System.out.println();
    }

    /**
     * Retrieves a device from the inventory by its name.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @param name The name of the device to retrieve.
     * @return The device with the specified name, or null if not found.
     */
    public Device getDeviceByName(String name) {
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getName().equals(name)) {
                    return device; // Return the device if found
                }
            }
        }
        return null; // Return null if device not found
    }

    /**
     * Calculates the total value of all devices in the inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @return The total value of the inventory.
     */
    public double calculateTotalValue() {
        double totalValue = 0;
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                totalValue += device.getPrice() * device.getQuantity();
            }
        }
        return totalValue;
    }

    /**
     * Restocks a device in the inventory by adding a specified quantity.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     * 
     * @param name     The name of the device to restock.
     * @param quantity The quantity to add to the device's current quantity.
     */
    public void restockDevice(String name, int quantity) {
        for (ArrayList<Device> categoryList : devices) {
            for (Device device : categoryList) {
                if (device.getName().equals(name)) {
                    device.setQuantity(device.getQuantity() + quantity);
                    return;
                }
            }
        }
    }

    /**
     * Retrieves the quantity of a device in the inventory by its name.
     * Time complexity: O(n), because getDeviceByName takes O(n)
     * 
     * @param name The name of the device to retrieve quantity for.
     * @return The quantity of the device, or -1 if the device is not found.
     */
    public int getDeviceQuantity(String name) {
        Device device = getDeviceByName(name);
        if (device != null) {
            return device.getQuantity();
        } else {
            System.out.println("Device not found.");
            return -1;
        }
    }

    /**
     * Exports an inventory report, displaying details of all devices in the
     * inventory.
     * Time complexity: O(n), because max length devices can be is 5 so it is O(5*n)
     * = O(n)
     */
    public void exportInventoryReport() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
            String formattedDate = currentDate.format(formatter);

            writer.write("Electronics Shop Inventory Report\n");
            writer.write("Generated on: " + formattedDate + "\n");
            writer.write("----------------------------------------------------------------\n");
            writer.write("| No. | Category   | Name               | Price     | Quantity |\n");
            writer.write("----------------------------------------------------------------\n");

            int index = 1;
            double totalValue = 0;
            for (ArrayList<Device> categoryList : devices) {
                for (Device device : categoryList) {
                    writer.write(String.format("| %-4d| %-11s| %-20s| $%-9.2f| %-9d|%n",
                            index, device.getCategory(), device.getName(), device.getPrice(), device.getQuantity()));
                    totalValue += device.getPrice() * device.getQuantity();
                    index++;
                }
            }

            writer.write("----------------------------------------------------------------\n");
            writer.write("Summary:\n");
            writer.write("- Total Number of Devices: " + (index - 1) + "\n");
            writer.write(String.format("- Total Inventory Value: $%.2f%n", totalValue));
            writer.write("End of Report\n");

            System.out.println("Inventory report has been exported to file: " + "report.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Checks if the inventory is empty.
     * Time complexity: O(n)
     * 
     * @return true if the inventory is empty, false otherwise.
     */
    public boolean isEmpty() {
        for (ArrayList<Device> categoryList : devices) {
            if (!categoryList.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves the list of devices in the inventory.
     * Time complexity: O(1)
     * 
     * @return The list of devices in the inventory.
     */
    public LinkedList<ArrayList<Device>> getDevices() {
        return devices;
    }

}

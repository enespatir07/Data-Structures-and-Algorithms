/**
 * The Device interface represents a device with informations such as category, name, price, and quantity.
 */
public interface Device {

    /**
     * Gets the category of the device.
     *
     * @return The category of the device.
     */
    String getCategory();

    /**
     * Gets the name of the device.
     *
     * @return The name of the device.
     */
    String getName();

    /**
     * Sets the name of the device.
     *
     * @param name The new name of the device.
     */
    void setName(String name);

    /**
     * Gets the price of the device.
     *
     * @return The price of the device.
     */
    double getPrice();

    /**
     * Sets the price of the device.
     *
     * @param price The new price of the device.
     */
    void setPrice(double price);

    /**
     * Gets the quantity of the device.
     *
     * @return The quantity of the device.
     */
    int getQuantity();

    /**
     * Sets the quantity of the device.
     *
     * @param quantity The new quantity of the device.
     */
    void setQuantity(int quantity);
}

/**
 * The SmartWatch class represents a specific type of device, namely a
 * smartwatch, implementing the Device interface.
 */
public class SmartWatch implements Device {

    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a new SmartWatch object with the specified name, price, and
     * quantity.
     * Time complexity: O(1)
     * 
     * @param name     The name of the smartwatch.
     * @param price    The price of the smartwatch.
     * @param quantity The quantity of the smartwatch.
     */
    public SmartWatch(String name, double price, int quantity) {
        this.category = "Smart Watch";
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the category of the smartwatch.
     * Time complexity: O(1)
     * 
     * @return The category of the smartwatch.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the name of the smartwatch.
     * Time complexity: O(1)
     * 
     * @return The name of the smartwatch.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the smartwatch.
     * Time complexity: O(1)
     * 
     * @param name The new name of the smartwatch.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the smartwatch.
     * Time complexity: O(1)
     * 
     * @return The price of the smartwatch.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the smartwatch.
     * Time complexity: O(1)
     * 
     * @param price The new price of the smartwatch.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the smartwatch.
     * Time complexity: O(1)
     * 
     * @return The quantity of the smartwatch.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the smartwatch.
     * Time complexity: O(1)
     * 
     * @param quantity The new quantity of the smartwatch.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

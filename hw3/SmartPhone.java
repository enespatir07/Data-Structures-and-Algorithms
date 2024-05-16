/**
 * The SmartPhone class represents a specific type of device, namely a
 * smartphone, implementing the Device interface.
 */
public class SmartPhone implements Device {

    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a new SmartPhone object with the specified name, price, and
     * quantity.
     * Time complexity: O(1)
     * 
     * @param name     The name of the smartphone.
     * @param price    The price of the smartphone.
     * @param quantity The quantity of the smartphone.
     * 
     */
    public SmartPhone(String name, double price, int quantity) {
        this.category = "Smart Phone";
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the category of the smartphone.
     * Time complexity: O(1)
     * 
     * @return The category of the smartphone.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the name of the smartphone.
     * Time complexity: O(1)
     * 
     * @return The name of the smartphone.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the smartphone.
     * Time complexity: O(1)
     * 
     * @param name The new name of the smartphone.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the smartphone.
     * Time complexity: O(1)
     * 
     * @return The price of the smartphone.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the smartphone.
     * Time complexity: O(1)
     * 
     * @param price The new price of the smartphone.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the smartphone.
     * Time complexity: O(1)
     * 
     * @return The quantity of the smartphone.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the smartphone.
     * Time complexity: O(1)
     * 
     * @param quantity The new quantity of the smartphone.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

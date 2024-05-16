/**
 * The TV class represents a specific type of device, namely a television,
 * implementing the Device interface.
 */
public class TV implements Device {

    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a new TV object with the specified name, price, and quantity.
     * Time complexity: O(1)
     * 
     * @param name     The name of the television.
     * @param price    The price of the television.
     * @param quantity The quantity of the television.
     */
    public TV(String name, double price, int quantity) {
        this.category = "TV";
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the category of the television.
     * Time complexity: O(1)
     * 
     * @return The category of the television.
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the name of the television.
     * Time complexity: O(1)
     * 
     * @return The name of the television.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the television.
     * Time complexity: O(1)
     * 
     * @param name The new name of the television.
     *             -
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the television.
     * Time complexity: O(1)
     * 
     * @return The price of the television.
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the television.
     * Time complexity: O(1)
     * 
     * @param price The new price of the television.
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the television.
     * Time complexity: O(1)
     * 
     * @return The quantity of the television.
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the television.
     * Time complexity: O(1)
     * 
     * @param quantity The new quantity of the television.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

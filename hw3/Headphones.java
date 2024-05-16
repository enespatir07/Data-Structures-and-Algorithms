/**
 * The Headphones class represents a specific type of device, namely headphones,
 * implementing the Device interface.
 */
public class Headphones implements Device {

    private String category;
    private String name;
    private double price;
    private int quantity;

    /**
     * Constructs a new Headphones object with the specified name, price, and
     * quantity.
     * Time complexity: O(1)
     *
     * @param name     The name of the headphones.
     * @param price    The price of the headphones.
     * @param quantity The quantity of the headphones.
     */
    public Headphones(String name, double price, int quantity) {
        this.category = "Headphones";
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Retrieves the category of the headphones.
     * Time complexity: O(1)
     * 
     * @return The category of the headphones.
     * 
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Retrieves the name of the headphones.
     * Time complexity: O(1)
     * 
     * @return The name of the headphones.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the headphones.
     * Time complexity: O(1)
     * 
     * @param name The new name of the headphones.
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the price of the headphones.
     * Time complexity: O(1)
     * 
     * @return The price of the headphones.
     * 
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the headphones.
     * Time complexity: O(1)
     * 
     * @param price The new price of the headphones.
     * 
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the headphones.
     * Time complexity: O(1)
     * 
     * @return The quantity of the headphones.
     * 
     */
    @Override
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the headphones.
     * Time complexity: O(1)
     * 
     * @param quantity The new quantity of the headphones.
     */
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

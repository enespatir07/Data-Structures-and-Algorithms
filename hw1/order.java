class order {
    private String productName;
    private int count;
    private int totalPrice;
    private int status;
    private int customerID;

    public order(String productName, int count, int totalPrice, int status, int customerID) {
        this.productName = productName;
        this.count = count;
        this.totalPrice = totalPrice;
        this.status = status;
        this.customerID = customerID;
    }

    public void printOrder() {

        System.out.println("Order # => Product name: " + productName +
                " - Count: " + count +
                " - Total price: " + totalPrice +
                " - Status: " + getStatusString());
    }

    public String getStatusString() {
        switch (status) {
            case 0:
                return "Initialized";
            case 1:
                return "Processing";
            case 2:
                return "Completed";
            case 3:
                return "Cancelled";
            default:
                return "Unknown";
        }
    }

    // getters

    public String getProductName() {
        return productName;
    }

    public int getCount() {
        return count;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getStatus() {
        return status;
    }

    public int getCustomerID() {
        return customerID;
    }
}
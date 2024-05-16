class customer extends person {
    private int operatorID;
    private order[] orders;
    private int orderCount;

    public customer(String name, String surname, String address, String phone, int ID, int operatorID) {
        super(name, surname, address, phone, ID);
        this.operatorID = operatorID;
        this.orders = new order[100];
        this.orderCount = 0;
    }

    public void defineOrders(order[] orderArr) {
        orders = new order[orderArr.length];
        for (order order : orderArr) {
            if (order != null && order.getCustomerID() == getID()) {
                orders[orderCount++] = order;
            }
        }

    }

    public void printOrders() {
        if (isArrayFilled(orders) == 0) {
            System.out.println("----------------------------");
            System.out.println("This customer doesn't have any orders.");
            return;
        } else {
            int count = 1;
            for (int i = 0; i < orders.length; i++) {
                order currOrder = orders[i];
                if (currOrder != null) {
                    System.out.println("Order #" + count + " => Product name: " + currOrder.getProductName() +
                            " - Count: " + currOrder.getCount() +
                            " - Total price: " + currOrder.getTotalPrice() +
                            " - Status: " + currOrder.getStatusString());
                    count++;
                }

            }
        }

    }

    public void printCustomer() {
        // Print customer's information
        System.out.println("*** Customer Screen ***");
        System.out.println("Name & Surname: " + getName() + " " + getSurname());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Operator ID: " + operatorID);
        if (this instanceof corporate_customer) {
            corporate_customer corporateCustomer = (corporate_customer) this;
            System.out.println("Company name: " + corporateCustomer.getCompanyName());
        }
        printOrders();
    }

    public int isArrayFilled(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return 1; // Array contains some data
            }
        }
        return 0; // Array is empty
    }

    // getters
    public int getOperatorID() {
        return operatorID;
    }

    public order[] getOrders() {
        return orders;
    }

    public int getOrderCount() {
        return orderCount;
    }

}
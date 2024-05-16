class operator extends person {
    private int wage;
    private customer[] customers;
    private int customerCount;

    public operator(String name, String surname, String address, String phone, int ID, int wage) {
        super(name, surname, address, phone, ID);
        this.wage = wage;
        this.customers = new customer[100];
        this.customerCount = 0;
    }

    public void defineCustomers(customer[] customerArr) {
        customers = new customer[customerArr.length];
        for (customer customer : customerArr) {
            if (customer != null && customer.getOperatorID() == getID()) {
                customers[customerCount++] = customer;
            }
        }

    }

    public void printOperator() {
        System.out.println("*** Operator Screen ***");
        System.out.println("----------------------------");
        System.out.println("Name & Surname: " + getName() + " " + getSurname());
        System.out.println("Address: " + getAddress());
        System.out.println("Phone: " + getPhone());
        System.out.println("ID: " + getID());
        System.out.println("Wage: " + getWage());
        System.out.println("----------------------------");
        if (isArrayFilled(customers) == 1) {
            printCustomers();
        } else {
            System.out.println("This operator doesn't have any customer.");
            System.out.println("----------------------------");
            return;
        }

    }

    public void printCustomers() {
        int cnt = 1;
        for (int i = 0; i < customers.length; i++) {
            customer currCustomer = customers[i];
            if (currCustomer != null) {
                System.out.print("Customer #" + cnt + " ");
                if (currCustomer instanceof corporate_customer) {
                    System.out.println("(corporate customer)");
                } else if (currCustomer instanceof retail_customer) {
                    System.out.println("(retail customer)");
                }
                System.out.println("Name & Surname: " + currCustomer.getName() + " " + currCustomer.getSurname());
                System.out.println("Address: " + currCustomer.getAddress());
                System.out.println("Phone: " + currCustomer.getPhone());
                System.out.println("ID: " + currCustomer.getID());
                System.out.println("Operator ID: " + currCustomer.getOperatorID());
                if (currCustomer instanceof corporate_customer) {
                    corporate_customer corporateCustomer = (corporate_customer) currCustomer;
                    System.out.println("Company name: " + corporateCustomer.getCompanyName());
                }
                currCustomer.printOrders();
                System.out.println("----------------------------");
                cnt++;
            }
        }
    }

    public int isArrayFilled(Object[] array) {
        for (Object element : array) {
            if (element != null) {
                return 1; // Array is filled
            }
        }
        return 0; // Array is not filled
    }

    // getters

    public int getWage() {
        return wage;
    }

    public customer[] getCustomers() {
        return customers;
    }

    public int getCustomerCount() {
        return customerCount;
    }

}
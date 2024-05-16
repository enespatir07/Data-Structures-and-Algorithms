public class retail_customer extends customer {

    public retail_customer(String name, String surname, String address, String phone, int ID,
            int operatorID) {
        super(name, surname, address, phone, ID, operatorID);
    }

    public void printCustomer() {
        super.printCustomer();
        System.out.println("----------------------------");
    }

}

public class corporate_customer extends customer {

    private String companyName;

    public corporate_customer(String name, String surname, String address, String phone, int ID,
            int operatorID, String companyName) {
        super(name, surname, address, phone, ID, operatorID);
        this.companyName = companyName;
    }

    // Getter for company name
    public String getCompanyName() {
        return companyName;
    }
}

package models;

public class customer {
    private int id;
    private String customerName;
    private String idNumber;

    public customer(String incustomerName, String inidNumber) {
        customerName = incustomerName;
        idNumber = inidNumber;
    }

    public void editCustomer(String newCustomerName, String newIdNumber) {
        customerName = newCustomerName;
        idNumber = newIdNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIdNumber() {
        return idNumber;
    }
}

package repository;

import models.customer;
import java.util.HashMap;

public class customerRepo {
    private HashMap<String, customer> customerList = new HashMap<>();

    public void addCustomer(String customerName, String idNumber) {
        customer cust = new customer(customerName, idNumber);
        customerList.put(cust.getCustomerName(), cust);
    }

    public void listofcustomer() {
        System.out.println();
        for (String key : customerList.keySet()) {
            System.out.println(key + " " + customerList.get(key).getCustomerName());
        }
    }

    public HashMap<String, customer> getCustomerlist() {
        return customerList;
    }

    public void deletecustomer(String id) {
        System.out.println();
        if (customerList.containsKey(id)) {
            System.out.println("Customer : " + id  + " is deleted");
            customerList.remove(id);
        } else {
            System.out.println("This ID is not here");
        }
    }

    public void updatecustomer(int id, String name, String idnumber) {
        System.out.println();
        if (customerList.containsKey(id)) {
            System.out.print("Customer  : " + id + " is updated to ");
            customerList.get(id).editCustomer(name, idnumber);
            System.out.println(customerList.get(id).getCustomerName());
        } else {
            System.out.println("This ID is not here");
        }
    }
}

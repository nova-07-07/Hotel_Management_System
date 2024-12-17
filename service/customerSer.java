package service;

import models.customer;
import repository.customerRepo;

import java.util.HashMap;

public class customerSer {
    private customerRepo repo = new customerRepo();

    public void addCustomer(String customerName, String idNumber) {
        repo.addCustomer(customerName, idNumber);
    }

    public HashMap<String, customer> getCustomerList() {
        return repo.getCustomerlist();
    }

    public void updateCustomer(int id, String name, String idNumber) {
        repo.updatecustomer(id, name, idNumber);
    }

    public void deleteCustomer(String id) {
        repo.deletecustomer(id);
    }
}

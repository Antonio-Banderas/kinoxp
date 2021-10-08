package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.CustomerRepo;
import edu.kea.kinoxp.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> fetchAllCustomers() {
        return customerRepo.fetchAllCustomers();
    }

    public int createCustomer(Customer c){
        return customerRepo.createCustomer(c);
    }

    public void updateCustomer(Customer c){
        customerRepo.updateCostumer(c);
    }

    public Customer fetchCustomerByID(int customerID){
        return customerRepo.fetchCustomerByID(customerID);
    }

    public void deleteCustomer(int idCustomer) {
        customerRepo.deleteCustomer(idCustomer);
    }
}

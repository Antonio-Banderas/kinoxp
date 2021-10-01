package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.CustomerRepo;
import edu.kea.kinoxp.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public Customer createCustomer(Customer c){
        return customerRepo.createCustomer(c);
    }

    public void updateCustomer(Customer c){
        customerRepo.updateCostumer(c);
    }
}

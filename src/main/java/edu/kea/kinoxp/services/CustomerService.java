package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public void updateCustomer(Customer c){
        customerRepo.updateCostumer(c);
    }
}

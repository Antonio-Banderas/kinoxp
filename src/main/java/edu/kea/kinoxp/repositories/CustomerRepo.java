package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public void updateCostumer(Customer c){
        String sql = "UPDATE customers SET firstname = ?, lastname = ?, phonenumber = ?, email = ? WHERE idcustomer = ?";
        template.update(sql, c.getFirstName(), c.getLastName(), c.getPhoneNumber(), c.getEmail());
    }

}

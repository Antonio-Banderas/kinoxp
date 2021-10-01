package edu.kea.kinoxp.repositories;


import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public Customer createCustomer(Customer c) {
        String sql = "INSERT INTO customers(firstname,lastname,phonenumber, email) VALUES (?, ?, ?, ?)";
        template.update(sql, c.getFirstName(),c.getLastName(), c.getPhoneNumber(), c.getEmail());
        return c;
    }

    public void updateCostumer(Customer c){
        String sql = "UPDATE customers SET firstname = ?, lastname = ?, phonenumber = ?, email = ? WHERE idcustomer = ?";
        template.update(sql, c.getFirstName(), c.getLastName(), c.getPhoneNumber(), c.getEmail());
    }

    public Customer fetchCustomerByID(int customerID) {
        String sql = "SELECT * FROM customers WHERE idcustomer = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, customerID);
        return customer;
    }


}

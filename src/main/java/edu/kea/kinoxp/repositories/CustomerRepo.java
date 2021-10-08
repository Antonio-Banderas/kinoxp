package edu.kea.kinoxp.repositories;


import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepo {
    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAllCustomers() {
        String sql = "SELECT * FROM customers";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public int createCustomer(Customer c) {
        String sql = "INSERT INTO customers(firstname,lastname,phonenumber, email) VALUES (?, ?, ?, ?)";
        //template.update(sql, c.getFirstname(),c.getLastname(), c.getPhonenumber(), c.getEmail());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[] {"id"});
                        ps.setString(1, c.getFirstname());
                        ps.setString(2, c.getLastname());
                        ps.setInt(3,c.getPhonenumber());
                        ps.setString(4,c.getEmail());
                        return ps;
                    }
                },
                keyHolder);
// keyHolder.getKey() now contains the generated key

        return keyHolder.getKey().intValue();
    }

    public void updateCostumer(Customer c){
        String sql = "UPDATE customers SET firstname = ?, lastname = ?, phonenumber = ?, email = ? WHERE idcustomer = ?";
        template.update(sql, c.getFirstname(), c.getLastname(), c.getPhonenumber(), c.getEmail(), c.getIdcustomer());
    }

    public Customer fetchCustomerByID(int customerID) {
        String sql = "SELECT * FROM customers WHERE idcustomer = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, customerID);
        return customer;
    }

    public void deleteCustomer(int customerID){
        String sql = "DELETE FROM customers where idcustomer = ?";
        template.update(sql, customerID);
    }


}

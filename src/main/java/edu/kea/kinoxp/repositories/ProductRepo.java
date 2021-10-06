package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Product;
import edu.kea.kinoxp.models.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {
    @Autowired
    JdbcTemplate template;

    public List<Product> fetchAllProducts() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    public Product createProduct(Product p) {
        String sql = "INSERT INTO products(name,price) VALUES (?, ?)";
        template.update(sql, p.getName(), p.getPrice());
        return p;
    }

    public void updateProduct(Product p){
        String sql = "UPDATE products SET name = ?, price = ? WHERE idproducts = ?";
        template.update(sql, p.getName(), p.getPrice(), p.getIdproducts());
    }
    public boolean deleteProduct(int productid){
        String sql = "DELETE FROM products where idproducts = ?";
        return template.update(sql, productid) < 0;
    }
    public Product getProductByID(int id){
        String sql ="SELECT * FROM products WHERE idproducts = ?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql, rowMapper, id);
    }
}

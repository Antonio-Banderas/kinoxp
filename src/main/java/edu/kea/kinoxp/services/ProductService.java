package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Product;
import edu.kea.kinoxp.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> fetchAllProducts() {
        return productRepo.fetchAllProducts();
    }
    public Product createProduct(Product p) {
        return productRepo.createProduct(p);
    }
    public void updateProducts(Product p) {
        productRepo.updateProduct(p);
    }
    public boolean deleteProduct(int id) {
        return productRepo.deleteProduct(id);
    }
    public Product getProduct(int idproducts){
        return productRepo.getProductByID(idproducts);
    }
}

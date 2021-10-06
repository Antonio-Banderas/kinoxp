package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Product;
import edu.kea.kinoxp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.fetchAllProducts());
        return "products/products.html";
    }
    @GetMapping("/create-product")
    public String createProducts() {
        return "products/create-product.html";
    }
    @PostMapping("/create-product")
    public String createProduct(@RequestParam("name") String name, @RequestParam("price") String price) {
        Product p = new Product(name, Double.parseDouble(price));
        productService.createProduct(p);
        return "redirect:/products";
    }
    @GetMapping("/products/{id}/edit")
    public String editProductPage(Model model, @PathVariable int id) {
        Product p = productService.getProduct(id);
        model.addAttribute("product", p);
        return "products/edit-product.html";
    }
    @PostMapping("/edit-product")
    public String editProduct(@ModelAttribute Product p) {
        productService.updateProducts(p);
        return "redirect:/products/";
    }
    @GetMapping("/deleteproduct/{idproducts}")
    public String deleteProduct(@PathVariable("idproducts") int idproducts){
        boolean deleted = productService.deleteProduct(idproducts);
        if (deleted) {
            return "redirect:/products/";
        }else {
            return "redirect:/products/";
        }
    }


}

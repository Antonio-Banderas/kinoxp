package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/customer")
  public String getCustomerPage(){
    return "customer/create-customer.html";
  }

  @PostMapping("/create-customer")
  public String createCustomer(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("phonenumber") String phoneNumber, @RequestParam("email") String email){
    Customer c = new Customer(firstName,lastName,Integer.parseInt(phoneNumber),email);
    customerService.createCustomer(c);
    return "redirect:/movies";
  }

  @GetMapping("/customers/{id}/edit")
  public String editCustomerPage(Model model, @PathVariable int id){
    Customer customer = customerService.fetchCustomerByID(id);
    model.addAttribute("customer", customer);
    return "customer/edit-customer.html";
  }

  @PostMapping("/edit-customer")
  public String editCustomer(@ModelAttribute Customer c){
    System.out.println("working"+c.toString());
    customerService.updateCustomer(c);
    return "redirect:/";
  }
  @PostMapping("/deleteCustomer")
  public String deleteCustomer(@RequestParam int idCustomer){
    customerService.deleteCustomer(idCustomer);
    return "redirect:/movies";
  }


}

package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
  @Autowired
  CustomerService customerService;

/*
  @GetMapping("/customers/{id}/edit")
  public String editCustomerPage(Model model, @PathVariable int id){
    Customer customer = customerService.getCustomer(id);
    model.addAttribute("customer", customer);
    return "edit-movie.html";
  }

  @PostMapping("/editCustomer")
  public String editCustomer(@ModelAttribute Customer c){
    customerService.updateCustomer(c);
    return "redirect:/movies/" + c.getId();
  }
*/

}

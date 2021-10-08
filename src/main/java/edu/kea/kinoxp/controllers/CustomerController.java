package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Reservation;
import edu.kea.kinoxp.models.seat_reserved;
import edu.kea.kinoxp.services.CustomerService;
import edu.kea.kinoxp.services.ReservationService;
import edu.kea.kinoxp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @Autowired
  ReservationService reservationService;

  @GetMapping("/customers")
  public String getCustomerPage(Model model){
    model.addAttribute("customers", customerService.fetchAllCustomers());
    return "customer/customers.html";
  }

  @PostMapping("/customer")
  public String postScreeningAndSeats(Model model, @RequestParam(name="screening") Long screeningID, @RequestParam(name="seats") String[] seats){
    model.addAttribute("screening", screeningID);
    model.addAttribute("seats", seats);
    return "customer/create-customer.html";
  }

  @PostMapping("/create-customer/{screeningid}")
  public String createCustomer(@ModelAttribute Customer customer,@PathVariable("screeningid") int screeningid,@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("phonenumber") String phoneNumber, @RequestParam("email") String email){
    int customerID = customerService.createCustomer(customer);
    seat_reserved seatObj = reservationService.getSeatReservedFromID(screeningid);
    Reservation reservation = new Reservation(seatObj.getId_seat_reserved(),seatObj.getId_screenings(),seatObj.getId_seats(),customerID);
    int reservationID = reservationService.createReservation(reservation);

    System.out.println(reservationID);
    return "redirect:/confirmation/"+ reservationID;
  }




  @GetMapping("/confirmation/{reservationid}")
  public String getConfirmation(Model model, @PathVariable("reservationid") int reservationID){
    Reservation reservation = reservationService.getReservationFromID(reservationID);
    model.addAttribute("reservation", reservation);

    return "screening/confirmation.html";
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
  @GetMapping("/customers/{id}/delete")
  public String deleteCustomer(@PathVariable int id){
    customerService.deleteCustomer(id);
    return "redirect:/customers";
  }


}

package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Customer;
import edu.kea.kinoxp.models.Reservation;
import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.models.seat_reserved;
import edu.kea.kinoxp.services.CustomerService;
import edu.kea.kinoxp.services.ReservationService;
import edu.kea.kinoxp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @Autowired
  ReservationService reservationService;

  @Autowired
  ScreeningService screeningService;

  @GetMapping("/customers")
  public String getCustomerPage(Model model){
    model.addAttribute("customers", customerService.fetchAllCustomers());
    return "customer/customers.html";
  }

  @PostMapping("/customer")
  public String postScreeningAndSeats(Model model, @RequestParam(name="screening") Long screeningID, @RequestParam(name="seats") String [] seats){
    String str = Arrays.toString(seats).replaceAll(" ","");
    System.out.println(str);

    model.addAttribute("screening", screeningID);
    model.addAttribute("seats",str);
    return "customer/create-customer.html";
  }


  @PostMapping("/create-customer")
  public String createCustomer(@ModelAttribute Customer customer,  @RequestParam("screeningID") int screeningid, @RequestParam("seats") String seats, @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName, @RequestParam("phonenumber") String phoneNumber, @RequestParam("email") String email){
    int customerID = customerService.createCustomer(customer);
    String [] seatNumbers = seats.split(",");
    int [] parsedSeatNumbers = new int[seatNumbers.length];

    for(int i = 0; i< seatNumbers.length; i++){
      parsedSeatNumbers[i] = Integer.parseInt(seatNumbers[i]);
    }

    seat_reserved seatObj = reservationService.getSeatReservedFromID(screeningid);
    Reservation reservation = new Reservation(seatObj.getId_seat_reserved(),seatObj.getId_screenings(),seatObj.getId_seats(),customerID);


    int reservationID = reservationService.createReservation(reservation);

    //screeningService.addSeatsToSeatsReserved(screeningid,reservationID,parsedSeatNumbers);

    return "redirect:/";
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

package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.services.EmployeeService;
import edu.kea.kinoxp.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("addEmployeePage")
    public String addEmployeeForm(){
        return "/employee/addEmployee.html";
    }

    @PostMapping("/addEmployee")
    public String changeEmployeeName(@RequestParam("employeename") String navn){
        employeeService.changeEmployeeName(navn);
        return "redirect:/#";
    }
}

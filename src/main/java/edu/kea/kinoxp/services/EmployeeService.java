package edu.kea.kinoxp.services;

import edu.kea.kinoxp.repositories.EmployeeRepo;
import edu.kea.kinoxp.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    public void changeEmployeeName(String name){
        employeeRepo.changeEmployeeName(name);
    }

}

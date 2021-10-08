package edu.kea.kinoxp.controllers;
import edu.kea.kinoxp.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@ControllerAdvice("edu.kea.kinoxp.controllers")
public class GlobalController {
    @Autowired
    JdbcTemplate template;


    @ModelAttribute("employee")
    public String addGlobalEmail() {
        String sql = "SELECT name FROM employee WHERE idemployee=?";
        String name = (String) template.queryForObject(sql, new Object[] { 1 }, String.class);
        return name;
    }

}

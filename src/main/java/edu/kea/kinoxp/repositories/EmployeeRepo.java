package edu.kea.kinoxp.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepo {
    @Autowired
    JdbcTemplate template;

    public void changeEmployeeName(String name){
        String sql = "UPDATE employee SET name = ? WHERE idemployee = ?";
        template.update(sql,name,1);
    }

}

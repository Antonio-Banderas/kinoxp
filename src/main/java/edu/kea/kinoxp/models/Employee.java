package edu.kea.kinoxp.models;

import javax.persistence.Id;

public class Employee {
    @Id
    int idemployee;
    String name;

    public Employee(int idemployee, String name) {
        this.idemployee = idemployee;
        this.name = name;
    }

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package edu.kea.kinoxp.models;


import javax.persistence.Entity;
import javax.persistence.Id;

public class Customer {
    @Id
    private int idcustomer;
    private String firstname;
    private String lastname;
    private int phonenumber;
    private String email;

    public Customer(int idcustomer, String firstname, String lastname, int phonenumber, String email) {
        this.idcustomer = idcustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Customer() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "idcustomer=" + idcustomer +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phonenumber=" + phonenumber +
                ", email='" + email + '\'' +
                '}';
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

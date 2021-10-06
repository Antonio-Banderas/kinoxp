package edu.kea.kinoxp.models;

public class Reservation {
    private int idseats_reserved;
    private int screening_idscreening;
    private int seats_idseats;
    private int customers_idcustomer;

    public Reservation(int idseats_reserved, int screening_idscreening, int seats_idseats, int customers_idcustomer) {
        this.idseats_reserved = idseats_reserved;
        this.screening_idscreening = screening_idscreening;
        this.seats_idseats = seats_idseats;
        this.customers_idcustomer = customers_idcustomer;
    }

    public Reservation(){

    }

    public int getIdseats_reserved() {
        return idseats_reserved;
    }

    public void setIdseats_reserved(int idseats_reserved) {
        this.idseats_reserved = idseats_reserved;
    }

    public int getScreening_idscreening() {
        return screening_idscreening;
    }

    public void setScreening_idscreening(int screening_idscreening) {
        this.screening_idscreening = screening_idscreening;
    }

    public int getSeats_idseats() {
        return seats_idseats;
    }

    public void setSeats_idseats(int seats_idseats) {
        this.seats_idseats = seats_idseats;
    }

    public int getCustomers_idcustomer() {
        return customers_idcustomer;
    }

    public void setCustomers_idcustomer(int customers_idcustomer) {
        this.customers_idcustomer = customers_idcustomer;
    }
}

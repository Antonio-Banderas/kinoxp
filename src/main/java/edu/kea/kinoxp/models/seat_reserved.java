package edu.kea.kinoxp.models;

public class seat_reserved {
    private int id_seat_reserved;
    private int id_reservations;
    private int id_screenings;
    private int id_seats;

    public seat_reserved(int id_seat_reserved, int id_reservations, int id_screenings, int id_seats) {
        this.id_seat_reserved = id_seat_reserved;
        this.id_reservations = id_reservations;
        this.id_screenings = id_screenings;
        this.id_seats = id_seats;
    }

    public seat_reserved(){

    }

    public int getId_seat_reserved() {
        return id_seat_reserved;
    }

    public void setId_seat_reserved(int id_seat_reserved) {
        this.id_seat_reserved = id_seat_reserved;
    }

    public int getId_reservations() {
        return id_reservations;
    }

    public void setId_reservations(int id_reservations) {
        this.id_reservations = id_reservations;
    }

    public int getId_screenings() {
        return id_screenings;
    }

    public void setId_screenings(int id_screenings) {
        this.id_screenings = id_screenings;
    }

    public int getId_seats() {
        return id_seats;
    }

    public void setId_seats(int id_seats) {
        this.id_seats = id_seats;
    }
}

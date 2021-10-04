package edu.kea.kinoxp.models;

public class Seat {

    private int idseats;
    private int rownumber;
    private int seatnumber;
    private int cinemas_idcinemahall;

    public Seat(int idseats, int rownumber, int seatnumber, int cinemas_idcinemahall) {
        this.idseats = idseats;
        this.rownumber = rownumber;
        this.seatnumber = seatnumber;
        this.cinemas_idcinemahall = cinemas_idcinemahall;
    }

    public Seat(){}

    public int getIdseats() {
        return idseats;
    }

    public void setIdseats(int idseats) {
        this.idseats = idseats;
    }

    public int getRownumber() {
        return rownumber;
    }

    public void setRownumber(int rownumber) {
        this.rownumber = rownumber;
    }

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public int getCinemas_idcinemahall() {
        return cinemas_idcinemahall;
    }

    public void setCinemas_idcinemahall(int cinemas_idcinemahall) {
        this.cinemas_idcinemahall = cinemas_idcinemahall;
    }
}

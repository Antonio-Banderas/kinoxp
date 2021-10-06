package edu.kea.kinoxp.models;

import lombok.Data;

@Data
public class Seat {

    private Long idseats;

    private int seatnumber;

    private int rownumber;

    private int cinemas_idcinemahall;
}

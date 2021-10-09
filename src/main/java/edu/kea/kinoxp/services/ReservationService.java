package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Reservation;
import edu.kea.kinoxp.models.seat_reserved;
import edu.kea.kinoxp.repositories.ReservationRepo;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService{

    @Autowired
    ReservationRepo reservationRepo;

    public Reservation getReservationFromID(int id){
        return reservationRepo.getReservationFromID(id);
    }

    public int createReservation(Reservation r){
        return reservationRepo.createReservation(r);
    }

    public List<seat_reserved> getSeatReservedFromID(int id){
        return reservationRepo.getSeatReservedFromId(id);
    }

}

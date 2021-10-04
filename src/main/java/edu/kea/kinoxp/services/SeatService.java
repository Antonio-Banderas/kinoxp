package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Seat;
import edu.kea.kinoxp.repositories.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    SeatRepo seatRepo;

    public List<Seat> fetchAllByCinemaID(int cinemaID) {
        return seatRepo.fetchAllByCinemaID(cinemaID);
    }

    public Integer fetchMaxRowCount(int cinemaID) {
        return seatRepo.fetchMaxRowCount(cinemaID);
    }

    public Integer fetchMaxSeatNumCount(int cinemaID) {
        return seatRepo.fetchMaxSeatNumCount(cinemaID);
    }

}

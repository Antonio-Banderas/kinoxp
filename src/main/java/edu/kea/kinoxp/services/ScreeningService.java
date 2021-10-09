package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Reservation;
import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.models.Seat;
import edu.kea.kinoxp.models.seat_reserved;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    ScreeningRepo screeningRepo;

    public Screening getScreeningByID(long id){
        return screeningRepo.getScreeningByID(id);
    }

    public List<Screening> getAllScreeningsByDate() {
        return screeningRepo.fetchAllScreeningsByDate();
    }

    public void addSeatsToSeatsReserved(int[] seatsArr, int screeningID){
        screeningRepo.addSeatsToSeatsReserved(seatsArr,screeningID);
    }

    public List<Screening> getAllScreeningsByDateAndHall(int cinemas_idcinemahall) {
        return screeningRepo.fetchAllScreeningsByDateAndHall(cinemas_idcinemahall);
    }

    // create screening
    public Screening createScreening(Screening s) {
        return screeningRepo.createScreening(s);
    }


    public List<Screening> fetchAllScreeningsById(int id) {
        return screeningRepo.fetchAllScreeningsById(id);
    }

    public List<LocalDate> fetchAllDatesForMovie(int movieid) {
        return screeningRepo.fetchAllDatesForMovie(movieid);
    }

    public List<Seat> getOccupiedSeatsByScreeningID(Long id){
        return screeningRepo.getOccupiedSeatsByScreeningID(id);
    }

}

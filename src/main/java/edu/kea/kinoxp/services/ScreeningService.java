package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Screening;
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


    public List<Screening> getAllScreeningsByDate() {
        return screeningRepo.fetchAllScreeningsByDate();
    }

    public List<Screening> getAllScreeningsByDateAndHall(int cinemas_idcinemahall) {
        return screeningRepo.fetchAllScreeningsByDateAndHall(cinemas_idcinemahall);
    }

    // create screening
    public Screening createScreening(Screening s) {
        return screeningRepo.createScreening(s);
    }


    public List<Screening> fetchAllScreeningsByMovieId(int movieid) {
        return screeningRepo.fetchAllScreeningsByMovieId(movieid);
    }

    public List<LocalDate> fetchAllDatesForMovie(int movieid) {
        return screeningRepo.fetchAllDatesForMovie(movieid);
    }

    public Screening fetchScreeningById(int screeningid){
        return screeningRepo.fetchScreeningById(screeningid);
    }

}

package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    ScreeningRepo screeningRepo;

    public List<Screening> getAllScreeningsByDate() {
        return screeningRepo.fetchAllScreeningsByDate();
    }

    // create screening
    public Screening createScreening(Screening s){
        return screeningRepo.createScreening(s);
    }



    // create screening

    public List<Screening> fetchAllScreeningsById(int id) {
        return screeningRepo.fetchAllScreeningsById(id);
    }



}

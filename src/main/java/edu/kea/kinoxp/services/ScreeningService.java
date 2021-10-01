package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    ScreeningRepo screeningRepo;

    // create screening to date

    // get all by date
    public List<Screening> getAllScreeningsByDate(String date) {
        System.out.println(date);
        return screeningRepo.fetchAllScreeningsByDate(date);
    }

    // create screening


}

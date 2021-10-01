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

    public List<Screening> getAllScreeningsByDate(String date) {
        return screeningRepo.fetchAllScreeningsByDate(date);
    }


}

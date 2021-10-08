package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.services.MovieService;
import edu.kea.kinoxp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ScreeningController {

    @Autowired
    MovieService movieService;
    @Autowired
    ScreeningService screeningService;


    @GetMapping("/movies/{id}/screening")
    public String renderCreateScreening(@PathVariable int id, Model model){

        model.addAttribute("movie",movieService.getMovie(id));

        model.addAttribute("screenings1",screeningService.getAllScreeningsByDateAndHall(1));
        model.addAttribute("screenings2",screeningService.getAllScreeningsByDateAndHall(2));

        return "screening/create-screening";
    }

    @PostMapping("/create-screening")
    public String createScreening(@ModelAttribute Screening s){
        System.out.println(s.getDate().toString());
        screeningService.createScreening(s);
        return "index/frontpage";

    }

    @GetMapping("/screenings/{id}")
    public String seatSelection(@PathVariable Long id, Model model) {
        model.addAttribute("screening", screeningService.getScreeningByID(id));
        model.addAttribute("seats", screeningService.getOccupiedSeatsByScreeningID(id));
        //System.out.println(screeningService.getOccupiedSeatsByScreeningID(id));
        return "screening/cinema-seats";
    }


    @PostMapping("/selectedSeats")
    public String selectedSeats(@RequestBody String allBody) {
        System.out.println(allBody);
        List<Integer> selectedSeatIDs = Arrays.stream(allBody.split("=on&|=on"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println(selectedSeatIDs);

        return "customer/create-customer";
    }

}

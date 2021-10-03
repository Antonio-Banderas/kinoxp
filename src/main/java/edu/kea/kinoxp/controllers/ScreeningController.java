package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.services.MovieService;
import edu.kea.kinoxp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ScreeningController {

    @Autowired
    MovieService movieService;
    @Autowired
    ScreeningService screeningService;


    @GetMapping("/movies/{id}/screening")
    public String renderCreateScreening(@PathVariable int id, Model model){

        model.addAttribute("movie",movieService.getMovie(id));
        model.addAttribute("screenings",screeningService.getAllScreeningsByDate());

        return "create-screening";
    }

    @PostMapping("/create-screening")
    public String createScreening(@ModelAttribute Screening s){
        screeningService.createScreening(s);
        return "frontpage";
    }

    @GetMapping("/screenings/{id}")
    public String seatSelection(@PathVariable int id, Model model) {
        return "cinema-seats";
    }
}

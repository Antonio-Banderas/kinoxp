package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.repositories.ScreeningRepo;
import edu.kea.kinoxp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ScreeningController {

    @Autowired
    MovieService movieService;
    ScreeningRepo screeningRepo;

    @GetMapping("/movies/{id}/screening")
    public String createScreening(@PathVariable int id, Model model){

        String today = "mandag"; // this should be a service that finds current date
        model.addAttribute("film",movieService.getMovie(id));
        model.addAttribute("otherMovies",screeningRepo.fetchAllScreeningsByDate(today));

        // get movies from this date

        // model.add(dato,


        return "create-screening.html";
    }

}

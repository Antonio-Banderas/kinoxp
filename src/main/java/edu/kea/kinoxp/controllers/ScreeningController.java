package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Screening;
import edu.kea.kinoxp.services.MovieService;
import edu.kea.kinoxp.services.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ScreeningController {

    @Autowired
    MovieService movieService;
    @Autowired
    ScreeningService screeningService;


    @GetMapping("/movies/{id}/screening")
    public String renderCreateScreening(@PathVariable int id, Model model){

        String screendatetime = "mandag"; // this should be a service that finds current date
        System.out.println("trash");

        List<Screening> list = screeningService.getAllScreeningsByDate(screendatetime);

        model.addAttribute("film",movieService.getMovie(id));
        model.addAttribute("other", list);

        // get movies from this date

        // model.add(dato,

        return "create-screening";
    }

}

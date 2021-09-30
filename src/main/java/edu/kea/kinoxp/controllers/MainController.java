package edu.kea.kinoxp.controllers;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.MovieRepo;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import edu.kea.kinoxp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    MovieService movieService;
    ScreeningRepo screeningRepo;

    //SIDER
    @GetMapping("/")
    public String renderFrontpage(){
        return "frontpage";
    }

    @GetMapping("/movies")
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.fetchAllMovies());
        return "movies.html";
    }

    @GetMapping("/movies/{id}")
    public String getSpecificMovie(@PathVariable int id, Model model){
        model.addAttribute("film",movieService.getMovie(id));
        return "movie.html";
    }

    @GetMapping("/movies/{id}/screening")
    public String createScreening(@PathVariable int id, Model model){

        String today = "mandag"; // this should be a service that finds current date
        model.addAttribute("film",movieService.getMovie(id));
        model.addAttribute("otherMovies",screeningRepo.fetchAllScreeningsByDate(today));

        // get movies from this date

        // model.add(dato,


        return "create-screening.html";
    }

    @GetMapping("/create-movie-page")
    public String renderMoviePage(){
        return "create-movie";
    }

    //SC

    @GetMapping("/movies/{id}/edit")
    public String editMoviePage(Model model, @PathVariable int id){
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "edit-movie.html";
    }



    //API METODER
    @PostMapping("/create-movie")
    public String createMovie(@ModelAttribute Movie m){
        movieService.createMovie(m);
        return "frontpage";
    }

    @PostMapping("/editMovie")
    public String editMovie(@ModelAttribute Movie m){
        movieService.updateMovie(m);
        return "redirect:/movies/" + m.getIdmovies();
    }

    @PostMapping("/deleteMovie")
    public String deleteMovie(@RequestParam int Idmovies){
        movieService.deleteMovie(Idmovies);
        return "redirect:/movies";
    }
}
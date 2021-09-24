package edu.kea.kinoxp.controllers;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.MovieRepo;
import edu.kea.kinoxp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    MovieService movieService;

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
    public String getSpecificMovie(@PathVariable String id){
        System.out.println(movieService.getMovie(Integer.parseInt(id)));
        return "movie.html";
    }

    @GetMapping("/create-movie-page")
    public String renderMoviePage(){
        return "create-movie";
    }

    //SC

    @GetMapping("/movies/{id}")
    public String editMoviePage(Model model, @PathVariable int id){
        //Movie movie = movieService.fetchMovieByID(id);
        //Movie movie = new Movie(1,"Hestemand", 1, 1, 1, "genre", "description", "actors", "moviepost.jpg");
        //model.addAttribute("movie", movie);
        return "edit-movie.html";
    }



    //API METODER
    @PostMapping("/create-movie")
    public String createMovie(@ModelAttribute Movie m){
        movieService.createMovie(m);
        return "frontpage";
    }

    @PutMapping("/editMovie")
    public String editMovie(@ModelAttribute Movie m){
        movieService.updateMovie(m);
        return "";
    }

    @DeleteMapping("/deleteMovie")
    public String deleteMovie(){
        return "";
    }
}
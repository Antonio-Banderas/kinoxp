package edu.kea.kinoxp.controllers;
import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    MovieService movieService;

    //SIDER
    @GetMapping("/")
    public String getFrontpage(){
        return "frontpage.html";
    }
    @GetMapping("/movies")
    public String getMovies(){
        return "movies.html";
    }

    @GetMapping("/movie/${id]")
    public String getSpecificMovie(@PathVariable String id){
        return "movie.html";
    }

    @GetMapping("/createMoviePage")
    public String createMoviePage(){
        return "create-movie.html";
    }

    @GetMapping("/editMoviePage")
    public String editMoviePage(){
        return "edit-movie.html";
    }

    //API METODER
    @PostMapping("/createMovie")
    public String createMovie(@ModelAttribute Movie m){
        movieService.createMovie(m);
        return "";
    }
    @PutMapping("/editMovie")
    public String editMovie(){
        return "";
    }
    @DeleteMapping("/deleteMovie")
    public String deleteMovie(){
        return "";
    }
}
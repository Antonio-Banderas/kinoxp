package edu.kea.kinoxp.controllers;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.ScreeningRepo;
import edu.kea.kinoxp.services.CustomerService;
import edu.kea.kinoxp.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
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
        model.addAttribute("screenings",screeningRepo.fetchAllScreeningsById(id) );
        return "movie.html";
    }

    @GetMapping("/create-movie-page")
    public String renderMoviePage(){
        return "create-movie";
    }

    //SC





    //API METODER
    @PostMapping("/create-movie")
    public String createMovie(@ModelAttribute Movie m){
        movieService.createMovie(m);
        return "frontpage";
    }


    @GetMapping("/searchMovie")
    public String searchHTML(Model model,@Param("keyword") String keyword){
        List<Movie> listProducts = movieService.listAll(keyword);
        model.addAttribute("film", listProducts);
        model.addAttribute("keyword", keyword);
        return "searchMovie.html";
    }

    @GetMapping("/movies/{id}/edit")
    public String editMoviePage(Model model, @PathVariable int id){
        Movie movie = movieService.getMovie(id);
        model.addAttribute("movie", movie);
        return "edit-movie.html";
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
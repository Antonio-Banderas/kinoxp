package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public Movie createMovie(Movie m){
        return movieRepo.createMovie(m);
    }

    public List<Movie> fetchAllMovies() {
        return movieRepo.fetchAllMovies();
    }

    public List<Movie> listAll(String keyword){
        if (keyword != null) {
            return movieRepo.searchMovie(keyword);
        }
        return movieRepo.fetchAllMovies();
    }

    public Movie getMovie(int movieID){
        return movieRepo.fetchMovieByID(movieID);
    }

    public void updateMovie(Movie m){
        movieRepo.updateMovie(m);
    }

    public void deleteMovie(int id){
        movieRepo.deleteMovie(id);
    }



}

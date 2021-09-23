package edu.kea.kinoxp.services;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public Movie createMovie(Movie m){
        return movieRepo.createMovie(m);
    }
}

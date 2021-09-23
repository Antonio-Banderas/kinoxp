package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class MovieRepo {
    @Autowired
    JdbcTemplate template;

    public Movie createMovie(Movie m){
        String sql = "INSERT INTO movies(idmovies, title, price, length, age, genre, description, actors, movieposter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, m.getIdmovies(), m.getTitle(), m.getPrice(), m.getLength(), m.getAge(), m.getGenre(), m.getDescription(), m.getActors(), m.getMoviePoster());
        return null;
    }

}

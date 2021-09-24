package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Repository
public class MovieRepo {
    @Autowired
    JdbcTemplate template;

    public Movie createMovie(Movie m){
        String sql = "INSERT INTO movies(idmovies, title, price, length, age, genre, description, actors, movieposter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, m.getIdmovies(), m.getTitle(), m.getPrice(), m.getLength(), m.getAge(), m.getGenre(), m.getDescription(), m.getActors(), m.getMovieposter());
        System.out.println(m.getTitle() + m.getMovieposter());
        return null;
    }

    public List<Movie> fetchAllMovies() {
        String sql = "SELECT * FROM movies";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql, rowMapper);
    }

    public Movie fetchMovieByID(int movieID){
        String sql = "select * from movies where idmovies = ?";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        Movie movie = template.queryForObject(sql, rowMapper, movieID);
        return movie;
    }
}

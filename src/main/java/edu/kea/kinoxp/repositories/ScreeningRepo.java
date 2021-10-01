package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreeningRepo {
    @Autowired
    JdbcTemplate template;

    public Movie createScreening(Movie m) {
        String sql = "INSERT INTO screenings(idmovies, title, price, length, age, genre, description, actors, movieposter) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, m.getIdmovies(), m.getTitle(), m.getPrice(), m.getLength(), m.getAge(), m.getGenre(), m.getDescription(), m.getActors(), m.getMovieposter());
        return null;
    }

    public List<Movie> fetchAllScreenings() {
        String sql = "SELECT * FROM movies";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        return template.query(sql, rowMapper);
    }

    public List<Screening> fetchAllScreeningsByDate(String date){
        String sql = "SELECT * FROM screenings WHERE screendatetime = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        List<Screening> screenings = template.query(sql, rowMapper,date);
        return screenings;
    }

    public Movie fetchScreeningByID(int movieID) {
        String sql = "SELECT * FROM movies WHERE idmovies = ?";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        Movie movie = template.queryForObject(sql, rowMapper, movieID);
        return movie;
    }

    public void updateScreening(Movie m){
        String sql = "UPDATE movies SET title = ?, price = ?, length = ?, age = ?, genre = ?, description = ?, actors = ?, movieposter = ? WHERE idmovies = ?";
        template.update(sql, m.getTitle(), m.getPrice(), m.getLength(), m.getAge(), m.getGenre(), m.getDescription(), m.getActors(), m.getMovieposter(), m.getIdmovies());
    }

    public void deleteScreening(int id){
        String sql = "DELETE FROM movies where idmovies = ?";
        template.update(sql, id);
    }
}

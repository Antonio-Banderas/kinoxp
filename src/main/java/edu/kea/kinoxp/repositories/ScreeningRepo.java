package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class ScreeningRepo {
    @Autowired
    JdbcTemplate template;

    public Screening createScreening(Screening s) {
        String sql = "INSERT INTO screenings(idscreening, movies_idmovies, date, timeslot, cinemas_idcinemahall) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, s.getIdscreening(),s.getMovies_idmovies(),s.getDate(),s.getTimeslot(),s.getCinemas_idcinemahall());
        return null;
    }

    public List<Screening> fetchAllScreeningsByDate(){
        String sql = "SELECT * FROM screenings WHERE date = CURRENT_DATE";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return  template.query(sql, rowMapper);
    }

    public List<Screening> fetchAllScreeningsByDateAndHall(int cinemas_idcinemahall){
        String sql = "SELECT * FROM screenings WHERE date = CURRENT_DATE && cinemas_idcinemahall = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return  template.query(sql, rowMapper, cinemas_idcinemahall);
    }

    public List<Screening> fetchAllScreeningsByMovieId(int movieid){
        String sql = "SELECT * FROM screenings WHERE movies_idmovies = ? ORDER BY date, timeslot, cinemas_idcinemahall ASC";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return template.query(sql, rowMapper, movieid);
    }

    public Screening fetchScreeningById(int screeningid){
        String sql = "SELECT * FROM screenings WHERE idscreening = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return template.queryForObject(sql, rowMapper, screeningid);
    }

    public List<LocalDate> fetchAllDatesForMovie(int movieid) {
        String sql = "SELECT DISTINCT date FROM screenings WHERE (movies_idmovies = ?) and (date > curdate()) or (date = curdate()) ORDER BY date ASC;";
        SingleColumnRowMapper<LocalDate> rowMapper = new SingleColumnRowMapper<>(LocalDate.class);
        return template.query(sql, rowMapper, movieid);
    }
}

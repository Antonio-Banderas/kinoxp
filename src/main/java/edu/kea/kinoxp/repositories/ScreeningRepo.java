package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ScreeningRepo {
    @Autowired
    JdbcTemplate template;

    public Screening createScreening(Screening s) {
        String sql = "INSERT INTO screenings(idscreening, movies_idmovies, date, time, cinemas_idcinemahall) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, s.getIdscreening(),s.getMovies_idmovies(),s.getDate(),s.getTime(),s.getCinemas_idcinemahall());
        return null;
    }

    public List<Screening> fetchAllScreeningsByDate(Date today){
        String sql = "SELECT * FROM screenings WHERE date = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return  template.query(sql, rowMapper,today);
    }

    public List<Screening> fetchAllScreeningsById(int id){
        String sql = "SELECT * FROM screenings WHERE movies_idmovies = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return template.query(sql, rowMapper, id);
    }
}

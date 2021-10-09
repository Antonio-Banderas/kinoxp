package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
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



    public Screening getScreeningByID(Long id){
        String sql ="SELECT * FROM screenings WHERE idscreening = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public List<Seat> getOccupiedSeatsByScreeningID(Long id) {
        String sql = "SELECT * FROM seats INNER JOIN seat_reserved ON seats.idseats = seat_reserved.id_seats WHERE id_screenings = ?;";
        RowMapper<Seat> rowMapper = new BeanPropertyRowMapper<>(Seat.class);
        return template.query(sql, rowMapper, id);
    }

    public List<Screening> fetchAllScreeningsByDate(){
        String sql = "SELECT * FROM screenings WHERE date = CURRENT_DATE";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return  template.query(sql, rowMapper);
    }

    public void addSeatsToSeatsReserved(int [] seatsArr, int screeningID) {
        for(int i = 0; i <seatsArr.length; i++) {
            String sql = "INSERT INTO seat_reserved(id_screenings,id_seats) VALUES(?,?)";
            System.out.println(Arrays.toString(seatsArr) + " " +screeningID);
            template.update(sql,screeningID,seatsArr[i]);
        }
    }
        public List<Screening> fetchAllScreeningsByDateAndHall(int cinemas_idcinemahall){
        String sql = "SELECT * FROM screenings WHERE date = CURRENT_DATE && cinemas_idcinemahall = ?";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return  template.query(sql, rowMapper, cinemas_idcinemahall);
    }

    public List<Screening> fetchAllScreeningsById(int id){
        String sql = "SELECT * FROM screenings WHERE movies_idmovies = ? ORDER BY date, timeslot, cinemas_idcinemahall ASC";
        RowMapper<Screening> rowMapper = new BeanPropertyRowMapper<>(Screening.class);
        return template.query(sql, rowMapper, id);
    }

    public List<LocalDate> fetchAllDatesForMovie(int movieid) {
        String sql = "SELECT DISTINCT date FROM screenings WHERE (movies_idmovies = ?) and (date > curdate()) or (date = curdate()) ORDER BY date ASC;";
        SingleColumnRowMapper<LocalDate> rowMapper = new SingleColumnRowMapper<>(LocalDate.class);
        return template.query(sql, rowMapper, movieid);
    }
}

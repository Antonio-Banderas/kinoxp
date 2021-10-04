package edu.kea.kinoxp.repositories;

import edu.kea.kinoxp.models.Movie;
import edu.kea.kinoxp.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatRepo {

    @Autowired
    JdbcTemplate template;

    public List<Seat> fetchAllByCinemaID(int cinemaID) {
        String sql = "SELECT * FROM seats where cinemas_idcinemahall = ?";
        RowMapper<Seat> rowMapper = new BeanPropertyRowMapper<>(Seat.class);
        return template.query(sql, rowMapper, cinemaID);
    }

    public Integer fetchMaxRowCount(int cinemaID) {
        String sql = "SELECT MAX(rownumber) FROM seats where cinemas_idcinemahall = ?";
        SingleColumnRowMapper<Integer> rowMapper = new SingleColumnRowMapper<>(Integer.class);
        return template.queryForObject(sql, rowMapper, cinemaID);
    }

    public Integer fetchMaxSeatNumCount(int cinemaID) {
        String sql = "SELECT MAX(seatnumber) FROM seats where cinemas_idcinemahall = ?";
        SingleColumnRowMapper<Integer> rowMapper = new SingleColumnRowMapper<>(Integer.class);
        return template.queryForObject(sql, rowMapper, cinemaID);
    }


}

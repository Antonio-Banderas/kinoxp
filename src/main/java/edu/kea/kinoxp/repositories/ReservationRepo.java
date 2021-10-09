package edu.kea.kinoxp.repositories;


import edu.kea.kinoxp.models.Reservation;
import edu.kea.kinoxp.models.seat_reserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationRepo {
    @Autowired
    JdbcTemplate template;

    public Reservation getReservationFromID(int id){
        String sql ="SELECT * FROM reservations WHERE idseats_reserved = ?";
        RowMapper<Reservation> rowMapper = new BeanPropertyRowMapper<>(Reservation.class);
        return template.queryForObject(sql, rowMapper, id);
    }

    public int createReservation(Reservation r){
        String sql ="INSERT INTO reservations(idseats_reserved,screening_idscreening,seats_idseats,customers_idcustomer) VALUES(?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[] {"idseats_reserved"});
                        ps.setInt(1, r.getIdseats_reserved());
                        ps.setInt(2, r.getScreening_idscreening());
                        ps.setInt(3,r.getSeats_idseats());
                        ps.setInt(4,r.getCustomers_idcustomer());
                        return ps;
                    }
                },
                keyHolder);
// keyHolder.getKey() now contains the generated key

        return keyHolder.getKey().intValue();
    }

    public List<seat_reserved> getSeatReservedFromId(int id){
        String sql ="SELECT * FROM seat_reserved WHERE id_screenings = ?";
        RowMapper<seat_reserved> rowMapper = new BeanPropertyRowMapper<>(seat_reserved.class);
        return template.query(sql, rowMapper, id);
    }

}

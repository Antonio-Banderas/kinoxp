package edu.kea.kinoxp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    int idscreening;
    int movies_idmovies;        // 32 (this is shrek)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;             // we only use the date part and not the time
    String timeslot;            // 1, 2, 3 or 4
    int cinemas_idcinemahall;   // 1 or 2

}

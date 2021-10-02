package edu.kea.kinoxp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    int idscreening;
    int movies_idmovies;        // 33
    Date date;                  // we only use the date part and not the time
    String timeslot;            // 1, 2, 3 or 4
    int cinemas_idcinemahall;   // 11-01-9821 (varchar)

}

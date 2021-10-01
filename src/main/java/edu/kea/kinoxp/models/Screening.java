package edu.kea.kinoxp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Screening {

    @Id
    int idscreening;
    String screendatetime;
    int movies_idmovies; //33
    int cinemas_idcinemahall; // 11-01-9821 (varchar)

}

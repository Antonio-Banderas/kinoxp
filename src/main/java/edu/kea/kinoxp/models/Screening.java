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
    int screeningId;

    int movieId; //33

    int Date; // 11-01-9821 (varchar(

}

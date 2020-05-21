package coronadata.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@Data
@Entity
public class CoronaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private LocalDate date;
    private String location;
    private int newCases;
    private int newDeaths;
    private int totalCases;
    private int totalDeaths;
}

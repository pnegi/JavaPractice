package coronadata.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CoronaDto {
    @CsvBindByName
    private String date;
    @CsvBindByName
    private String location;
    @CsvBindByName
    private int newCases;
    @CsvBindByName
    private int newDeaths;
    @CsvBindByName
    private int totalCases;
    @CsvBindByName
    private int totalDeaths;
}

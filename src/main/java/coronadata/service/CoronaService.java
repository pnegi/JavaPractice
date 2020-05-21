package coronadata.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import coronadata.dto.CoronaDto;
import coronadata.model.CoronaEntity;
import coronadata.repository.CoronaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoronaService {
    @Autowired private CoronaRepository coronaRepository;

    public List<CoronaEntity> saveCoronaData(Reader reader) {
        List<CoronaDto> coronaDtos = setCoronaDtos(reader);
        List<CoronaEntity> coronaEntities = mapCoronaDtosToEntities(coronaDtos);
        coronaRepository.saveAll(coronaEntities);
        coronaEntities.forEach(System.out::println);
        return coronaEntities;
    }

    public List<CoronaEntity> mapCoronaDtosToEntities(List<CoronaDto> coronaDtos) {
        return coronaDtos.stream().map(
                coronaDto ->
                        CoronaEntity.builder()
                .date(LocalDate.parse(coronaDto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .location(coronaDto.getLocation())
                .newCases(coronaDto.getNewCases())
                .newDeaths(coronaDto.getNewDeaths())
                .totalCases(coronaDto.getTotalCases())
                .totalDeaths(coronaDto.getTotalDeaths())
                .build()).collect(Collectors.toList());
    }

    public List<CoronaDto> setCoronaDtos(Reader reader) {
        // create csv bean reader
        CsvToBean<CoronaDto> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CoronaDto.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        // convert `CsvToBean` object to list of coronaDtos
        return csvToBean.parse();
    }
}

package coronadata.controller;

import coronadata.model.CoronaEntity;
import coronadata.service.CoronaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@RestController
@Slf4j
public class CoronaController {
    @Autowired private CoronaService coronaService;

    @PostMapping("/coronaData")
    public ResponseEntity<String> postCoronaData(@RequestParam("file") MultipartFile file) {
        ResponseEntity<String> responseEntity=null;
        // validate file
        if (file.isEmpty()) {
            log.info("Please select a CSV file to upload.");
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please select a CSV file to upload.");
        } else {
            // parse CSV file to create a list of `CoronaDto` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                log.info("getting coronaEntity list from service-");
                List<CoronaEntity> coronaEntities = coronaService.saveCoronaData(reader);
                responseEntity = ResponseEntity.status(HttpStatus.OK).body(coronaEntities.toString());
            } catch (Exception ex) {
                log.error(ex.getMessage());
            }
        }
        return responseEntity;
    }
}

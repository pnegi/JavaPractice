package coronadata;

import coronadata.model.coronaEntity;
import coronadata.repository.coronaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoronaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaDataApplication.class, args);
	}

	public CommandLineRunner demo(coronaRepository coronaRepository){
		return args -> coronaRepository.save(new coronaEntity(1, "Jack", "Bauer"));

	}

}

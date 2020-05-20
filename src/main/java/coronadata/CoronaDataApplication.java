package coronadata;

import coronadata.model.CoronaEntity;
import coronadata.repository.CoronaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoronaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaDataApplication.class, args);
	}

	public CommandLineRunner demo(CoronaRepository coronaRepository){
		return args -> coronaRepository.save(new CoronaEntity(1, "Jack", "Bauer"));

	}

}

package example.com.exampleapi;

import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import example.com.exampleapi.domain.Charger;
import example.com.exampleapi.service.ChargerService;

@SpringBootApplication
public class ExampleapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ChargerService service) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			TypeReference<List<Charger>> reference = new TypeReference<List<Charger>>() {
			};
			InputStream stream = TypeReference.class
					.getResourceAsStream("/json/chargers.json");
			try {
				List<Charger> chargers = mapper.readValue(stream, reference);
				service.save(chargers);

				System.out.println("Saved!");

			} catch (Exception h) {
				System.out.println("Unable to save! " + h.getMessage());
			}
		};
	}

}

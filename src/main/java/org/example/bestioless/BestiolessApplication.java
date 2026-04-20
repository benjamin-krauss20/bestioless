package org.example.bestioless;

import org.example.bestioless.model.Person;
import org.example.bestioless.repository.PersonRepository;
import org.example.bestioless.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestiolessApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository; // Injection pour le test [cite: 88]

	@Autowired
	private SpeciesRepository speciesRepository;

	public static void main(String[] args) {
		SpringApplication.run(BestiolessApplication.class, args);
	}

	@Override

	public void run(String... args) throws Exception {
		System.out.println("--- TEST TP 04 ---");

		// Test Species : Nom latin contenant "felis"
		speciesRepository.findByLatinNameContainingIgnoreCase("felis")
				.forEach(s -> System.out.println("Trouvé : " + s.getCommonName()));

		// Test Person : Plus de 30 ans
		personRepository.findByAgeGreaterThanEqual(30)
				.forEach(p -> System.out.println(p.getFirstname() + " a plus de 30 ans."));
	}
}
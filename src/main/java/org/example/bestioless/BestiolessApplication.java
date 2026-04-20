package org.example.bestioless;

import org.example.bestioless.model.Species;
import org.example.bestioless.model.Person;
import org.example.bestioless.repository.AnimalRepository;
import org.example.bestioless.repository.PersonRepository;
import org.example.bestioless.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BestiolessApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private SpeciesRepository speciesRepository;

	@Autowired
	private AnimalRepository animalRepository;

	public static void main(String[] args) {
		SpringApplication.run(BestiolessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--- DÉBUT DES TESTS TP 05 ---");

		// Test 1 : Species triées (Variable speciesRepository en minuscule !)
		System.out.println(">> Espèces triées :");
		speciesRepository.findAllOrderedByCommonName()
				.forEach(s -> System.out.println(" - " + s.getCommonName()));

		// Test 2 : Personnes entre 20 et 40 ans
		System.out.println("\n>> Personnes entre 20 et 40 ans :");
		personRepository.findByAgeBetween(20, 40)
				.forEach(p -> System.out.println(" - " + p.getFirstname() + " (" + p.getAge() + " ans)"));

		// Test 3 : Animaux par couleurs (TP 04)
		System.out.println("\n>> Animaux de couleur Blanc ou Roux :");
		animalRepository.findByColorIn(List.of("Blanc", "Roux"))
				.forEach(a -> System.out.println(" - " + a.getName() + " est " + a.getColor()));

		System.out.println("\n--- FIN DES TESTS ---");
	}
}
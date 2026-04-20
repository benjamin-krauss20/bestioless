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
		System.out.println("--- DÉBUT DES TESTS ---");

		// 1. Afficher tout (findAll) [cite: 90]
		personRepository.findAll().forEach(p ->
				System.out.println("Personne en BDD : " + p.getFirstname() + " " + p.getLastname()));

		// 2. Créer une entité (save) [cite: 91]
		Person nouvellePersonne = new Person();
		nouvellePersonne.setFirstname("Benjamin");
		nouvellePersonne.setLastname("K");
		personRepository.save(nouvellePersonne);
		System.out.println("Nouvelle personne enregistrée !");

		// 3. Rechercher par ID (findById) [cite: 92]
		personRepository.findById(1).ifPresent(p ->
				System.out.println("ID 1 trouvé : " + p.getFirstname()));

		// 4. Supprimer (delete) [cite: 93]
		// personRepository.deleteById(1);

		System.out.println("--- TESTS TERMINÉS ---");
	}
}
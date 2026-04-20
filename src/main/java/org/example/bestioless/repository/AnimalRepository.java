package org.example.bestioless.repository;

import org.example.bestioless.model.Animal;
import org.example.bestioless.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    // TP 04 : Requête dérivée
    List<Animal> findBySpecies(Species species);

    // TP 04 : Requête In
    List<Animal> findByColorIn(List<String> colors);
}
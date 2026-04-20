package org.example.bestioless.repository;

import org.example.bestioless.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {


    // Retourne la première espèce par son nom commun exact
    Species findFirstByCommonName(String commonName);

    // Liste des espèces dont le nom latin contient la saisie (sans tenir compte de la casse)
    List<Species> findByLatinNameContainingIgnoreCase(String latinName);
}
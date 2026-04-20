package org.example.bestioless.repository;

import org.example.bestioless.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {// Recherche par nom OU par prénom
    List<Person> findByLastnameOrFirstname(String lastname, String firstname);

    // Personnes ayant un âge >= au paramètre
    List<Person> findByAgeGreaterThanEqual(Integer age);
}
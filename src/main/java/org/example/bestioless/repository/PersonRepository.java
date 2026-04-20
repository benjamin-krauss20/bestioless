package org.example.bestioless.repository;

import org.example.bestioless.model.Person;
import org.example.bestioless.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    // TP 05 : Query Between
    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findByAgeBetween(@Param("ageMin") Integer ageMin, @Param("ageMax") Integer ageMax);

    // TP 05 : Query Jointure (Difficile)
    @Query("SELECT p FROM Person p JOIN p.animals a WHERE a = :animal")
    List<Person> findByAnimal(@Param("animal") Animal animal);
}
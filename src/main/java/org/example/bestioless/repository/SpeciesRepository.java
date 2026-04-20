package org.example.bestioless.repository;

import org.example.bestioless.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {

    // TP 05 : Query ordonnée
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonName();

    // TP 05 : Query Like
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE %:name%")
    List<Species> findByCommonNameLike(@Param("name") String name);
}
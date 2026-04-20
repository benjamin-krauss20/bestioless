package org.example.bestioless.model;

import jakarta.persistence.*;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String color;
    private String sex;

    @ManyToOne
    @JoinColumn(name = "species_id")
    private Species species;

    // Getters et Setters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public Species getSpecies() { return species; }
    public void setSpecies(Species species) { this.species = species; }
}
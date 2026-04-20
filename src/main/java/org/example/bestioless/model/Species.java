package org.example.bestioless.model;

import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "common_name")
    private String commonName;

    @Column(name = "latin_name")
    private String latinName;

    // Getters et Setters (indispensables)
    public Integer getId() { return id; }
    public String getCommonName() { return commonName; }
    public void setCommonName(String commonName) { this.commonName = commonName; }
    public String getLatinName() { return latinName; }
    public void setLatinName(String latinName) { this.latinName = latinName; }
}
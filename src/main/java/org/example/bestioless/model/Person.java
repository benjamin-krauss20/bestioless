package org.example.bestioless.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;
    private String firstname;
    private String lastname;
    private String login;
    private String mdp;

    @ManyToMany
    @JoinTable(name = "person_animals",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private List<Animal> animals;

    // Getters et Setters
    public Integer getId() { return id; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public List<Animal> getAnimals() { return animals; }
    public void setAnimals(List<Animal> animals) { this.animals = animals; }
}
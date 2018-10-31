package me.ermias.demo;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String occupation;
    private String description;

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    public Set<Pet> pets;

    public People(String name, String occupation, String description, Set<Pet> pets) {
        this.name = name;
        this.occupation = occupation;
        this.pets = pets;
    }

    public People() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

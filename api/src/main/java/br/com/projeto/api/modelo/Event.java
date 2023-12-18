package br.com.projeto.api.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String acronym;
    private String description;

    @OneToMany
    @JoinColumn(name = "Event_id", referencedColumnName = "id")
    private List<Edition> edition = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Edition> getEdition() {
        return edition;
    }

    public void setEdition(List<Edition> edition) {
        this.edition = edition;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (Edition e : this.edition) {
            users.addAll(e.getUsers());
        }
        return users;
    }
}

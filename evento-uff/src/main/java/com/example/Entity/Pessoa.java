package com.example.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="pessoas")
public class Pessoa {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
}

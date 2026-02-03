package br.com.projeto_forum.forum.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")

public class Curso {

    @Id
    @GeneratedValue
    private Long id;
    private String categoria;

    public Curso (){

    }
    public String getCategoria() {
        return categoria;
    }

}

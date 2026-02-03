package br.com.projeto_forum.forum.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario (){

    }
    public String getNome() {
        return nome;
    }


}

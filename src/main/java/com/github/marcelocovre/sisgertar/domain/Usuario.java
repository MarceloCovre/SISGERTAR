package com.github.marcelocovre.sisgertar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "usuario")
@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "hash")
    private String hash;
}

package com.github.marcelocovre.sisgertar.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "comentario")
@Entity
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;
}

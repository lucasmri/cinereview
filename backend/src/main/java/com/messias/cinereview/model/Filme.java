package com.messias.cinereview.model;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer ano;

    @Column(length = 200, nullable = false)
    private String direcao;

    public Filme() {
    }

    public Filme(Integer id, String nome, String genero, Integer ano, String direcao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.direcao = direcao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
}

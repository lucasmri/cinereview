package com.messias.cinereview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resenhas")
public class Resenha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double nota;

    @Column(length = 255, nullable = false)
    private String comentario;

    @Column(updatable = false, insertable = false)
    private LocalDateTime dataPublicacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "filmeId", nullable = false)
    private Filme filme;

    public Resenha() {
    }

    public Resenha(Integer id, Double nota, String comentario, LocalDateTime dataPublicacao, Usuario usuario, Filme filme) {
        this.id = id;
        this.nota = nota;
        this.comentario = comentario;
        this.dataPublicacao = dataPublicacao;
        this.usuario = usuario;
        this.filme = filme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}

package com.messias.cinereview.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

//Diz que essa classe é uma entidade e especifíca o nome dela no banco de dados para o Hibernate mapear
@Entity
@Table(name = "resenhas")
public class Resenha {

    //Diz que esse atributo é uma chave primária e aplica uma lógica de auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(nullable = false)
    private Double nota;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 255, nullable = false)
    private String comentario;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(updatable = false, insertable = false)
    private LocalDateTime dataPublicacao;

    //Define um relacionamento muitos para um entre resenhas e usuários e define a chave estrangeira que referencia a tabela de usuários
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    //Define um relacionamento muitos para um entre resenhas e filmes e define a chave estrangeira que referencia a tabela de filmes
    @ManyToOne(optional = false)
    @JoinColumn(name = "filmeId", nullable = false)
    private Filme filme;

    //Obs.: Na annotation @Column não há nomes da coluna especificado, pois o mesmo é igual ao criado no DDL, caso contrário, seria necessário especificar também

    //Construtor vazio para o funcionamento da JPA/Hibernate
    public Resenha() {
    }

    //Construtor completo para inicialização dos atributos
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

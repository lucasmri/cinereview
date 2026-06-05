package com.messias.cinereview.model;

import jakarta.persistence.*;

//Diz que essa classe é uma entidade e especifíca o nome dela no banco de dados para o Hibernate mapear
@Entity
@Table(name = "filmes")
public class Filme {

    //Diz que esse atributo é uma chave primária e aplica uma lógica de auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 150, nullable = false)
    private String nome;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 100, nullable = false)
    private String genero;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(nullable = false)
    private Integer ano;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 200, nullable = false)
    private String direcao;

    //Obs.: Na annotation @Column não há nomes da coluna especificado, pois o mesmo é igual ao criado no DDL, caso contrário, seria necessário especificar também

    //Construtor vazio para o funcionamento da JPA/Hibernate
    public Filme() {
    }

    //Construtor completo para inicialização dos atributos
    public Filme(Integer id, String nome, String genero, Integer ano, String direcao) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.direcao = direcao;
    }

    //Getters and setters para acesso de modificação dos atributos privados
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

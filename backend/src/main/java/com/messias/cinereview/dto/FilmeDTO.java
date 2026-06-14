package com.messias.cinereview.dto;

//DTO utilizado para transferência de dados de filmes entre as camadas da aplicação
public class FilmeDTO {

    private String nome;
    private String genero;
    private Integer ano;
    private String direcao;

    //Construtor vazio para criação do objeto
    public FilmeDTO() {
    }

    //Construtor completo para inicialização dos atributos
    public FilmeDTO(String nome, String genero, Integer ano, String direcao) {
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.direcao = direcao;
    }

    //Getters and setters para acesso e modificação dos atributos privados
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
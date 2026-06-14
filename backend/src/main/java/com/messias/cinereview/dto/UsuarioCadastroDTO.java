package com.messias.cinereview.dto;

//DTO utilizado para transferência dos dados de resenhas entre as camadas da aplicação
public class UsuarioCadastroDTO {

    private String nome;
    private String email;
    private String senha;

    //Construtor vazio para criação do objeto
    public UsuarioCadastroDTO() {
    }

    //Construtor completo para inicialização dos atributos
    public UsuarioCadastroDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    //Getters and setters para acesso e modificação dos atributos privados
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

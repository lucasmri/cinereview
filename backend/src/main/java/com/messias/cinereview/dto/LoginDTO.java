package com.messias.cinereview.dto;

//DTO utilizado para transferência dos dados de login entre as camadas da aplicação
public class LoginDTO {

    private String email;
    private String senha;

    //Construtor vazio para criação do objeto
    public LoginDTO() {
    }

    //Construtor completo para inicialização dos atributos
    public LoginDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    //Getters and setters para acesso e modificação dos atributos privados
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
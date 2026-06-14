package com.messias.cinereview.model;

import jakarta.persistence.*;

//Diz que essa classe é uma entidade e especifíca o nome dela no banco de dados para o Hibernate mapear
@Entity
@Table(name = "usuarios")
public class Usuario {

    //Diz que esse atributo é uma chave primária e aplica uma lógica de auto-incremento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 150, nullable = false)
    private String nome;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(length = 200, nullable = false, unique = true)
    private String email;

    //Configuração exata do atributo criado no banco de dados (DDL)
    @Column(name = "senha_hash", length = 255, nullable = false)
    private String senhaHash;

    //Obs.: Na annotation @Column não há nomes da coluna especificado, pois o mesmo é igual ao criado no DDL, caso contrário, seria necessário especificar também

    //Construtor vazio para o funcionamento da JPA/Hibernate
    public Usuario() {
    }

    //Construtor completo para inicialização dos atributos
    public Usuario(Integer id, String nome, String email, String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = senhaHash;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }
}

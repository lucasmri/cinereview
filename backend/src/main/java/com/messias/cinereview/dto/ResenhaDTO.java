package com.messias.cinereview.dto;

//DTO utilizado para transferência dos dados de resenhas entre as camadas da aplicação
public class ResenhaDTO {

    private Double nota;
    private String comentario;
    private Integer usuarioId;
    private Integer filmeId;

    //Construtor vazio para criação do objeto
    public ResenhaDTO() {
    }

    //Construtor completo para inicialização dos atributos
    public ResenhaDTO(Double nota, String comentario, Integer usuarioId, Integer filmeId) {
        this.nota = nota;
        this.comentario = comentario;
        this.usuarioId = usuarioId;
        this.filmeId = filmeId;
    }

    //Getters and setters para acesso e modificação dos atributos privados
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

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }
}
package com.messias.cinereview.service;

import com.messias.cinereview.model.Resenha;
import com.messias.cinereview.repository.ResenhaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

//Indica que essa classe contém as regras de negócio da aplicação e é gerenciada pelo Spring
@Service
public class ResenhaService {

    //Referencia o repositório responsável pelo acesso aos dados
    private final ResenhaRepository resenhaRepository;

    //Injeção de dependência via construtor
    public ResenhaService(ResenhaRepository resenhaRepository) {
        this.resenhaRepository = resenhaRepository;
    }

    //Salva uma resenha após validar seus dados
    public Resenha salvarResenha(Resenha resenha) {

        //Valida se a nota está entre 0 e 10
        if(resenha.getNota() < 0 || resenha.getNota() > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A nota deve estar entre 0 e 10.");
        }

        //Valida se o comentário possui no mínimo 20 caracteres
        if (resenha.getComentario() == null || resenha.getComentario().trim().length() < 20) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comentário deve possuir no mínimo 20 caracteres.");
        }

        //Define a data atual caso nenhuma data seja informada
        if (resenha.getDataPublicacao() == null) {
            resenha.setDataPublicacao(LocalDateTime.now());
        }

        //Salva a resenha no banco de dados
        return resenhaRepository.save(resenha);
    }

    //Lista todas as resenhas cadastradas através do método findAll da JPA
    public List<Resenha> listarResenhas() {
        return resenhaRepository.findAll();
    }

    //Busca uma resenha pelo id e lança uma exceção caso ela não exista
    public Resenha listarResenha(Integer id) {
        return resenhaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resenha não encontrado"));
    }

    //Deleta uma resenha do banco de dados
    public void deletarResenha(Integer id) {

        //Remove a resenha através do id informado
        resenhaRepository.deleteById(id);
    }
}
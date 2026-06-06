package com.messias.cinereview.service;

import com.messias.cinereview.model.Filme;
import com.messias.cinereview.repository.FilmeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Indica que essa classe contém as regras de negócio da aplicação e é gerenciada pelo Spring
@Service
public class FilmeService {

    //Referencia o repositório responsável pelo acesso aos dados
    private final FilmeRepository filmeRepository;

    //Injeção de dependência via construtor
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    //Lista todos os filmes cadastrados através do método findAll da JPA
    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    //Busca um filme pelo id e lança uma exceção caso ele não exista
    public Filme listarFilme(Integer id) {
        return filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    //Atualiza os dados de um filme existente
    public Filme atualizarFilme(Integer id, Filme filmeAtualizado) {

        //Busca o filme que será atualizado
        Filme filme = listarFilme(id);

        //Atualiza os dados através dos getters and setters
        filme.setNome(filmeAtualizado.getNome());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAno(filmeAtualizado.getAno());
        filme.setDirecao(filmeAtualizado.getDirecao());

        //Salva no banco o objeto atualizado
        return filmeRepository.save(filme);
    }

    //Deleta um filme do banco de dados
    public void deletarFilme(Integer id) {

        //Busca o filme que será removido
        Filme filme = listarFilme(id);

        //Remove o objeto do banco de dados
        filmeRepository.delete(filme);
    }
}
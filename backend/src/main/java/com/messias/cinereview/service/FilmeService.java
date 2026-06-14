package com.messias.cinereview.service;

import com.messias.cinereview.dto.FilmeDTO;
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

    //Salva o filme no banco de dados
    public Filme salvarFilme(FilmeDTO dto) {

        Filme filme = new Filme();

        filme.setNome(dto.getNome());
        filme.setGenero(dto.getGenero());
        filme.setAno(dto.getAno());
        filme.setDirecao(dto.getDirecao());

        return filmeRepository.save(filme);
    }

    //Busca um filme pelo id e lança uma exceção caso ele não exista
    public Filme listarFilme(Integer id) {
        return filmeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    //Busca filmes pelo gênero
    public List<Filme> listarPorGenero(String genero) {
        return filmeRepository.findByGeneroIgnoreCase(genero);
    }

    //Atualiza os dados de um filme existente
    public Filme atualizarFilme(Integer id, FilmeDTO dto) {

        Filme filme = listarFilme(id);

        filme.setNome(dto.getNome());
        filme.setGenero(dto.getGenero());
        filme.setAno(dto.getAno());
        filme.setDirecao(dto.getDirecao());

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
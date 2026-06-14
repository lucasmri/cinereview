package com.messias.cinereview.controller;

import com.messias.cinereview.dto.FilmeDTO;
import com.messias.cinereview.model.Filme;
import com.messias.cinereview.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indica que essa classe é uma controller REST responsável por receber requisições HTTP
@RestController
//Define a URL base para os endpoints desta controller
@RequestMapping("/filmes")
public class FilmeController {

    //Referencia o service responsável pelas regras de negócio
    private final FilmeService filmeService;

    //Injeção de dependência via construtor
    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    //Mapeia requisições GET para listar todos os filmes
    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarFilmes();
    }

    //Mapeia requisições GET para buscar um filme pelo id
    @GetMapping("/{id}")
    public Filme listarFilme(@PathVariable Integer id) {
        return filmeService.listarFilme(id);
    }

    //Mapeia requisições GET para listar filmes por gênero
    @GetMapping("/genero/{genero}")
    public List<Filme> listarPorGenero(@PathVariable String genero) {

        return filmeService.listarPorGenero(genero);
    }

    //Mapeia requisições POST para cadastro de filmes
    @PostMapping
    //Define o status HTTP 201 (Created) para a resposta
    @ResponseStatus(HttpStatus.CREATED)
    public Filme salvarFilme(@RequestBody FilmeDTO dto) {

        return filmeService.salvarFilme(dto);
    }

    //Mapeia requisições PUT para atualizar um filme pelo id
    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Integer id, @RequestBody FilmeDTO dto) {

        return filmeService.atualizarFilme(id, dto);
    }

    //Mapeia requisições DELETE para remover um filme pelo id
    @DeleteMapping("/{id}")
    //Define o status HTTP 204 (No Content) para a resposta
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFilme(@PathVariable Integer id) {

        filmeService.deletarFilme(id);
    }
}
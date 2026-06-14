package com.messias.cinereview.controller;

import com.messias.cinereview.dto.FilmeDTO;
import com.messias.cinereview.model.Filme;
import com.messias.cinereview.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarFilmes();
    }

    @GetMapping("/{id}")
    public Filme listarFilme(@PathVariable Integer id) {
        return filmeService.listarFilme(id);
    }

    @GetMapping("/genero/{genero}")
    public List<Filme> listarPorGenero(@PathVariable String genero) {

        return filmeService.listarPorGenero(genero);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme salvarFilme(@RequestBody FilmeDTO dto) {

        return filmeService.salvarFilme(dto);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Integer id, @RequestBody FilmeDTO dto) {

        return filmeService.atualizarFilme(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarFilme(@PathVariable Integer id) {

        filmeService.deletarFilme(id);
    }
}
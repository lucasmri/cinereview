package com.messias.cinereview.controller;

import com.messias.cinereview.dto.ResenhaDTO;
import com.messias.cinereview.model.Resenha;
import com.messias.cinereview.service.ResenhaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indica que essa classe é uma controller REST responsável por receber requisições HTTP
@RestController
//Define a URL base para os endpoints desta controller
@RequestMapping("/resenhas")
public class ResenhaController {

    //Referencia o service responsável pelas regras de negócio
    private final ResenhaService resenhaService;

    //Injeção de dependência via construtor
    public ResenhaController(ResenhaService resenhaService) {
        this.resenhaService = resenhaService;
    }

    //Mapeia requisições GET para listar todas as resenhas
    @GetMapping
    public List<Resenha> listarResenhas() {
        return resenhaService.listarResenhas();
    }

    //Mapeia requisições GET para buscar uma resenha pelo id
    @GetMapping("/{id}")
    public Resenha listarResenha(@PathVariable Integer id) {

        return resenhaService.listarResenha(id);
    }

    //Mapeia requisições POST para cadastro de resenhas
    @PostMapping
    //Define o status HTTP 201 (Created) para a resposta
    @ResponseStatus(HttpStatus.CREATED)
    public Resenha salvarResenha(@RequestBody ResenhaDTO dto) {

        return resenhaService.salvarResenha(dto);
    }

    //Mapeia requisições PUT para atualizar uma resenha pelo id
    @PutMapping("/{id}")
    public Resenha atualizarResenha(@PathVariable Integer id, @RequestBody ResenhaDTO dto) {

        return resenhaService.atualizarResenha(id, dto);
    }

    //Mapeia requisições DELETE para remover uma resenha pelo id
    @DeleteMapping("/{id}")
    //Define o status HTTP 204 (No Content) para a resposta
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarResenha(@PathVariable Integer id) {

        resenhaService.deletarResenha(id);
    }
}
package com.messias.cinereview.controller;

import com.messias.cinereview.dto.UsuarioCadastroDTO;
import com.messias.cinereview.model.Usuario;
import com.messias.cinereview.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Indica que essa classe é uma controller REST responsável por receber requisições HTTP
@RestController
//Define a URL base para os endpoints desta controller
@RequestMapping("/usuarios")
public class UsuarioController {

    //Referencia o service responsável pelas regras de negócio
    private final UsuarioService usuarioService;

    //Injeção de dependência via construtor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Mapeia requisições POST para cadastro de usuários
    @PostMapping
    //Define o status HTTP 201 (Created) para a resposta
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrarUsuario(@RequestBody UsuarioCadastroDTO dto) {

        return usuarioService.cadastrarUsuario(dto);
    }

    //Mapeia requisições GET para listar todos os usuários
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    //Mapeia requisições GET para buscar um usuário pelo id
    @GetMapping("/{id}")
    public Usuario listarUsuario(@PathVariable Integer id) {

        return usuarioService.listarUsuario(id);
    }

    //Mapeia requisições PUT para atualizar um usuário pelo id
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {

        return usuarioService.atualizarUsuario(id, usuario);
    }

    //Mapeia requisições DELETE para remover um usuário pelo id
    @DeleteMapping("/{id}")
    //Define o status HTTP 204 (No Content) para a resposta
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUsuario(@PathVariable Integer id) {

        usuarioService.deletarUsuario(id);
    }
}
package com.messias.cinereview.service;

import com.messias.cinereview.model.Usuario;
import com.messias.cinereview.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Indica que essa classe contém as regras de negócio da aplicação e é gerenciada pelo Spring
@Service
public class UsuarioService {

    //Referencia o repositório responsável pelo acesso aos dados
    private final UsuarioRepository usuarioRepository;

    //Injeção de dependência via construtor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Lista todos os usuários cadastrados através do método findall da JPA
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    //Busca um usuário pelo id e lança uma exceção caso ele não exista
    public Usuario listarUsuario(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    //Atualiza os dados de um usuário existente
    public Usuario atualizarUsuario(Integer id, Usuario usuarioAtualizado) {

        //Busca o usuário que será atualizado
        Usuario usuario = listarUsuario(id);

        //Atualiza os dados através dos getters and setters
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setNome(usuarioAtualizado.getNome());

        //Salva no banco o objeto atualizado
        return usuarioRepository.save(usuario);
    }

    //Deleta um usuário do banco de dados
    public void deletarUsuario(Integer id) {

        //Busca o usuário que será atualizado
        Usuario usuario = listarUsuario(id);

        //Delete o objeto
        usuarioRepository.delete(usuario);
    }
}

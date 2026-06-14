package com.messias.cinereview.service;

import com.messias.cinereview.dto.ResenhaDTO;
import com.messias.cinereview.model.Filme;
import com.messias.cinereview.model.Resenha;
import com.messias.cinereview.model.Usuario;
import com.messias.cinereview.repository.ResenhaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

//Indica que essa classe contém as regras de negócio da aplicação e é gerenciada pelo Spring
@Service
public class ResenhaService {

    //Referencia os repositórios responsáveis pelo acesso aos dados
    private final ResenhaRepository resenhaRepository;
    private final UsuarioService usuarioService;
    private final FilmeService filmeService;

    //Injeção de dependência via construtor
    public ResenhaService(ResenhaRepository resenhaRepository, UsuarioService usuarioService, FilmeService filmeService) {
        this.resenhaRepository = resenhaRepository;
        this.usuarioService = usuarioService;
        this.filmeService = filmeService;
    }

    //Lista todas as resenhas cadastradas através do método findAll da JPA
    public List<Resenha> listarResenhas() {
        return resenhaRepository.findAll();
    }

    //Busca uma resenha pelo id e lança uma exceção caso ela não exista
    public Resenha listarResenha(Integer id) {
        return resenhaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resenha não encontrada"));
    }

    //Salva uma nova resenha no banco de dados
    public Resenha salvarResenha(ResenhaDTO dto) {

        //Valida os dados da resenha
        validarResenha(dto);

        //Busca o usuário informado no DTO
        Usuario usuario = usuarioService.listarUsuario(dto.getUsuarioId());

        //Busca o filme informado no DTO
        Filme filme = filmeService.listarFilme(dto.getFilmeId());

        //Cria uma nova instância de resenha
        Resenha resenha = new Resenha();

        //Define os dados recebidos pelo DTO no objeto resenha
        resenha.setNota(dto.getNota());
        resenha.setComentario(dto.getComentario());
        resenha.setUsuario(usuario);
        resenha.setFilme(filme);

        //Salva a resenha no banco de dados
        return resenhaRepository.save(resenha);
    }

    //Atualiza os dados de uma resenha existente
    public Resenha atualizarResenha(Integer id, ResenhaDTO dto) {

        //Valida os dados da resenha
        validarResenha(dto);

        //Busca a resenha que será atualizada
        Resenha resenha = listarResenha(id);

        //Busca o usuário informado no DTO
        Usuario usuario = usuarioService.listarUsuario(dto.getUsuarioId());

        //Busca o filme informado no DTO
        Filme filme = filmeService.listarFilme(dto.getFilmeId());

        //Atualiza os dados através dos getters and setters
        resenha.setNota(dto.getNota());
        resenha.setComentario(dto.getComentario());
        resenha.setUsuario(usuario);
        resenha.setFilme(filme);

        //Salva no banco o objeto atualizado
        return resenhaRepository.save(resenha);
    }

    //Deleta uma resenha do banco de dados
    public void deletarResenha(Integer id) {

        //Busca a resenha que será removida
        Resenha resenha = listarResenha(id);

        //Remove o objeto do banco de dados
        resenhaRepository.delete(resenha);
    }

    //Valida os dados recebidos para cadastro ou atualização de uma resenha
    private void validarResenha(ResenhaDTO dto) {

        //Valida se a nota está entre 0 e 10
        if (dto.getNota() < 0 || dto.getNota() > 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A nota deve estar entre 0 e 10.");
        }

        //Valida se o comentário possui no mínimo 20 caracteres
        if (dto.getComentario() == null || dto.getComentario().trim().length() < 20) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comentário deve possuir no mínimo 20 caracteres.");
        }
    }
}
package com.messias.cinereview.repository;

import com.messias.cinereview.model.Filme;
import com.messias.cinereview.model.Resenha;
import com.messias.cinereview.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Indica que essa interface é um componente de acesso aos dados gerenciado pelo Spring
@Repository
public interface ResenhaRepository extends JpaRepository<Resenha, Integer> {

    //Busca todas as resenhas associadas a um usuário
    List<Resenha> findByUsuario(Usuario usuario);

    //Busca todas as resenhas associadas a um filme
    List<Resenha> findByFilme(Filme filme);
}

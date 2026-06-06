package com.messias.cinereview.repository;

import com.messias.cinereview.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Indica que essa interface é um componente de acesso aos dados gerenciado pelo Spring
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //Busca um usuário pelo email retornando um Optional para evitar NullPointerException
    Optional<Usuario> findByEmail(String email);

    //Verifica se já existe um usuário cadastrado com o email informado
    boolean existsByEmail(String email);
}

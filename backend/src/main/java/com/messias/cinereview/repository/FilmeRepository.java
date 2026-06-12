package com.messias.cinereview.repository;

import com.messias.cinereview.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Indica que essa interface é um componente de acesso aos dados gerenciado pelo Spring
@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

    //Busca filmes pelo gênero sem diferenciar letras maiúsculas e minúsculas
    List<Filme> findByGeneroIgnoreCase(String genero);
}

package com.messias.cinereview.repository;

import com.messias.cinereview.model.Resenha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResenhaRepository extends JpaRepository<Resenha, Integer> {
}

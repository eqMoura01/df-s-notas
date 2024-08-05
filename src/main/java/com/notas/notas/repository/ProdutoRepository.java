package com.notas.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
}

package com.notas.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.entities.Categoria;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
    
}

package com.notas.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.entities.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    
}

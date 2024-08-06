package com.notas.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.entities.Nota;
import com.notas.notas.repository.NotaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public Nota save(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<Nota> findAll() {
        return notaRepository.findAll();
    }

    public Nota findById(Long id) {

        Optional<Nota> nota = notaRepository.findById(id);

        if (!nota.isPresent()) {
            throw new EntityNotFoundException("Nota com o id " + id + " não encontrada");
        }

        return notaRepository.findById(id).orElse(null);
    }

    public Nota update(Nota nota) {

        Nota notaAtualizada = findById(nota.getId());

        BeanUtils.copyProperties(nota, notaAtualizada);

        return notaRepository.save(nota);
    }

    public Nota deleteById(Long id) {

        Nota nota = findById(id);
        notaRepository.deleteById(id);

        return nota;
    }
}

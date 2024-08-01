package com.notas.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.entities.Categoria;
import com.notas.notas.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            return categoria.get();
        }
        throw new EntityNotFoundException("Categoria com id " + id + " não encontrado");
    }

    public Categoria update(Categoria categoria) {
        Categoria categoriaSalva = findById(categoria.getId());
        BeanUtils.copyProperties(categoria, categoriaSalva);
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}

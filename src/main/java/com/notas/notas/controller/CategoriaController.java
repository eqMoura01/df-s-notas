package com.notas.notas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.notas.dto.CategoriaDTO;
import com.notas.notas.service.CategoriaService;
import com.notas.notas.util.CategoriaMapper;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoriaMapper.toCategoriaDTO(categoriaService.save(CategoriaMapper.toCategoria(categoriaDTO))));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll().stream().map(CategoriaMapper::toCategoriaDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(CategoriaMapper.toCategoriaDTO(categoriaService.findById(id)));
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.ok(CategoriaMapper.toCategoriaDTO(categoriaService.update(CategoriaMapper.toCategoria(categoriaDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

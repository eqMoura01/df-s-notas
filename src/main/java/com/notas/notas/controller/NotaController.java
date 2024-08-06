package com.notas.notas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.notas.dto.NotaDTO;
import com.notas.notas.service.NotaService;
import com.notas.notas.util.NotaMapper;

@RestController
@RequestMapping("/nota")
public class NotaController {
    
    @Autowired
    private NotaService notaService;

    @PostMapping
    public ResponseEntity<NotaDTO> save(@RequestBody NotaDTO notaDTO) {
        return ResponseEntity.ok(NotaMapper.toNotaDTO(notaService.save(NotaMapper.toNota(notaDTO))));
    }

    @GetMapping("/id")
    public ResponseEntity<NotaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(NotaMapper.toNotaDTO(notaService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<NotaDTO>> findAll() {
        return ResponseEntity.ok(NotaMapper.toNotaDTOList(notaService.findAll()));
    }

    @PutMapping
    public ResponseEntity<NotaDTO> update(@RequestBody NotaDTO notaDTO) {
        return ResponseEntity.ok(NotaMapper.toNotaDTO(notaService.update(NotaMapper.toNota(notaDTO))));
    }

    @DeleteMapping("/id")
    public ResponseEntity<NotaDTO> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(NotaMapper.toNotaDTO(notaService.deleteById(id)));
    }

}

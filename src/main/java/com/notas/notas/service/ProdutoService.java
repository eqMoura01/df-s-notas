package com.notas.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.entities.Produto;
import com.notas.notas.repository.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {

        Optional<Produto> produto = produtoRepository.findById(id);

        if (!produto.isPresent()) {
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado");
        }

        return produto.get();
    }

    public Produto update(Produto produto) {
        Produto produtoSalvo = findById(produto.getId());

        BeanUtils.copyProperties(produto, produtoSalvo);
        
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        findById(id);
        produtoRepository.deleteById(id);
    }
}

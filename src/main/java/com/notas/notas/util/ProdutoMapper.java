package com.notas.notas.util;

import com.notas.notas.dto.ProdutoDTO;
import com.notas.notas.entities.Produto;

public class ProdutoMapper {

    public static Produto toProduto(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getId(), produtoDTO.getNome(), produtoDTO.getDescricao(), produtoDTO.getPreco(),
                CategoriaMapper.toCategoria(produtoDTO.getCategoriaDTO()));
    }

    public static ProdutoDTO toProdutoDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(),
                CategoriaMapper.toCategoriaDTO(produto.getCategoria()));
    }

}

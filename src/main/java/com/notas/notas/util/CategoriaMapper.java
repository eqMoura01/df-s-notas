package com.notas.notas.util;

import com.notas.notas.dto.CategoriaDTO;
import com.notas.notas.entities.Categoria;

public abstract class CategoriaMapper {
    
    public static CategoriaDTO toCategoriaDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome(), categoria.getDescricao());
    }

    public static Categoria toCategoria(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome(), categoriaDTO.getDescricao());
    }
}

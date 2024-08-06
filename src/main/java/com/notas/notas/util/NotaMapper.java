package com.notas.notas.util;

import java.util.List;
import java.util.stream.Collectors;

import com.notas.notas.dto.NotaDTO;
import com.notas.notas.entities.Nota;

public class NotaMapper {

    public static NotaDTO toNotaDTO(Nota nota) {
        return new NotaDTO(nota.getId(), ClienteMapper.toClienteDTO(nota.getCliente()),
                ProdutoMapper.toProdutoDTOList(nota.getProdutos()), nota.getData());
    }

    public static Nota toNota(NotaDTO notaDTO) {
        return new Nota(notaDTO.getId(), ClienteMapper.toCliente(notaDTO.getClienteDTO()), notaDTO.getData(),
                ProdutoMapper.toProdutoList(notaDTO.getProdutosDTO()));
    }

    public static List<NotaDTO> toNotaDTOList(List<Nota> notas) {
        return notas.stream().map(NotaMapper::toNotaDTO).collect(Collectors.toList());
    }

}

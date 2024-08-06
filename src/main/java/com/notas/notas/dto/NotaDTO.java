package com.notas.notas.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotaDTO {
    private Long id;
    private ClienteDTO clienteDTO;
    private List<ProdutoDTO> produtosDTO;
    private Timestamp data;
}

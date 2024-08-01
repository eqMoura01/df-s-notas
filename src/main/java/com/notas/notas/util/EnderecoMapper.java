package com.notas.notas.util;

import com.notas.notas.dto.EnderecoDTO;
import com.notas.notas.entities.Endereco;

public abstract class EnderecoMapper {
    static Endereco toEndereco(EnderecoDTO enderecoDTO) {
        return new Endereco(enderecoDTO.getId(), enderecoDTO.getCep(), enderecoDTO.getNumero(), enderecoDTO.getComplemento());
    }

    static EnderecoDTO toEnderecoDTO(Endereco endereco) {
        return new EnderecoDTO(endereco.getId(), endereco.getCep(), endereco.getNumero(), endereco.getComplemento());
    }
}

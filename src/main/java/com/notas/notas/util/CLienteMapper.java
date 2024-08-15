package com.notas.notas.util;

import com.notas.notas.dto.ClienteDTO;
import com.notas.notas.entities.Cliente;

public abstract class ClienteMapper {

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(),
                EnderecoMapper.toEnderecoDTO(cliente.getEndereco()),
                ClienteAuthMapper.toClienteAuthDTO(cliente.getClienteAuth()));
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(),
                EnderecoMapper.toEndereco(clienteDTO.getEnderecoDTO()),
                ClienteAuthMapper.toClienteAuth(clienteDTO.getClienteAuthDTO()));
    }
}

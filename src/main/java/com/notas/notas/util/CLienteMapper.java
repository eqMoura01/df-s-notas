package com.notas.notas.util;

import com.notas.notas.dto.ClienteDTO;
import com.notas.notas.entities.Cliente;

public abstract class CLienteMapper {

    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail());
    }
}

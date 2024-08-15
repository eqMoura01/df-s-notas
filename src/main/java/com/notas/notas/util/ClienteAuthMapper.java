package com.notas.notas.util;

import com.notas.notas.dto.ClienteAuthDTO;
import com.notas.notas.entities.ClienteAuth;

public class ClienteAuthMapper {
        
        public static ClienteAuthDTO toClienteAuthDTO(ClienteAuth clienteAuth) {
            return new ClienteAuthDTO(clienteAuth.getId(), clienteAuth.getUsername(), clienteAuth.getPassword());
        }
    
        public static ClienteAuth toClienteAuth(ClienteAuthDTO clienteAuthDTO) {
            return new ClienteAuth(clienteAuthDTO.getId(), clienteAuthDTO.getUsername(), clienteAuthDTO.getPassword());
        }
}

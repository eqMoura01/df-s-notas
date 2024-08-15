package com.notas.notas.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.entities.Cliente;
import com.notas.notas.entities.ClienteAuth;
import com.notas.notas.repository.ClienteRepository;
import com.notas.notas.util.Hashing;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) throws NoSuchAlgorithmException {

        cliente.setClienteAuth(new ClienteAuth(null, cliente.getClienteAuth().getUsername(),
                Hashing.hashData(cliente.getClienteAuth().getPassword())));
                
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new EntityNotFoundException("Cliente com id " + id + " não encontrado");
    }

    public Cliente update(Cliente cliente) throws NoSuchAlgorithmException {
        Cliente clienteSalvo = findById(cliente.getId());

        ClienteAuth clienteAuth = new ClienteAuth(null, cliente.getClienteAuth().getUsername(),
                Hashing.hashData(cliente.getClienteAuth().getPassword()));
        
        BeanUtils.copyProperties(cliente, clienteSalvo);

        cliente.setClienteAuth(clienteAuth);

        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

}

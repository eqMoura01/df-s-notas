package com.notas.notas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.entities.Cliente;
import com.notas.notas.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
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

    public Cliente update( Cliente cliente) {
        Cliente clienteSalvo = findById(cliente.getId());
        
        BeanUtils.copyProperties(cliente, clienteSalvo);

        return clienteRepository.save(clienteSalvo);
    }

    public void delete(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
    }

}

package com.notas.notas.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notas.notas.dto.ClienteDTO;
import com.notas.notas.entities.Cliente;
import com.notas.notas.service.ClienteService;
import com.notas.notas.util.ClienteMapper;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> save(@RequestBody ClienteDTO clienteDTO) throws NoSuchAlgorithmException {

        Cliente cliente = ClienteMapper.toCliente(clienteDTO);
        Cliente clienteCriado = clienteService.save(cliente);
        ClienteDTO clienteCriadoDTO = ClienteMapper.toClienteDTO(clienteCriado);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriadoDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {

        List<ClienteDTO> clientesDTO = clienteService.findAll().stream()
                .map(ClienteMapper::toClienteDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(clientesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(ClienteMapper.toClienteDTO(clienteService.findById(id)));
    }

    @PutMapping
    public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO clienteDTO) throws NoSuchAlgorithmException {
        Cliente cliente = ClienteMapper.toCliente(clienteDTO);
        return ResponseEntity.ok(ClienteMapper.toClienteDTO(clienteService.update(cliente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}

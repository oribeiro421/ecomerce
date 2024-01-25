package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.ClienteDTO;
import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.service.ClienteService;
import com.ecomerce.ecomerce.view.model.ClienteRequest;
import com.ecomerce.ecomerce.view.model.ClienteResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> obterTodos(){
        List<ClienteDTO> clienteDTOS = clienteService.obterTodos();
        return new ResponseEntity<>(clienteDTOS.stream().map(clienteDTO -> new ModelMapper().map(clienteDTO, ClienteResponse.class)).toList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteResponse>> obterPorId(@PathVariable Long id){
        Optional<ClienteDTO> clienteDTO = clienteService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(clienteDTO.get(), ClienteResponse.class)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ClienteResponse> adicionar(@RequestBody ClienteRequest clienteRequest){
        ClienteDTO clienteDTO = new ModelMapper().map(clienteRequest, ClienteDTO.class);
        clienteDTO = clienteService.adicionar(clienteDTO);
        return new ResponseEntity<>(new ModelMapper().map(clienteDTO, ClienteResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> atualizar(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest){
        ClienteDTO clienteDTO = new ModelMapper().map(clienteRequest, ClienteDTO.class);
        clienteDTO = clienteService.atualizar(id, clienteDTO);
        return new ResponseEntity<>(new ModelMapper().map(clienteDTO, ClienteResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

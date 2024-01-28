package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.EnderecoDTO;
import com.ecomerce.ecomerce.model.Endereco;
import com.ecomerce.ecomerce.service.EnderecoService;
import com.ecomerce.ecomerce.view.model.EnderecoRequest;
import com.ecomerce.ecomerce.view.model.EnderecoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> obterTodos(){
        List<EnderecoDTO> enderecoDTOS = enderecoService.obterTodos();
        return new ResponseEntity<>(enderecoDTOS.stream().map(enderecoDTO -> new ModelMapper().map(enderecoDTO, EnderecoResponse.class)).toList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EnderecoResponse>> obterPorId(@PathVariable Long id){
        Optional<EnderecoDTO> enderecoDTO = enderecoService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(enderecoDTO.get(),EnderecoResponse.class)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EnderecoResponse> adicionar(@RequestBody EnderecoRequest enderecoRequest){
        EnderecoDTO enderecoDTO = new ModelMapper().map(enderecoRequest, EnderecoDTO.class);
        enderecoDTO = enderecoService.adicionar(enderecoDTO);
        return new ResponseEntity<>(new ModelMapper().map(enderecoDTO, EnderecoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponse> atualizar(@PathVariable Long id, @RequestBody EnderecoRequest enderecoRequest){
        EnderecoDTO enderecoDTO = new ModelMapper().map(enderecoRequest, EnderecoDTO.class);
        enderecoDTO = enderecoService.atualizar(id, enderecoDTO);
        return new ResponseEntity<>(new ModelMapper().map(enderecoDTO, EnderecoResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        enderecoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

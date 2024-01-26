package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.CategoriaDTO;
import com.ecomerce.ecomerce.model.Categoria;
import com.ecomerce.ecomerce.service.CategoriaService;
import com.ecomerce.ecomerce.view.model.CategoriaRequest;
import com.ecomerce.ecomerce.view.model.CategoriaResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> obterTodos(){
        List<CategoriaDTO> categoriaDTOS = categoriaService.obterTodos();
        return new ResponseEntity<>(categoriaDTOS.stream().map(categoriaDTO -> new ModelMapper().map(categoriaDTO, CategoriaResponse.class)).toList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaResponse>> obterPorId(@PathVariable Long id){
        Optional<CategoriaDTO> categoriaDTO = categoriaService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(categoriaDTO, CategoriaResponse.class)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CategoriaResponse> adicionar(@RequestBody CategoriaRequest categoriaRequest){
        CategoriaDTO categoriaDTO = new ModelMapper().map(categoriaRequest, CategoriaDTO.class);
        categoriaDTO = categoriaService.adicionar(categoriaDTO);
        return new ResponseEntity<>(new ModelMapper().map(categoriaDTO, CategoriaResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> atualizar(@PathVariable Long id, @RequestBody CategoriaRequest categoriaRequest){
        CategoriaDTO categoriaDTO = new ModelMapper().map(categoriaRequest, CategoriaDTO.class);
        categoriaDTO = categoriaService.atualizar(id, categoriaDTO);
        return new ResponseEntity<>(new ModelMapper().map(categoriaDTO, CategoriaResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        categoriaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

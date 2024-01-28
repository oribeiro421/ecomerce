package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.service.ProdutoService;
import com.ecomerce.ecomerce.dto.ProdutoDTO;
import com.ecomerce.ecomerce.view.model.ProdutoRequest;
import com.ecomerce.ecomerce.view.model.ProdutoResponse;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos(){

        List<ProdutoDTO> produtos = produtoService.obterTodos();
        return new ResponseEntity<>(produtos.stream().map(produtoDTO -> new ModelMapper().map(produtoDTO, ProdutoResponse.class)).toList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Long id){

        Optional<ProdutoDTO> produtoDTO = produtoService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(produtoDTO.get(), ProdutoResponse.class)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq){
        ProdutoDTO produtoDTO = new ModelMapper().map(produtoReq, ProdutoDTO.class);
        produtoDTO = produtoService.adicionar(produtoDTO);
        return new ResponseEntity<>(new ModelMapper().map(produtoDTO, ProdutoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest produtoReq){
        ProdutoDTO produtoDTO = new ModelMapper().map(produtoReq, ProdutoDTO.class);
        produtoDTO = produtoService.atualizar(id, produtoDTO);
        return new ResponseEntity<>(new ModelMapper().map(produtoDTO, ProdutoResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

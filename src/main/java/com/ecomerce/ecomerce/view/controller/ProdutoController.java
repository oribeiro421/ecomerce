package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.Produto;
import com.ecomerce.ecomerce.service.ProdutoService;
import com.ecomerce.ecomerce.shared.ProdutoDTO;
import com.ecomerce.ecomerce.view.model.ProdutoRequest;
import com.ecomerce.ecomerce.view.model.ProdutoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos(){

        List<ProdutoDTO> produtos = produtoService.obterTodos();
        ModelMapper mapper = new ModelMapper();
        List<ProdutoResponse> produtoResponse = produtos.stream().map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class)).toList();
        return new ResponseEntity<>(produtoResponse, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Long id){

        Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
        ProdutoResponse produtoResponse = new ModelMapper().map(dto.get(), ProdutoResponse.class);
        return new ResponseEntity<>(Optional.of(produtoResponse), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(produtoReq, ProdutoDTO.class);
        dto = produtoService.adicionar(dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest produtoReq){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(produtoReq, ProdutoDTO.class);
        dto = produtoService.atualizar(id, dto);
        return new ResponseEntity<>(mapper.map(dto, ProdutoResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

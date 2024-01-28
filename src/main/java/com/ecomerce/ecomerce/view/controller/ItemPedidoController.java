package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.ItemPedidoDTO;
import com.ecomerce.ecomerce.model.ItemPedido;
import com.ecomerce.ecomerce.service.ItemPedidoService;
import com.ecomerce.ecomerce.view.model.ItemPedidoRequest;
import com.ecomerce.ecomerce.view.model.ItemPedidoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponse>> obterTodos(){
        List<ItemPedidoDTO> itemPedidoDTOS = itemPedidoService.obterTodos();
        return new ResponseEntity<>(itemPedidoDTOS.stream().map(itemPedidoDTO -> new ModelMapper().map(itemPedidoDTO, ItemPedidoResponse.class)).toList(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemPedidoResponse>> obterPorId(@PathVariable Long id){
        Optional<ItemPedidoDTO> itemPedidoDTO = itemPedidoService.obterPorId(id);
        return new ResponseEntity<>(Optional.of(new ModelMapper().map(itemPedidoDTO.get(), ItemPedidoResponse.class)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ItemPedidoResponse> adicionar(@RequestBody ItemPedidoRequest itemPedidoRequest){
        ItemPedidoDTO itemPedidoDTO = new ModelMapper().map(itemPedidoRequest, ItemPedidoDTO.class);
        itemPedidoDTO = itemPedidoService.adicionar(itemPedidoDTO);
        return new ResponseEntity<>(new ModelMapper().map(itemPedidoDTO, ItemPedidoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponse> atualizar(@PathVariable Long id, @RequestBody ItemPedidoRequest itemPedidoRequest){
        ItemPedidoDTO itemPedidoDTO = new ModelMapper().map(itemPedidoRequest, ItemPedidoDTO.class);
        itemPedidoDTO = itemPedidoService.atualizar(id, itemPedidoDTO);
        return new ResponseEntity<>(new ModelMapper().map(itemPedidoDTO, ItemPedidoResponse.class),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        itemPedidoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

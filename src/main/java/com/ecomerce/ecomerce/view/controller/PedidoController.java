package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.PedidoDTO;
import com.ecomerce.ecomerce.model.Pedido;
import com.ecomerce.ecomerce.service.PedidoService;
import com.ecomerce.ecomerce.view.model.PedidoRequest;
import com.ecomerce.ecomerce.view.model.PedidoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> obterTodos(){
        List<PedidoDTO> pedidoDTOS = pedidoService.obterTodos();
        List<PedidoResponse> pedidoResponses = pedidoDTOS.stream().map(pedidoDTO -> new ModelMapper().map(pedidoDTO, PedidoResponse.class)).toList();
        return new ResponseEntity<>(pedidoResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PedidoResponse>> obterPorId(@PathVariable Long id){
        Optional<PedidoDTO> pedidoDTO = pedidoService.obterPorId(id);
        PedidoResponse pedidoResponse = new ModelMapper().map(pedidoDTO.get(), PedidoResponse.class);
        return new ResponseEntity<>(Optional.of(pedidoResponse),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PedidoResponse> adicionar(@RequestBody PedidoRequest pedidoRequest){
        PedidoDTO pedidoDTO = new ModelMapper().map(pedidoRequest, PedidoDTO.class);
        pedidoDTO = pedidoService.adicionar(pedidoDTO);
        return new ResponseEntity<>(new ModelMapper().map(pedidoDTO, PedidoResponse.class), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponse> atualizar(@PathVariable Long id, @RequestBody PedidoRequest pedidoRequest){
        PedidoDTO pedidoDTO = new ModelMapper().map(pedidoRequest, PedidoDTO.class);
        pedidoDTO = pedidoService.atualizar(id, pedidoDTO);
        return new  ResponseEntity<>(new ModelMapper().map(pedidoDTO, PedidoResponse.class), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        pedidoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

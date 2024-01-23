package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.Pedido;
import com.ecomerce.ecomerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obterTodos(){
        return pedidoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<Pedido> obterPorId(@PathVariable Long id){
        return pedidoService.obterPorId(id);
    }
    @PostMapping
    public Pedido adicionar(@RequestBody Pedido pedido){
        return pedidoService.adicionar(pedido);
    }
    @PutMapping("/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
        return pedidoService.atualizar(id, pedido);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        pedidoService.deletar(id);
    }
}

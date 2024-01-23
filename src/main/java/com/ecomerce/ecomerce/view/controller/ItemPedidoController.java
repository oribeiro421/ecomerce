package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.ItemPedido;
import com.ecomerce.ecomerce.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> obterTodos(){
        return itemPedidoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<ItemPedido> obterPorId(@PathVariable Long id){
        return itemPedidoService.obterPorId(id);
    }
    @PostMapping
    public ItemPedido adicionar(@RequestBody ItemPedido itemPedido){
        return itemPedidoService.adicionar(itemPedido);
    }
    @PutMapping("/{id}")
    public ItemPedido atualizar(@PathVariable Long id, @RequestBody ItemPedido itemPedido){
        return itemPedidoService.atualizar(id, itemPedido);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        itemPedidoService.deletar(id);
    }
}

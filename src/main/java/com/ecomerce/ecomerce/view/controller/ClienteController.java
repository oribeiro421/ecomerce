package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos(){
        return clienteService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<Cliente> obterPorId(@PathVariable Long id){
            return clienteService.obterPorId(id);
    }
    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }
    @PutMapping("{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        return clienteService.atualizar(id, cliente);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        clienteService.deletar(id);
    }

}

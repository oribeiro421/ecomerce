package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.Endereco;
import com.ecomerce.ecomerce.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> obterTodos(){
        return enderecoService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<Endereco> obterPorId(@PathVariable Long id){
        return enderecoService.obterPorId(id);
    }
    @PostMapping
    public Endereco adicionar(@RequestBody Endereco endereco){
        return enderecoService.adicionar(endereco);
    }
    @PutMapping("/{id}")
    public Endereco atualizar(@PathVariable Long id, @RequestBody Endereco endereco){
        return enderecoService.atualizar(id, endereco);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        enderecoService.deletar(id);
    }
}

package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.model.Categoria;
import com.ecomerce.ecomerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obterTodos(){
        return categoriaService.obterTodos();
    }
    @GetMapping("/{id}")
    public Optional<Categoria> obterPorId(@PathVariable Long id){
        return categoriaService.obterPorId(id);
    }
    @PostMapping
    public Categoria adicionar(@RequestBody Categoria categoria){
        return categoriaService.adicionar(categoria);
    }
    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.atualizar(id, categoria);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        categoriaService.deletar(id);
    }
}

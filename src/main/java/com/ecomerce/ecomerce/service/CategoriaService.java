package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Categoria;
import com.ecomerce.ecomerce.model.Produto;
import com.ecomerce.ecomerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obterTodos(){
        return categoriaRepository.findAll();
    }
    public Optional<Categoria> obterPorId(Long id){
        return categoriaRepository.findById(id);
    }
    public Categoria adicionar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    public Categoria atualizar(Long id, Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}

package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.dto.CategoriaDTO;
import com.ecomerce.ecomerce.model.Categoria;
import com.ecomerce.ecomerce.model.Produto;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.CategoriaRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> obterTodos(){
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoria -> new ModelMapper().map(categoria, CategoriaDTO.class)).toList();
    }
    public Optional<CategoriaDTO> obterPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        CategoriaDTO categoriaDTO = new ModelMapper().map(categoria, CategoriaDTO.class);
        return Optional.of(categoriaDTO);
    }
    public CategoriaDTO adicionar(CategoriaDTO categoriaDTO){
        Categoria categoria = new ModelMapper().map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        categoriaDTO.setId(categoria.getId());
        return categoriaDTO;
    }
    public CategoriaDTO atualizar(Long id, @NotNull CategoriaDTO categoriaDTO){
        categoriaDTO.setId(id);
        Categoria categoria = new ModelMapper().map(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        return categoriaDTO;
    }
    public void deletar(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse produto");
        }
        categoriaRepository.deleteById(id);
    }
}

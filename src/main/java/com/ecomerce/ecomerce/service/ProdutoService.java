package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Produto;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.ProdutoRepository;
import com.ecomerce.ecomerce.dto.ProdutoDTO;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> obterTodos(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class)).collect(Collectors.toList());
    }
    public Optional<ProdutoDTO> obterPorId(Long id){

        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);
        return Optional.of(dto);
    }
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        Produto produto = new ModelMapper().map(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        produtoDto.setId(produto.getId());
        return produtoDto;
    }
    public ProdutoDTO atualizar(Long id, @NotNull ProdutoDTO produtoDto){
        produtoDto.setId(id);
        Produto produto = new ModelMapper().map(produtoDto, Produto.class);
        produtoRepository.save(produto);
        return produtoDto;
    }
    public void deletar(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse produto");
        }
        produtoRepository.deleteById(id);
    }
}
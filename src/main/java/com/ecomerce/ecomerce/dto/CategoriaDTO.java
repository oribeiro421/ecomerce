package com.ecomerce.ecomerce.dto;

import com.ecomerce.ecomerce.model.Produto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

public class CategoriaDTO {

    private Long id;
    private String descricao;
    private List<Produto> produtos;

    public CategoriaDTO(){

    }
    public CategoriaDTO(Long id, String descricao, List<Produto> produtos) {
        this.id = id;
        this.descricao = descricao;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

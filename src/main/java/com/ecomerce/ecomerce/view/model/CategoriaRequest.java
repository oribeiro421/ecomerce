package com.ecomerce.ecomerce.view.model;

import com.ecomerce.ecomerce.model.Produto;

import java.util.List;

public class CategoriaRequest {

    private String descricao;
    private List<Produto> produtos;

    public CategoriaRequest(){

    }
    public CategoriaRequest(String descricao, List<Produto> produtos) {
        this.descricao = descricao;
        this.produtos = produtos;
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

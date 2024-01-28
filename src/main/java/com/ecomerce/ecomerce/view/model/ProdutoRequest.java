package com.ecomerce.ecomerce.view.model;

import com.ecomerce.ecomerce.model.Categoria;
import com.ecomerce.ecomerce.model.ItemPedido;

import java.util.Date;
import java.util.List;

public class ProdutoRequest {

    private String nome;
    private Double quantidadeEstoque;
    private Double valorCusto;
    private Double valorVenda;
    private Date dataDeCadastro;
    private String observacao;
    private List<Categoria> categorias;
    private List<ItemPedido> itens;

    public ProdutoRequest(){
    }
    public ProdutoRequest(String nome, Double quantidadeEstoque, Double valorCusto, Double valorVenda, Date dataDeCadastro, String observacao, List<Categoria> categorias, List<ItemPedido> itens) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.dataDeCadastro = dataDeCadastro;
        this.observacao = observacao;
        this.categorias = categorias;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}

package com.ecomerce.ecomerce.view.model;

import com.ecomerce.ecomerce.model.Pedido;
import com.ecomerce.ecomerce.model.Produto;

public class ItemPedidoRequest {

    private Pedido pedido;
    private Produto produtos;
    private Integer quantidade;
    private Double descontoUnitario;

    public ItemPedidoRequest(){

    }
    public ItemPedidoRequest(Pedido pedido, Produto produtos, Integer quantidade, Double descontoUnitario) {
        this.pedido = pedido;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.descontoUnitario = descontoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDescontoUnitario() {
        return descontoUnitario;
    }

    public void setDescontoUnitario(Double descontoUnitario) {
        this.descontoUnitario = descontoUnitario;
    }
}

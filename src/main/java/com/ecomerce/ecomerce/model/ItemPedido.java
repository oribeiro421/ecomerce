package com.ecomerce.ecomerce.model;

import jakarta.persistence.*;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItemPedido")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produtos;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "desconto_unitario")
    private Double descontoUnitario;

    public ItemPedido(){

    }
    public ItemPedido(Long id, Pedido pedido, Produto produtos, Integer quantidade, Double descontoUnitario) {
        this.id = id;
        this.pedido = pedido;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.descontoUnitario = descontoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package com.ecomerce.ecomerce.view.model;

import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.model.ItemPedido;

import java.util.Date;
import java.util.List;

public class PedidoRequest {

    private Date data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Double descontoTotal;
    private Double valorTotal;

    public PedidoRequest(){

    }
    public PedidoRequest(Date data, Cliente cliente, List<ItemPedido> itens, Double descontoTotal, Double valorTotal) {
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.descontoTotal = descontoTotal;
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Double getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(Double descontoTotal) {
        this.descontoTotal = descontoTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}

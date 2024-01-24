package com.ecomerce.ecomerce.dto;

import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.model.ItemPedido;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class PedidoDTO {

    private Long id;
    private Date data;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Double descontoTotal;
    private Double valorTotal;

    public PedidoDTO(){

    }
    public PedidoDTO(Long id, Date data, Cliente cliente, List<ItemPedido> itens, Double descontoTotal, Double valorTotal) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
        this.descontoTotal = descontoTotal;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

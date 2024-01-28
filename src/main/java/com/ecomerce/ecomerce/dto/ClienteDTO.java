package com.ecomerce.ecomerce.dto;

import com.ecomerce.ecomerce.model.Endereco;
import com.ecomerce.ecomerce.model.Pedido;
import jakarta.persistence.*;

import java.util.List;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private Endereco enderecos;
    private List<Pedido> pedidos;

    public ClienteDTO(){

    }
    public ClienteDTO(Long id, String nome, String telefone, String cpf, String email, Endereco enderecos, List<Pedido> pedidos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.enderecos = enderecos;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco enderecos) {
        this.enderecos = enderecos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

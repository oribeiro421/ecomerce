package com.ecomerce.ecomerce.dto;

import com.ecomerce.ecomerce.model.Cliente;

public class EnderecoDTO {

    private Long id;
    private String cep;
    private String rua;
    private Cliente cliente;

    public EnderecoDTO(){
    }
    public EnderecoDTO(Long id, String cep, String rua, Cliente cliente) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

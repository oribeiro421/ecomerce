package com.ecomerce.ecomerce.view.model;

import com.ecomerce.ecomerce.model.Cliente;

public class EnderecoRequest {

    private String cep;
    private String rua;
    private Cliente cliente;

    public EnderecoRequest(){
    }
    public EnderecoRequest(String cep, String rua, Cliente cliente) {
        this.cep = cep;
        this.rua = rua;
        this.cliente = cliente;
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

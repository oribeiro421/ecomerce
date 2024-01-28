package com.ecomerce.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long id;
    private String descricao;

    @ManyToMany(mappedBy = "categorias")
    @JsonBackReference
    private List<Produto> produtos;

    public Categoria(){

    }
    public Categoria(Long id, String descricao, List<Produto> produtos) {
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

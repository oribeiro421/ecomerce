package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Pedido;
import com.ecomerce.ecomerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> obterTodos(){
        return pedidoRepository.findAll();
    }
    public Optional<Pedido> obterPorId(Long id){
        return pedidoRepository.findById(id);
    }
    public Pedido adicionar(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public Pedido atualizar(Long id, Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }
}

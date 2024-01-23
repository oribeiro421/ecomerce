package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.ItemPedido;
import com.ecomerce.ecomerce.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> obterTodos(){
        return itemPedidoRepository.findAll();
    }
    public Optional<ItemPedido> obterPorId(Long id){
        return itemPedidoRepository.findById(id);
    }
    public ItemPedido adicionar(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
    public ItemPedido atualizar(Long id, ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
    public void deletar(Long id){
        itemPedidoRepository.deleteById(id);
    }
}

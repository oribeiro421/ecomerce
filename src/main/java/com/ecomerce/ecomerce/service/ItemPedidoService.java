package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.dto.ItemPedidoDTO;
import com.ecomerce.ecomerce.model.ItemPedido;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.ItemPedidoRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedidoDTO> obterTodos(){
        List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
        return itemPedidos.stream().map(itemPedido -> new ModelMapper().map(itemPedido, ItemPedidoDTO.class)).toList();
    }
    public Optional<ItemPedidoDTO> obterPorId(Long id){
        Optional<ItemPedido> itemPedidos =itemPedidoRepository.findById(id);
        if(itemPedidos.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        ItemPedidoDTO dto = new ModelMapper().map(itemPedidos, ItemPedidoDTO.class);
        return Optional.of(dto);
    }
    public ItemPedidoDTO adicionar(ItemPedidoDTO itemPedidoDTO){
        ItemPedido itemPedido = new ModelMapper().map(itemPedidoDTO, ItemPedido.class);
        itemPedidoRepository.save(itemPedido);
        itemPedidoDTO.setId(itemPedido.getId());
        return itemPedidoDTO;
    }
    public ItemPedidoDTO atualizar(Long id, @NotNull ItemPedidoDTO itemPedidoDTO){
        itemPedidoDTO.setId(id);
        ItemPedido itemPedido = new ModelMapper().map(itemPedidoDTO, ItemPedido.class);
        itemPedidoRepository.save(itemPedido);
        return itemPedidoDTO;
    }
    public void deletar(Long id){
        Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
        if(itemPedido.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse produto");
        }
        itemPedidoRepository.deleteById(id);
    }
}

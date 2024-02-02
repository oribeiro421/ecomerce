package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.dto.PedidoDTO;
import com.ecomerce.ecomerce.email.Email;
import com.ecomerce.ecomerce.email.EmailService;
import com.ecomerce.ecomerce.model.Pedido;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.PedidoRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public List<PedidoDTO> obterTodos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedido -> new ModelMapper().map(pedido, PedidoDTO.class)).toList();
    }
    public Optional<PedidoDTO> obterPorId(Long id){
        Optional<Pedido> pedidos = pedidoRepository.findById(id);
        if(pedidos.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        PedidoDTO dto = new ModelMapper().map(pedidos.get(), PedidoDTO.class);
        return Optional.of(dto);
    }
    public PedidoDTO adicionar(PedidoDTO pedidoDTO){
        Pedido pedidos = new ModelMapper().map(pedidoDTO, Pedido.class);
        pedidos = pedidoRepository.save(pedidos);
        pedidoDTO.setId(pedidos.getId());
        return pedidoDTO;
    }
    public PedidoDTO atualizar(Long id, @NotNull PedidoDTO pedidoDTO){
        pedidoDTO.setId(id);
        Pedido pedidos = new ModelMapper().map(pedidoDTO, Pedido.class);
        pedidoRepository.save(pedidos);
        return pedidoDTO;
    }
    public void deletar(Long id){
        Optional<Pedido> pedidos = pedidoRepository.findById(id);
        if(pedidos.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse pedido");
        }
        pedidoRepository.deleteById(id);
    }
}

package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.dto.ClienteDTO;
import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.ClienteRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> obterTodos(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(cliente -> new ModelMapper().map(cliente, ClienteDTO.class)).toList();
    }
    public Optional<ClienteDTO> obterPorId(Long id){
        Optional<Cliente> clientes = clienteRepository.findById(id);
        if (clientes.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        ClienteDTO clienteDTO = new ModelMapper().map(clientes.get(), ClienteDTO.class);
        return Optional.of(clienteDTO);
    }
    public ClienteDTO adicionar(ClienteDTO clienteDTO){
        Cliente cliente = new ModelMapper().map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        clienteDTO.setId(cliente.getId());
        return clienteDTO;
    }
    public ClienteDTO atualizar(Long id,@NotNull ClienteDTO clienteDTO){
        clienteDTO.setId(id);
        Cliente cliente = new ModelMapper().map(clienteDTO, Cliente.class);
        clienteRepository.save(cliente);
        return clienteDTO;
    }
    public void deletar(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse produto");
        }
        clienteRepository.deleteById(id);
    }
}

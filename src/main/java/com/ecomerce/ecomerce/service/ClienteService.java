package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Cliente;
import com.ecomerce.ecomerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> obterPorId(Long id){
        return clienteRepository.findById(id);
    }
    public Cliente adicionar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente atualizar(Long id, Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
}

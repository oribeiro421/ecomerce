package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.model.Endereco;
import com.ecomerce.ecomerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> obterTodos(){
        return enderecoRepository.findAll();
    }
    public Optional<Endereco> obterPorId(Long id){
        return enderecoRepository.findById(id);
    }
    public Endereco adicionar(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    public Endereco atualizar(Long id, Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }
}

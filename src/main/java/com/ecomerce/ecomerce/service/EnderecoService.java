package com.ecomerce.ecomerce.service;

import com.ecomerce.ecomerce.dto.EnderecoDTO;
import com.ecomerce.ecomerce.model.Endereco;
import com.ecomerce.ecomerce.model.exception.ResourceNotFoundException;
import com.ecomerce.ecomerce.repository.EnderecoRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoDTO> obterTodos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(endereco -> new ModelMapper().map(endereco, EnderecoDTO.class)).toList();
    }
    public Optional<EnderecoDTO> obterPorId(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()){
            throw new ResourceNotFoundException("Produto com id:" + id + " não encontrado");
        }
        EnderecoDTO enderecoDTO = new ModelMapper().map(endereco.get(), EnderecoDTO.class);
        return Optional.of(enderecoDTO);
    }
    public EnderecoDTO adicionar(EnderecoDTO enderecoDTO){
        Endereco endereco = new ModelMapper().map(enderecoDTO, Endereco.class);
        enderecoRepository.save(endereco);
        enderecoDTO.setId(endereco.getId());
        return enderecoDTO;
    }
    public EnderecoDTO atualizar(Long id,@NotNull EnderecoDTO enderecoDTO){
        enderecoDTO.setId(id);
        Endereco endereco = new ModelMapper().map(enderecoDTO, Endereco.class);
        enderecoRepository.save(endereco);
        return enderecoDTO;
    }
    public void deletar(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isEmpty()){
            throw new ResourceNotFoundException("Não foi possivel deletar esse produto");
        }
        enderecoRepository.deleteById(id);
    }
}

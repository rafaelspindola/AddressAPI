package com.attornatus.addressapi.service;

import com.attornatus.addressapi.models.Pessoa;
import com.attornatus.addressapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> consultarPessoa(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

}

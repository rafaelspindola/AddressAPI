package com.attornatus.addressapi.service;

import com.attornatus.addressapi.models.Endereco;
import com.attornatus.addressapi.models.Pessoa;
import com.attornatus.addressapi.repository.EnderecoRepository;
import com.attornatus.addressapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco criarEndereco(Long pessoaId, Endereco endereco) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if (pessoa.isPresent()) {
            endereco.setPessoa(pessoa.get());
            return enderecoRepository.save(endereco);
        }
        throw new Exception("Pessoa não encontrada");
    }

    public List<Endereco> listarEnderecos(Long pessoaId) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if (pessoa.isPresent()) {
            Pessoa pessoaEncontrada = pessoa.get();
            return pessoaEncontrada.getEnderecos();
        }
        throw new Exception("Pessoa não encontrada");
    }
}

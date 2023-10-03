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

    public void definirEnderecoPrincipal(Long pessoaId, Long enderecoId) throws Exception {
        List<Endereco> enderecos = listarEnderecos(pessoaId);

        // Find the selected address by ID
        Optional<Endereco> enderecoOpc = enderecos.stream().filter(endereco -> endereco.getId().equals(enderecoId)).findFirst();

        if (enderecoOpc.isPresent()) {
            Endereco enderecoSelecionado = enderecoOpc.get();
            enderecoSelecionado.setPrincipal(true);
            enderecoRepository.save(enderecoSelecionado);

            enderecos.stream().filter(endereco -> !endereco.getId().equals(enderecoId)).forEach(endereco -> endereco.setPrincipal(false));
            enderecoRepository.saveAll(enderecos);
        } else {
            throw new Exception("Endereço não encontrado.");
        }
    }
}

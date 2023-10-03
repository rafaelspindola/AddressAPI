package com.attornatus.addressapi.controller;

import com.attornatus.addressapi.models.Endereco;
import com.attornatus.addressapi.models.Pessoa;
import com.attornatus.addressapi.repository.PessoaRepository;
import com.attornatus.addressapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pessoas/{pessoaId}/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public Endereco criarEndereco(@PathVariable Long pessoaId, @RequestBody Endereco endereco) throws Exception {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if (pessoa.isPresent()) {
            endereco.setPessoa(pessoa.get());
            return enderecoService.criarEndereco(pessoaId, endereco);
        }
        throw new Exception("Pessoa não encontrada");
    }
}

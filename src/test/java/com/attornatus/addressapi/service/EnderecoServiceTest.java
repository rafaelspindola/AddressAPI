package com.attornatus.addressapi.service;

import com.attornatus.addressapi.models.Endereco;
import com.attornatus.addressapi.models.Pessoa;
import com.attornatus.addressapi.repository.EnderecoRepository;
import com.attornatus.addressapi.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private Pessoa pessoa;
    @Mock
    private List<Endereco> enderecos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoa = new Pessoa();
        pessoa.setId(3L);

        enderecos = new ArrayList<>();
        Endereco endereco1 = new Endereco();
        endereco1.setCidade("Fortaleza");
        endereco1.setId(1L);
        endereco1.setPrincipal(true);
        enderecos.add(endereco1);

        Endereco endereco2 = new Endereco();
        endereco2.setCidade("João Pessoa");
        endereco2.setId(2L);
        endereco2.setPrincipal(false);
        enderecos.add(endereco2);

        pessoa.setEnderecos(enderecos);
    }

    @Test
    @DisplayName("Deve criar um novo endereço associado a uma pessoa")
    void criarEndereco() throws Exception {
        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(enderecos.get(1));

        Endereco criado = enderecoService.criarEndereco(pessoa.getId(),enderecos.get(1));

        assertNotNull(criado);
        assertEquals("João Pessoa", criado.getCidade());
    }

    @Test
    @DisplayName("Deve listar endereços de uma pessoa com sucesso")
    void listarEnderecos() throws Exception{
        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));

        pessoa.setEnderecos(enderecos);
        List<Endereco> resultado = enderecoService.listarEnderecos(pessoa.getId());

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Fortaleza", resultado.get(0).getCidade());
        assertEquals("João Pessoa", resultado.get(1).getCidade());
    }

    @Test
    @DisplayName("Deve definir um endereço principal com sucesso")
    void definirEnderecoPrincipal() throws Exception {
        when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
        enderecoService.definirEnderecoPrincipal(pessoa.getId(), 1L);

        assertTrue(enderecos.get(0).isPrincipal());
        assertFalse(enderecos.get(1).isPrincipal());
    }
}
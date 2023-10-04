package com.attornatus.addressapi.service;

import com.attornatus.addressapi.models.Pessoa;
import com.attornatus.addressapi.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private Pessoa pessoa1;

    @Mock
    private Pessoa pessoa2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pessoa1 = new Pessoa();
        pessoa1.setId(3L);
        pessoa1.setNome("Amanda");

        pessoa2 = new Pessoa();
        pessoa2.setId(4L);
        pessoa2.setNome("Eduardo");

    }

    @Test
    @DisplayName("Cria uma pessoa com sucesso")
    void criarPessoa() {
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa1);

        Pessoa criada = pessoaService.criarPessoa(pessoa1);
        assertNotNull(criada);
        assertEquals("Amanda", pessoa1.getNome());
    }

    @Test
    @DisplayName("Consulta uma pessoa específica com sucesso")
    void consultarPessoa() {
        when(pessoaRepository.findById(pessoa2.getId())).thenReturn(Optional.of(pessoa2));

        Optional<Pessoa> pessoaConsultada = pessoaService.consultarPessoa(pessoa2.getId());

        assertTrue(pessoaConsultada.isPresent());
        assertEquals("Eduardo", pessoa2.getNome());
    }

    @Test
    @DisplayName("Retorna uma resposta vazia")
    void consultarPessoaExcecao() {
        when(pessoaRepository.findById(any())).thenReturn(Optional.empty());

        Optional<Pessoa> consultada = pessoaService.consultarPessoa(any());

        assertTrue(consultada.isEmpty());
    }

    @Test
    @DisplayName("Lista todas as pessoas com sucesso")
    void listarPessoas() {
        List<Pessoa> pessoas = List.of(pessoa1, pessoa2);
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> listagem = pessoaService.listarPessoas();

        assertEquals(2, listagem.size());
        assertEquals("Amanda", listagem.get(0).getNome());
        assertEquals("Eduardo", listagem.get(1).getNome());
    }

    @Test
    @DisplayName("Edita uma pessoa com sucesso")
    void editarPessoa() {
        when(pessoaRepository.findById(pessoa1.getId())).thenReturn(Optional.of(pessoa1));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(new Pessoa());

        Optional<Pessoa> editada = pessoaService.editarPessoa(pessoa1.getId(), new Pessoa());

        assertTrue(editada.isPresent());
    }

    @Test
    @DisplayName("Retorna uma resposta vazia")
    void editarPessoaExcecao() {
        when(pessoaRepository.findById(any())).thenReturn(Optional.empty());

        Optional<Pessoa> editada = pessoaService.editarPessoa(any(), new Pessoa());

        assertTrue(editada.isEmpty());
    }
}
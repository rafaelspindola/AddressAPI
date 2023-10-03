package com.attornatus.addressapi.repository;

import com.attornatus.addressapi.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}

package com.attornatus.addressapi.repository;

import com.attornatus.addressapi.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

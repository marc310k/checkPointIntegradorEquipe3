package com.dh.cleanodonto.cleanodonto.repository;

import com.dh.cleanodonto.cleanodonto.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EnderecoRespository extends JpaRepository<Endereco, Integer> {
}

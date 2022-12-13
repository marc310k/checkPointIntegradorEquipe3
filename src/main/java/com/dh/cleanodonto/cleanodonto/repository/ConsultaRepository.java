package com.dh.cleanodonto.cleanodonto.repository;

import com.dh.cleanodonto.cleanodonto.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}

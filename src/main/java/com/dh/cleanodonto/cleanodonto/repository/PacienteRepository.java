package com.dh.cleanodonto.cleanodonto.repository;

import com.dh.cleanodonto.cleanodonto.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}

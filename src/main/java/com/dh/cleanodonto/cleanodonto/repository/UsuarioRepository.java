package com.dh.cleanodonto.cleanodonto.repository;

import com.dh.cleanodonto.cleanodonto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

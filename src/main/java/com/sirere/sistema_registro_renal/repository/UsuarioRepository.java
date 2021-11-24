package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.Usuario;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String userName);
    boolean existsByUsername(String userName);
}

package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.Usuario;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
//@NoRepositoryBean
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuario u", nativeQuery = true)
    public List<Usuario> findOnlyUsuario();

    @Query(value = "SELECT * FROM usuario u WHERE u.username = ?1", nativeQuery = true)
    public Optional<Usuario> findByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM usuario u WHERE u.username = ?1", nativeQuery = true)
    public Optional<Usuario> existByUsername(String username);

}

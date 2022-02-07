package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {
    @Query(value = "SELECT * FROM examen e WHERE e.id_filiacion = ?1", nativeQuery = true)
    List<Examen> findExamnByFiliacion(Long id_filiacion);


}

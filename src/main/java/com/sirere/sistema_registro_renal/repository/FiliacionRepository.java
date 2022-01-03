package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.Filiacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliacionRepository extends JpaRepository<Filiacion,Long> {
}

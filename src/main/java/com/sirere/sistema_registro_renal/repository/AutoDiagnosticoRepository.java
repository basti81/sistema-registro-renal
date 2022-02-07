package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.AutoDiagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoDiagnosticoRepository extends JpaRepository<AutoDiagnostico, Long> {
//    //LISTA AUTODIAGNOSTICO
//    @Query(value = " SELECT ad FROM auto_diagnostico ad ")
//    public List<AutoDiagnostico> findAllAutoDiagnostico();
}

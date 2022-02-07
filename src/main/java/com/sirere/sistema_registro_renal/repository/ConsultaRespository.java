package com.sirere.sistema_registro_renal.repository;

import com.sirere.sistema_registro_renal.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRespository extends JpaRepository<Consulta,Long> {
    @Query(value = "SELECT * FROM consulta c WHERE c.id_paciente = ?1",nativeQuery = true)
    List<Consulta> myConsultas(@Param("id_paciente") Long id_paciente);


}

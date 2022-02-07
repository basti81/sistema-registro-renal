package com.sirere.sistema_registro_renal.services;

import com.sirere.sistema_registro_renal.biblioteca.Formato;
import com.sirere.sistema_registro_renal.entity.Consulta;
import com.sirere.sistema_registro_renal.repository.ConsultaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRespository consultaRespository;
    Formato formato = new Formato();

    public void save(Consulta consulta){
        consulta.setFecha_consulta(formato.today());
        consulta.setVisto(false);
        consultaRespository.save(consulta);
    }

    public List<Consulta> list(){
        return consultaRespository.findAll();
    }

    public List<Consulta> myConsultas(Long id_paciente){
        return consultaRespository.myConsultas(id_paciente);
    }

    public boolean existsById(Long id_consulta){
        return consultaRespository.existsById(id_consulta);
    }

    public void delete(Long id_consulta) {
        consultaRespository.deleteById(id_consulta);
    }


}

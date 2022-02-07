package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.entity.Consulta;
import com.sirere.sistema_registro_renal.entity.Paciente;
import com.sirere.sistema_registro_renal.entity.Personal;
import com.sirere.sistema_registro_renal.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//@Service
public class testConsulta implements CommandLineRunner {

    @Autowired
    private ConsultaService consultaService;


    @Override
    public void run(String... args) throws Exception {
        List<Consulta> lista = consultaService.myConsultas(3l);
        for(Consulta consulta : lista){
            System.out.println(consulta.toString());
        }
    }
}

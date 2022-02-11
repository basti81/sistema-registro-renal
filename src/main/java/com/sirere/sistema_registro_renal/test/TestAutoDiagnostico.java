package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.entity.AutoDiagnostico;
import com.sirere.sistema_registro_renal.services.AutoDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class TestAutoDiagnostico implements CommandLineRunner {

    @Autowired
    private AutoDiagnosticoService autoDiagnosticoService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("ENTRE A AUTODIAGNOSTICO");
        List<AutoDiagnostico> list = autoDiagnosticoService.list();
        for(AutoDiagnostico autoDiagnostic : list ){
            System.out.println(autoDiagnostic.getExamen().getFiliacion().getPaciente().getUsuario().toString());
        }

    }
}

package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.entity.AutoDiagnostico;
import com.sirere.sistema_registro_renal.services.AutoDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class TestAutoDiagnostico implements CommandLineRunner {

    @Autowired
    private AutoDiagnosticoService autoDiagnosticoService;

    @Override
    public void run(String... args) throws Exception {
        AutoDiagnostico autoDiagnostico = new AutoDiagnostico();

    }
}

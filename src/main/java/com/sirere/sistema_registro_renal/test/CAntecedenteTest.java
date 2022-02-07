package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.entity.Antecedente;
import com.sirere.sistema_registro_renal.enums.AntecendeteEnum;
import com.sirere.sistema_registro_renal.services.AntecendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


public class CAntecedenteTest implements CommandLineRunner {

    @Autowired
    private AntecendenteService antecendenteService;

    @Override
    public void run(String... args) throws Exception {
        Antecedente antecedente = new Antecedente();
        antecedente.setAntecendeteNombre(AntecendeteEnum.HIPERTENSION);
        antecendenteService.save(antecedente);
        antecedente.setAntecendeteNombre(AntecendeteEnum.DIABETES);
        antecendenteService.save(antecedente);
        antecedente.setAntecendeteNombre(AntecendeteEnum.ERC);
        antecendenteService.save(antecedente);


    }
}

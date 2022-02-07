package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

//@Service
public class TestRut implements CommandLineRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioService.existsByRut("20088634-8")){
            System.out.println("Entre a existByRut");
            System.out.println("El rut existe");
        }
    }
}

package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class testPersonal implements CommandLineRunner {
   @Autowired
   private UsuarioService usuarioService;

    @Override
    public void run(String... args) throws Exception {
        Long id_usuario = 7l;
        if(usuarioService.existsById(id_usuario)){
            System.out.println("Entre a exists by id");
            usuarioService.delete(id_usuario);
        }
    }
}

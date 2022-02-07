package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.security.service.UserDetailsServiceImpl;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

//@Service
public class test implements CommandLineRunner {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    public void run(String... args) throws Exception {
      UserDetails userDetails = userDetailsService.loadUserByUsername("20088634-8");
        System.out.println("Entre  test ");
        System.out.println(userDetails.getUsername().toString());



    }
}

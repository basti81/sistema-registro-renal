package com.sirere.sistema_registro_renal.test;

import com.sirere.sistema_registro_renal.security.service.UserDetailsServiceImpl;
import com.sirere.sistema_registro_renal.security.service.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class probarRoles implements CommandLineRunner {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    public void run(String... args) throws Exception {
        UserDetails userDetails =  userDetailsService.loadUserByUsername("doctor");
        System.out.println(userDetails.toString());
    }
}

package com.sirere.sistema_registro_renal.config;

import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.enums.RolNombre;
import com.sirere.sistema_registro_renal.services.RolService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CreateAdmin implements CommandLineRunner {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
//        Usuario usuario = new Usuario();
//        String passwordEncoded = passwordEncoder.encode("admin");
//        usuario.setUsername("admin");
//        usuario.setPassword(passwordEncoded);
//        usuario.setRut("20.088.634-8");
//        usuario.setNombre("Bastian");
//        usuario.setApellido("Apellido");
//        Rol rolAdmin = rolService.getByRolNombre(RolNombre.ADMINISTRADOR).get();
//        Rol rolUser = rolService.getByRolNombre(RolNombre.CLIENTE).get();
//        Set<Rol> roles = new HashSet<>();
//        roles.add(rolAdmin);
//        roles.add(rolUser);
//        usuario.setRoles(roles);
//        usuarioService.save(usuario);
    }
}

package com.sirere.sistema_registro_renal.config;

import com.sirere.sistema_registro_renal.entity.Especialidad;
import com.sirere.sistema_registro_renal.entity.Personal;
import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.enums.EspecilidadEnum;
import com.sirere.sistema_registro_renal.enums.RolEnum;
import com.sirere.sistema_registro_renal.services.EspecialidadService;
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

    @Autowired
    EspecialidadService especialidadService;
    @Override
    public void run(String... args) throws Exception {
//      insertarUsuariosPrueba();
    }

    private void insertarUsuariosPrueba() {
//        Especialidad especialidad = especialidadService.getByEspecialidadEnum(EspecilidadEnum.NINGUNA).get();
//        Set<Especialidad> esp = new HashSet<>();
//        Personal personal = new Personal();
//ADMINISTRADOR
        Usuario usuario = new Usuario();
        String pass = passwordEncoder.encode("admin");
        usuario.setPassword(pass);
        usuario.setRut("admin");
        usuario.setNombre("admin");
        usuario.setApellido("admin");
        Rol rolAdmin = rolService.getByRolEnum(RolEnum.ADMINISTRADOR).get();
        Set<Rol> rol = new HashSet<>();
        rol.add(rolAdmin);

        usuario.setRoles(rol);
        usuarioService.save(usuario);
//CLIENTE
        Usuario usuario1 = new Usuario();
        String pass1 = passwordEncoder.encode("paciente");
        usuario1.setPassword(pass1);
        usuario1.setRut("paciente");
        usuario1.setNombre("paciente");
        usuario1.setApellido("paciente");
        Rol rolcliente = rolService.getByRolEnum(RolEnum.CLIENTE).get();
        Set<Rol> rol1 = new HashSet<>();
        rol1.add(rolcliente);
        usuario1.setRoles(rol1);
        usuarioService.save(usuario1);
//DOCTOR
        Usuario usuario2 = new Usuario();
        String pass2 = passwordEncoder.encode("doctor");
        usuario2.setPassword(pass2);
        usuario2.setRut("prueba");
        usuario2.setNombre("doctor");
        usuario2.setApellido("doctor");
        Rol rolDoctor = rolService.getByRolEnum(RolEnum.DOCTOR).get();
        Set<Rol> rol2 = new HashSet<>();
        rol2.add(rolDoctor);
        usuario2.setRoles(rol2);
        usuarioService.save(usuario2);
//ENFERMERIA
        Usuario usuario3 = new Usuario();
        String pass3 = passwordEncoder.encode("enfermeria");
        usuario3.setPassword(pass3);
        usuario3.setRut("enfermeria");
        usuario3.setNombre("enfermeria");
        usuario3.setApellido("enfermeria");
        Rol rolEnfermeria = rolService.getByRolEnum(RolEnum.ENFERMERIA).get();
        Set<Rol> rol3 = new HashSet<>();
        rol3.add(rolEnfermeria);
        usuario3.setRoles(rol3);
        usuarioService.save(usuario3);
//GES
        Usuario usuario4 = new Usuario();
        String pass4 = passwordEncoder.encode("ges");
        usuario4.setPassword(pass4);
        usuario4.setRut("ges");
        usuario4.setNombre("ges");
        usuario4.setApellido("ges");
        Rol rolGes = rolService.getByRolEnum(RolEnum.GES).get();
        Set<Rol> rol4 = new HashSet<>();
        rol4.add(rolGes);
        usuario4.setRoles(rol4);
        usuarioService.save(usuario4);
//LABORATORISTA
        Usuario usuario5 = new Usuario();
        String pass5 = passwordEncoder.encode("laboratorista");
        usuario5.setPassword(pass5);
        usuario5.setRut("laboratorista");
        usuario5.setNombre("laboratorista");
        usuario5.setApellido("laboratorista");
        Rol rolLaboratorista = rolService.getByRolEnum(RolEnum.LABORATORISTA).get();
        Set<Rol> rol5 = new HashSet<>();
        rol5.add(rolLaboratorista);
        usuario5.setRoles(rol5);
        usuarioService.save(usuario5);
//ESTADISTICAS
        Usuario usuario6 = new Usuario();
        String pass6 = passwordEncoder.encode("estadistica");
        usuario6.setPassword(pass6);
        usuario6.setRut("estadistica");
        usuario6.setNombre("estadistica");
        usuario6.setApellido("estadistica");
        Rol rolEstadistica = rolService.getByRolEnum(RolEnum.ESTADISTICAS).get();
        Set<Rol> rol6 = new HashSet<>();
        rol6.add(rolEstadistica);
        usuario6.setRoles(rol6);
        usuarioService.save(usuario6);
//TENS
        Usuario usuario7 = new Usuario();
        String pass7 = passwordEncoder.encode("tens");
        usuario7.setPassword(pass6);
        usuario7.setRut("tens");
        usuario7.setNombre("tens");
        usuario7.setApellido("tens");
        Rol rolTens = rolService.getByRolEnum(RolEnum.TENS).get();
        Set<Rol> rol7 = new HashSet<>();
        rol7.add(rolTens);
        usuario7.setRoles(rol7);
        usuarioService.save(usuario7);
    }
}

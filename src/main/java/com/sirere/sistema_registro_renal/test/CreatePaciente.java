//package com.sirere.sistema_registro_renal.test;
//
//import com.sirere.sistema_registro_renal.biblioteca.Formato;
//import com.sirere.sistema_registro_renal.entity.Filiacion;
//import com.sirere.sistema_registro_renal.entity.Paciente;
//import com.sirere.sistema_registro_renal.entity.Usuario;
//import com.sirere.sistema_registro_renal.services.UsuarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.core.parameters.P;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CreatePaciente implements CommandLineRunner {
//
//    @Autowired
//    UsuarioService usuarioService;
//    private Formato frt = new Formato();
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("entre en createPaciente");
//        Usuario usuario = new Usuario();
//        Paciente paciente = new Paciente();
//        Filiacion filiacion = new Filiacion();
//        //USUARIO
//        usuario.setRut("20.088.634-8");
//        usuario.setNombre("Bastian");
//        usuario.setApellido("Astudillo");
//        usuario.setUsername("basti");
//        //PACIENTE
//        paciente.setComuna("San felipe");
//        paciente.setPrevision("I");
//        paciente.setRegion("Valparaiso");
//        paciente.setDireccion("21 mayo");
//        //FILIACION
//        filiacion.setRaza("ng");
//        filiacion.setSexo("M");
//        filiacion.setFecha_nac(frt.today());
//
//        paciente.setFiliacion(filiacion);
//        usuario.setPaciente(paciente);
//
//
//        usuarioService.save(usuario);
//
//    }
//}

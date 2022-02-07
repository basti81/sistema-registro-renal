package com.sirere.sistema_registro_renal.controllers;


import com.sirere.sistema_registro_renal.biblioteca.Util;
import com.sirere.sistema_registro_renal.entity.Examen;
import com.sirere.sistema_registro_renal.entity.Rol;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.enums.RolEnum;
import com.sirere.sistema_registro_renal.services.PacienteService;
import com.sirere.sistema_registro_renal.services.RolService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private  UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Util util = new Util();
    @GetMapping("/lista")
    public ModelAndView list() throws ParseException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/paciente/lista");
        List<Usuario> pacientes = pacienteService.list();
        mv.addObject("usuarios", pacientes);
        return mv;
    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
//    @GetMapping("/nuevo")
//    public ModelAndView nuevo(Paciente paciente) {
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("/paciente/nuevo");
//        mv.addObject("paciente", paciente);
//        return mv;
//    }
    @GetMapping("/nuevo")
    public ModelAndView nuevo(Usuario usuario) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/paciente/nuevo");
        mv.addObject("usuario", usuario);
        return mv;
    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/create")
    public ModelAndView crear(Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            System.out.println("Existieron errores");
            mv.setViewName("paciente/nuevo");
            mv.addObject("error", "Paciente no Registrado");
            return mv;
        }
        if(!usuarioService.existsByRut(usuario.getRut())){
            String clave = util.getRandomString();
            System.out.println("Clave Paciente = "+clave);
            usuario.setPassword(passwordEncoder.encode(clave));

//            System.out.println("Este Rut ya esta registrado");
//            mv.setViewName("paciente/nuevo");
//            attributes.addFlashAttribute("msg","Este Rut ya existe");
//            return mv;
        }
        //enviar email
//        Rol rolCliente = rolService.getByRolEnum(RolEnum.CLIENTE).get();
//        Set<Rol> rol = new HashSet<>();
//        rol.add(rolCliente);
//        usuario.setRoles(rol);
        usuarioService.save(usuario);
        mv.setViewName("redirect:/paciente/lista");
        return mv;
    }

    @GetMapping("/actualizar")
    public ModelAndView update(@RequestParam("id_usuario") long id_usuario) {
        ModelAndView mv = new ModelAndView();
        if (usuarioService.existsById(id_usuario)) {
            Optional<Usuario> optional = usuarioService.getOne(id_usuario);
            if (optional.isPresent()) {
                mv.setViewName("/paciente/nuevo");
                mv.addObject("usuario", optional.get());
                return mv;
            }
        }
        mv.setViewName("/paciente/lista");
        return mv;
    }


    @GetMapping("/detalle")
    public ModelAndView detalle(@RequestParam("id_usuario") long id_usuario) {
        ModelAndView mv = new ModelAndView();
        if(usuarioService.existsById(id_usuario)){
            Optional<Usuario> optional = usuarioService.getOne(id_usuario);
            if(optional != null){
                mv.setViewName("/filiacion/detalle");
                mv.addObject("usuario",optional.get());
                return mv;
            }
            mv.setViewName("redirect:/paciente/lista");
        }
        return mv;
    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/eliminar")
    public ModelAndView eliminar(@RequestParam("id_usuario") long id_usuario, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (usuarioService.existsById(id_usuario)) {
            System.out.println("ENTRE A ELIMINAR");
            usuarioService.delete(id_usuario);
            attributes.addFlashAttribute("msg","Paciente Eliminado");
        }
        mv.setViewName("redirect:/paciente/lista");
        return mv;
    }
}

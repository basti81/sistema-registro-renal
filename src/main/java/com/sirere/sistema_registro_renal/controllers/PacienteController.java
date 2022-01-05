package com.sirere.sistema_registro_renal.controllers;


import com.sirere.sistema_registro_renal.entity.Paciente;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.services.PacienteService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ModelAndView list() throws ParseException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/paciente/lista");
//        List<Paciente> pacientes = pacienteService.list();
        List<Usuario> usuarios = usuarioService.lista();
        mv.addObject("usuarios", usuarios);
        for (Usuario usuario : usuarios) {
            System.out.println("usuario = " + usuario);
        }
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
        usuarioService.save(usuario);
        mv.setViewName("redirect:/paciente/lista");
        return mv;
    }


    @GetMapping("/detalle/{id}")
    public ModelAndView detalle(@PathVariable("id") long id) {
//        if (!pacienteService.existsById(id))
//            return new ModelAndView("redirect:/producto/lista");
//        Paciente paciente = pacienteService.getOne(id).get();
        ModelAndView mv = new ModelAndView("/paciente/detalle");
        System.out.println("Id del paciente " + id);
        mv.addObject("id_paciente", id);
        return mv;
    }
//
//    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
//    @GetMapping("/editar/{id}")
//    public ModelAndView editar(@PathVariable("id") int id){
//        if(!pacienteService.existsById(id))
//            return new ModelAndView("redirect:/paciente/lista");
//        Paciente paciente = pacienteService.getOne(id).get();
//        ModelAndView mv = new ModelAndView("/paciente/editar");
//        mv.addObject("paciente", paciente);
//        return mv;
//    }

//    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
//    @PostMapping("/actualizar")
//    public ModelAndView actualizar(@RequestParam int id, @RequestParam String nombre, @RequestParam float precio){
//        if(!pacienteService.existsById(id))
//            return new ModelAndView("redirect:/paciente/lista");
//        ModelAndView mv = new ModelAndView();
//        Paciente paciente = pacienteService.getOne(id).get();
//        if(StringUtils.isBlank(nombre)){
//            mv.setViewName("paciente/editar");
//            mv.addObject("paciente", paciente);
//            mv.addObject("error", "el nombre no puede estar vacío");
//            return mv;
//        }
//        if(precio <1 ){
//            mv.setViewName("paciente/editar");
//            mv.addObject("error", "el precio debe ser mayor que cero");
//            mv.addObject("paciente", paciente);
//            return mv;
//        }
//        if(pacienteService.existsByNombre(nombre) && pacienteService.getByNombre(nombre).get().getId() != id){
//            mv.setViewName("paciente/editar");
//            mv.addObject("error", "ese nombre ya existe");
//            mv.addObject("paciente", paciente);
//            return mv;
//        }
//
//        paciente.setNombre(nombre);
//        paciente.setPrecio(precio);
//        pacienteService.save(paciente);
//        return new ModelAndView("redirect:/paciente/lista");
//    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/eliminar/{id}")
    public ModelAndView borrar(@PathVariable("id") long id/*, RedirectAttributes attributes*/) {
        if (pacienteService.existsById(id)) {
            pacienteService.delete(id);
//            return new ModelAndView("redirect:/paciente/lista");
            // attributes.addFlashAttribute("msg", "La categoría fue eliminada!.");
            System.out.println("Entre a eliminar");
            return new ModelAndView("redirect:/paciente/lista");
        }
        return null;
    }
}

package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.*;
import com.sirere.sistema_registro_renal.services.ConsultaService;
import com.sirere.sistema_registro_renal.services.PersonalService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PersonalService personalService;

    @Autowired
    private ConsultaService consultaService;


    @GetMapping("/detalle")
    public ModelAndView detalle(@RequestParam("id_consulta") long id_consulta,
                                @RequestParam("id_usuario") long id_usuario) {
        ModelAndView mv = new ModelAndView();
        System.out.println("ENTRE A DETALLE CONSULTA, ID USUARIO = " + id_usuario);
        mv.setViewName("prueba_3");
        return mv;
    }
//    @GetMapping("/lista")
//    public ModelAndView list(){
//        ModelAndView mv = new ModelAndView();
//        List<Consulta> consultas = consultaService.list();
//        mv.setViewName("/consulta/lista");
//        mv.addObject("consultas", consultas);
//        return mv;
//    }

    @GetMapping("/lista")
    public ModelAndView myConsultas(@RequestParam("id_usuario") long id_usuario) {
        ModelAndView mv = new ModelAndView();
        Optional<Usuario> optional = usuarioService.getOne(id_usuario);
        List<Consulta> consultas = consultaService.myConsultas(optional.get().getPaciente().getId_paciente());
        mv.setViewName("/consulta/lista");
        mv.addObject("usuario", optional.get());
        mv.addObject("consultas", consultas);
        return mv;
    }

    @GetMapping("/nuevo")
    public ModelAndView nuevo(@RequestParam("id_usuario") long id_usuario, Consulta consulta) {
        ModelAndView mv = new ModelAndView();
        Optional<Usuario> optional = usuarioService.getOne(id_usuario);
        List<Usuario> doctores = personalService.listDoctor();
        mv.setViewName("/consulta/nuevo");
        mv.addObject("usuario", optional.get());
        mv.addObject("consulta", consulta);
        mv.addObject("doctores", doctores);
        return mv;
    }

    @PostMapping("/create")
    public ModelAndView create(
            @RequestParam(value = "id_paciente", required = true) long id_paciente,
            @RequestParam(value = "id_usuario", required = true) long id_usuario,
            @RequestParam(value = "id_personal", required = true) long id_personal,
            Consulta consulta, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("consulta/nuevo");
            mv.addObject("error", "Consulta Medica No ingresada");
            return mv;
        }
//        Paciente paciente = new Paciente();
//        Personal personal = new Personal();
//        personal.setId_personal(id_personal);
//        paciente.setId_paciente(id_paciente);
//        consulta.setPersonal(personal);
//        consulta.setPaciente(paciente);
//        consultaService.save(consulta);
//        attributes.addFlashAttribute("msg", "Consulta Ingresada");
//        mv.setViewName("redirect:/consulta/lista?id_usuario=" + id_usuario);
        System.out.println("ENTRE A CREATE CONSULTA");
        System.out.println("ID USUARIO = "+id_usuario);
        System.out.println("ID PERSONAL = "+id_personal);
        System.out.println("ID PACIENTE = "+id_paciente);
        mv.setViewName("prueba_3");
        return mv;
    }

    @GetMapping("/eliminar")
    public ModelAndView delete(
            @RequestParam("id_consulta") long id_consulta,
            @RequestParam("id_usuario") long id_usuario,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/consulta/lista?id_usuario=" + id_usuario);
        if (consultaService.existsById(id_consulta)) {
            consultaService.delete(id_consulta);
            attributes.addFlashAttribute("msg", "Consulta Eliminada");
            return mv;
        }
        attributes.addFlashAttribute("msg", "Consulta No Encontrada");
        return mv;
    }
}

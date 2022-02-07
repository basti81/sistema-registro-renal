package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.biblioteca.Diagnosis;
import com.sirere.sistema_registro_renal.entity.AutoDiagnostico;
import com.sirere.sistema_registro_renal.entity.Examen;
import com.sirere.sistema_registro_renal.entity.Filiacion;
import com.sirere.sistema_registro_renal.entity.Usuario;
import com.sirere.sistema_registro_renal.services.ExamenService;
import com.sirere.sistema_registro_renal.services.FiliacionService;
import com.sirere.sistema_registro_renal.services.UsuarioService;
import org.apache.naming.EjbRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/examen")
public class ExamenController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ExamenService examenService;
    @Autowired
    private FiliacionService filiacionService;

    private Diagnosis diagnosis = new Diagnosis();

    @PostMapping("/save")
    public void save(Examen examen) {
        examenService.save(examen);
    }

    @GetMapping("/lista")
    public ModelAndView list(@RequestParam("id_filiacion") long id_filiacion) {
        ModelAndView mv = new ModelAndView();
        Optional<Usuario> optional = usuarioService.findUsuarioByFiliacion(id_filiacion);
        optional.get().getPaciente().getFiliacion().setExamenes(examenService.myExams(id_filiacion));
        mv.addObject("usuario", optional.get());
        mv.setViewName("/filiacion/examen/lista");
        return mv;
    }

//    @GetMapping("/lista")
//    public ModelAndView list() {
//        ModelAndView mv = new ModelAndView();
//        Filiacion filiacion = new Filiacion();
//        filiacion.setExamenes(examenService.list());
//        mv.setViewName("/filiacion/examen/lista");
//        mv.addObject("filiacion", filiacion);
//        return mv;
//    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/nuevo")
    public ModelAndView nuevo(Examen examen, @RequestParam("id_filiacion") long id_filiacion) {
        ModelAndView mv = new ModelAndView();
        Optional<Usuario> optional= usuarioService.findUsuarioByFiliacion(id_filiacion);
        mv.addObject("usuario",optional.get());
        examen.setFiliacion(optional.get().getPaciente().getFiliacion());
        mv.setViewName("/filiacion/examen/nuevo");
        mv.addObject("examen", examen);
        return mv;
    }

    @GetMapping("/prueba")
    public ModelAndView prueba(Examen examen){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/filiacion/examen/nuevo");
        mv.addObject("examen", examen);
        return mv;
    }
    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/create")
    public ModelAndView crear(Examen examen, @RequestParam("id_filiacion") long id_filiacion, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("filiacion/examen/nuevo");
            mv.addObject("error", "Examen no Registrado");
            return mv;
        }

        Optional<Filiacion> optional = filiacionService.getOne(id_filiacion);
        if (optional.isPresent()) {
            examen.setFecha_examen(LocalDateTime.now());
            AutoDiagnostico autoDiagnostico = diagnosis.sacaAutoDiagnosticoExamen(optional.get(), examen);
            examen.setAutoDiagnostico(autoDiagnostico);
            examen.setFiliacion(optional.get());
            examenService.save(examen);
            attributes.addFlashAttribute("msg", "Examen Ingresado");
        }
        mv.setViewName("redirect:/examen/lista?id_filiacion=" + id_filiacion);
        return mv;
    }

    @GetMapping("/actualizar")
    public ModelAndView update(@RequestParam("id_examen") long id_examen) {
        ModelAndView mv = new ModelAndView();
        if (examenService.existsById(id_examen)) {
            Optional<Examen> optional = examenService.getOne(id_examen);
            if (optional.isPresent()) {
                mv.setViewName("/filiacion/examen/nuevo");
                mv.addObject("examen", optional.get());
                return mv;
            }
        }
        mv.setViewName("/filiacion/examen/lista");
        return mv;
    }



    @GetMapping("/detalle")
    public ModelAndView detalle(@RequestParam("id_examen") long id_examen) {
        ModelAndView mv = new ModelAndView();
        if (examenService.existsById(id_examen)) {
            Optional<Examen> optional = examenService.getOne(id_examen);
            if (optional.isPresent()) {
                mv.setViewName("/filiacion/examen/detalle");
                mv.addObject("examen", optional.get());
                return mv;
            }
        }
        mv.setViewName("redirect:/examen/lista");
        return mv;
    }

    @GetMapping("/eliminar")
    public ModelAndView delete(@RequestParam("id_examen") long id_examen, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (examenService.existsById(id_examen)) {
            Optional<Examen> optional = examenService.getOne(id_examen);
            if (optional.isPresent()) {
                mv.setViewName("redirect:/examen/lista?id_filiacion=" + optional.get().getFiliacion().getId_filiacion());
                examenService.delete(id_examen);
                attributes.addFlashAttribute("msg", "Examen Eliminado");
                return mv;
            }
            attributes.addFlashAttribute("msg", "Falla al eliminar");
        }
        return mv;
    }

}

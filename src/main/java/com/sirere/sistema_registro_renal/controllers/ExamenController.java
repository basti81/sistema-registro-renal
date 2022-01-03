package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.Examen;
import com.sirere.sistema_registro_renal.entity.Filiacion;
import com.sirere.sistema_registro_renal.services.ExamenService;
import org.apache.naming.EjbRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/examen")
public class ExamenController {

    @Autowired
    private ExamenService examenService;


    @PostMapping("/save")
    public void save(Examen examen) {
        examenService.save(examen);
    }

    //    @GetMapping("/lista/{id_filiacion}")
    @GetMapping("/lista")
//    public ModelAndView list(Filiacion filiacion, @PathVariable("id_filiacion") long id_filiacion) {
    public ModelAndView list(Filiacion filiacion, @RequestParam("id_filiacion") long id_filiacion) {
        ModelAndView mv = new ModelAndView();
        System.out.println("entre a lista examenes por filiacion");
        filiacion.setExamenes(examenService.myExams(id_filiacion));
        mv.addObject("filiacion", filiacion);
        mv.setViewName("/filiacion/examen/lista");
//        for(Examen examen : filiacion.getExamenes()){
//            System.out.println("Examen = " + examen.toString());
//        }
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

        Filiacion filiacion = new Filiacion();
        filiacion.setId_filiacion(id_filiacion);
        examen.setFiliacion(filiacion);
        mv.setViewName("/filiacion/examen/nuevo");
        mv.addObject("examen", examen);
        return mv;
    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/create")
    public ModelAndView crear(Examen examen, @RequestParam("id_filiacion") long id_filiacion, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("Ocurrio un error" + error.getDefaultMessage());
            }
            mv.setViewName("filiacion/examen/nuevo");
            mv.addObject("error", "");
            return mv;
        }

        Filiacion filiacion = new Filiacion();
        filiacion.setId_filiacion(id_filiacion);
        examen.setFiliacion(filiacion);
        examenService.save(examen);
        attributes.addFlashAttribute("msg", "Examen Ingresado");
        mv.setViewName("redirect:/examen/lista?id_filiacion=" + id_filiacion);

        return mv;
    }

    @GetMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam("id_examen") long id_examen) {
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


    @GetMapping("/prueba")
    public ModelAndView prueba() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/prueba_3");
        //mv.addObject("id",getFiliacion().getId_filiacion());
        return mv;
    }

    @GetMapping("/detalle")
    public ModelAndView myData(Examen examen, @RequestParam("id_examen") long id_examen) {
        ModelAndView mv = new ModelAndView();
        if (examenService.existsById(id_examen)) {
            Optional<Examen> optional = examenService.getOne(id_examen);
            if (optional.isPresent()) {
                examen = optional.get();
                mv.setViewName("/filiacion/examen/detalle");
                mv.addObject("examen", examen);
                return mv;
            }
            System.out.println("Examen encontrada");
        } else {
            System.out.println("Examen no encontrada");
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
                System.out.println("ID filiacion " + optional.get().getFiliacion().getId_filiacion());
                mv.setViewName("redirect:/examen/lista?id_filiacion=" + optional.get().getFiliacion().getId_filiacion());
                examenService.delete(id_examen);
                attributes.addFlashAttribute("msg", "Examen Eliminado");
            } else {
                attributes.addFlashAttribute("msg", "Eliminacion Fallida");
            }
            return mv;
        }

        mv.setViewName("/filiacion/examen/nuevo");
        return mv;
    }

}

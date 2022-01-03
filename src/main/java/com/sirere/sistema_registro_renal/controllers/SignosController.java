package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.Examen;
import com.sirere.sistema_registro_renal.entity.Filiacion;
import com.sirere.sistema_registro_renal.entity.SignoVital;
import com.sirere.sistema_registro_renal.services.ExamenService;
import com.sirere.sistema_registro_renal.services.SignosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/signo")
public class SignosController {

    @Autowired
    private SignosService signosService;


    @PostMapping("/save")
    public void save(SignoVital signoVital) {
        signosService.save(signoVital);
    }

    //    @GetMapping("/lista/{id_filiacion}")
    @GetMapping("/lista")
//    public ModelAndView list(Filiacion filiacion, @PathVariable("id_filiacion") long id_filiacion) {
    public ModelAndView list(Filiacion filiacion, @RequestParam("id_filiacion") long id_filiacion) {
        ModelAndView mv = new ModelAndView();
        filiacion.setSignos(signosService.mySignos(id_filiacion));
        mv.addObject("filiacion", filiacion);
        mv.setViewName("/filiacion/signos/lista");
//        for(Examen examen : filiacion.getExamenes()){
//            System.out.println("Examen = " + examen.toString());
//        }
        return mv;
    }

//    @GetMapping("/lista")
//    public ModelAndView list() {
//        ModelAndView mv = new ModelAndView();
//        Filiacion filiacion = new Filiacion();
//        filiacion.setExamenes(signosService.list());
//        mv.setViewName("/filiacion/examen/lista");
//        mv.addObject("filiacion", filiacion);
//        return mv;
//    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/nuevo")
    public ModelAndView nuevo(SignoVital signoVital, @RequestParam("id_filiacion") long id_filiacion) {
        ModelAndView mv = new ModelAndView();
        Filiacion filiacion = new Filiacion();
        filiacion.setId_filiacion(id_filiacion);
        signoVital.setFiliacion(filiacion);
        mv.setViewName("/filiacion/signos/nuevo");
        mv.addObject("signo", signoVital);
        return mv;
    }

    //    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/create")
    public ModelAndView crear(SignoVital signoVital, @RequestParam("id_filiacion") long id_filiacion, BindingResult result, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            for(ObjectError error : result.getAllErrors()){
                System.out.println("Ocurrio un error" + error.getDefaultMessage());
            }
            mv.setViewName("filiacion/signos/nuevo");
            mv.addObject("error", "");
            return mv;
        }

        Filiacion filiacion = new Filiacion();
        filiacion.setId_filiacion(id_filiacion);
        signoVital.setFiliacion(filiacion);
        signosService.save(signoVital);
        attributes.addFlashAttribute("msg","Signo Vital Ingresado");
        mv.setViewName("redirect:/signo/lista?id_filiacion="+id_filiacion);

        return mv;
    }

    @GetMapping("/actualizar")
    public ModelAndView actualizar(@RequestParam("id_signo") long id_signo){
        ModelAndView mv = new ModelAndView();
        if(signosService.existsById(id_signo)){
            Optional<SignoVital> optional = signosService.getOne(id_signo);
            if(optional.isPresent()){
                mv.setViewName("/filiacion/signos/nuevo");
                mv.addObject("signo",optional.get());
                return mv;
            }
        }
        mv.setViewName("/filiacion/signos/lista");
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
    public ModelAndView myData( @RequestParam("id_signo") long id_sinos) {
        ModelAndView mv = new ModelAndView();
        if (signosService.existsById(id_sinos)) {
            Optional<SignoVital> optional = signosService.getOne(id_sinos);
            if (optional.isPresent()) {
                mv.setViewName("/filiacion/signos/detalle");
                mv.addObject("signo", optional.get());
                return mv;
            }
            System.out.println("Signos encontrado");
        } else {
            System.out.println("Signos no encontrada");
        }
        mv.setViewName("redirect:signo/lista");
        return mv;
    }

    @GetMapping("/eliminar")
//    public ModelAndView delete(@RequestParam("id_filiacion") long id_filiacion,@RequestParam("id_examen") long id_examen, RedirectAttributes attributes) {
    public ModelAndView delete(@RequestParam("id_signo") long id_signo, RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView();
        if (signosService.existsById(id_signo)) {
            Optional<SignoVital> optional = signosService.getOne(id_signo);
            if(optional.isPresent()){
                signosService.delete(id_signo);
                mv.setViewName("redirect:/signo/lista?id_filiacion="+optional.get().getFiliacion().getId_filiacion());
                attributes.addFlashAttribute("msg", "Examen Eliminado");
            }
            return mv;
        }

        mv.setViewName("/filiacion/signos/nuevo");
        return mv;
    }
}

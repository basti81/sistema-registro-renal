package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.AutoDiagnostico;
import com.sirere.sistema_registro_renal.services.AutoDiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/autoDiagnostico")
public class AutoDiagnosticoController {

    @Autowired
    private AutoDiagnosticoService autoDiagnosticoService;

    @GetMapping("/lista")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        List<AutoDiagnostico> autoDiagnosticos = autoDiagnosticoService.list();
        mv.addObject("autoDiagnosticos", autoDiagnosticos);
        mv.setViewName("/autoDiagnostico/lista");
        return mv;
    }


}

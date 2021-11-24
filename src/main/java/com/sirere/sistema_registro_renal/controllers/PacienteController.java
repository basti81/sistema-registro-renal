package com.sirere.sistema_registro_renal.controllers;

import com.sirere.sistema_registro_renal.entity.Paciente;
import com.sirere.sistema_registro_renal.services.PacienteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

//    @PostMapping("/addPaciente")
//    public ModelAndView addProduct(@RequestBody Paciente paciente) {
//        ModelAndView mv = new ModelAndView();
//        pacienteService.save(paciente);
//        return mv;
//    }

    @PostMapping("/testPaciente")
    public Paciente muestraPaciente(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }
//    @PostMapping("/addProducts")
//    public List<Paciente> addProducts(@RequestBody List<Paciente> pacientes) {
//        return pacienteService.save(pacientes);
//    }

//    @GetMapping("/products")
//    public List<Paciente> findAllProducts() {
//        return pacienteService.ge();
//    }

//    @GetMapping("/productById/{id}")
//    public Paciente findProductById(@PathVariable int id) {
//        return pacienteService.getProductById(id);
//    }
//
//    @GetMapping("/product/{name}")
//    public Paciente findProductByName(@PathVariable String name) {
//        return pacienteService.getProductByName(name);
//    }
//
//    @PutMapping("/update")
//    public Paciente updateProduct(@RequestBody Paciente paciente) {
//        return pacienteService.updateProduct(paciente);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable int id) {
//        return pacienteService.deleteProduct(id);
//    }
}

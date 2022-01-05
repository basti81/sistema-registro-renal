package com.sirere.sistema_registro_renal.services;

import com.sirere.sistema_registro_renal.biblioteca.Formato;
import com.sirere.sistema_registro_renal.entity.Filiacion;
import com.sirere.sistema_registro_renal.entity.Paciente;
import com.sirere.sistema_registro_renal.repository.PacienteRepository;
import com.sirere.sistema_registro_renal.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
@Transactional
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    private List<Paciente> list = null;
    private  Formato frt = new Formato();

    public PacienteService() {
        list = new LinkedList<>();
        Paciente paciente = new Paciente();
        paciente.setRegion("prueba1");
        paciente.setComuna("comuna");
        paciente.setDireccion("prueba1");
        paciente.setPrevision("prueba1");

        Paciente paciente1 = new Paciente();
        paciente1.setRegion("prueba1");
        paciente1.setComuna("comuna");
        paciente1.setDireccion("prueba1");
        paciente1.setPrevision("prueba1");

        list.add(paciente);
        list.add(paciente1);
    }

    public List<Paciente> list() throws ParseException {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getOne(long id) {
        return pacienteRepository.findById(id);
    }

//    public Optional<Paciente> getByNombre(String nombre){
//        return pacienteRepository.findByNombre(nombre);
//    }

    public void save(Paciente paciente) {
//        paciente.getUsuario().setFecha_ingreso(frt.today());
        pacienteRepository.save(paciente);
    }

    public void delete(long id) {
        pacienteRepository.deleteById(id);
    }

    public boolean existsById(long id) {
        return pacienteRepository.existsById(id);
    }

//    public boolean existsByNombre(String nombre){
//        return pacienteRepository.existsByNombre(nombre);
//    }


}

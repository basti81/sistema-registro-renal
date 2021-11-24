package com.sirere.sistema_registro_renal.services;

import com.sirere.sistema_registro_renal.entity.Paciente;
import com.sirere.sistema_registro_renal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> list(){
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> getOne(Long id){
        return pacienteRepository.findById(id);
    }

//    public Optional<Paciente> getByNombre(String nombre){
//        return pacienteRepository.findByNombre(nombre);
//    }

    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return pacienteRepository.existsById(id);
    }

//    public boolean existsByNombre(String nombre){
//        return pacienteRepository.existsByNombre(nombre);
//    }

}

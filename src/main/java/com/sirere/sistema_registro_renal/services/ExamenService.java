package com.sirere.sistema_registro_renal.services;

import com.sirere.sistema_registro_renal.biblioteca.Formato;
import com.sirere.sistema_registro_renal.entity.Examen;
import com.sirere.sistema_registro_renal.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamenService {

    @Autowired
    private ExamenRepository examenRepository;
    private Formato frt = new Formato();

    public List<Examen> list() {
        return examenRepository.findAll();
    }

    public List<Examen> myExams(Long id_filiacion) {
        return examenRepository.findExamnByFiliacion(id_filiacion);
    }

    public Optional<Examen> getOne(Long id) {
        return examenRepository.findById(id);
    }

    public void save(Examen examen) {
        examenRepository.save(examen);
    }

    public void delete(Long id) {
        examenRepository.deleteById(id);
    }
    public boolean existsById(Long id) {
        return examenRepository.existsById(id);
    }

}

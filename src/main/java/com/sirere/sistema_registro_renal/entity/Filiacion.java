package com.sirere.sistema_registro_renal.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Filiacion {
    private Long id_filicacion;
    private Long id_paciente;
    private String sexo;
    private String raza;
    private List<Antrometria> listAntrometria;
    private List<Examen> listExamen;
    private List<SignoVital> listSigno;
    private List<Diagnostico> listDiagnostico;
    private List<Antecedente> listAntecendete;
    private Date fecha_filiacion;


}

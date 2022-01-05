package com.sirere.sistema_registro_renal.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "filiacion")
public class Filiacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_filiacion;
    @Column(name = "sexo", columnDefinition = "varchar(2)")
    private String sexo;
    @Column(name = "raza", columnDefinition = "varchar(10)")
    private String raza;

    @Transient
    private Integer edad;
    @Column(name = "fecha_nac")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nac;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;


    @OneToMany(mappedBy = "filiacion",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Antropometria> antropometrias;
//
    @OneToMany(mappedBy = "filiacion",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Examen> examenes;
//
    @OneToMany(mappedBy = "filiacion",cascade = CascadeType.ALL)
    private List<SignoVital> signos;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="id_filiacion" ,referencedColumnName = "id_filiacion")
//    private List<Diagnostico> diagnosticos;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name= "id_filiacion" , referencedColumnName = "id_filiacion")
//    private List<Antecedente> antecedentes;

    private LocalDate fecha_filiacion;


    public Filiacion() {
    }

    public Filiacion(String sexo, String raza) {
        this.sexo = sexo;
        this.raza = raza;
    }

    public Long getId_filiacion() {
        return id_filiacion;
    }

    public void setId_filiacion(Long id_filiacion) {
        this.id_filiacion = id_filiacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    //ANTROPOMETRIA
    public List<Antropometria> getAntropometrias() {return antropometrias;}
    public void setAntropometrias(List<Antropometria> antropometrias) {this.antropometrias = antropometrias; }

     //SIGNOS VITALES
    public List<SignoVital> getSignos() {
        return signos;
    }
    public void setSignos(List<SignoVital> signos) {
        this.signos = signos;
    }

    //EXAMENES
    public List<Examen> getExamenes() {
        return examenes;
    }
    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }


    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFecha_filiacion() {
        return fecha_filiacion;
    }

    public void setFecha_filiacion(LocalDate fecha_filiacion) {
        this.fecha_filiacion = fecha_filiacion;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Filiacion{" +
                "id_filiacion=" + id_filiacion +
                ", sexo='" + sexo + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", fecha_nac=" + fecha_nac +
                ", antropometrias=" + antropometrias +
                ", examenes=" + examenes +
                ", signos=" + signos +
                ", fecha_filiacion=" + fecha_filiacion +
                '}';
    }
}

package com.sirere.sistema_registro_renal.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "examen")
public class Examen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_examen;
    private Double creatinina;
    private Double cloro;
    private Double albuminia;
    private Double potasio;
    private Double sodio;
    private LocalDate fecha_examen;
    private Boolean visto;
    @ManyToOne
    @JoinColumn(name = "id_filiacion",  nullable = false)
    private Filiacion filiacion;

    public Examen() {
    }

    public Long getId_examen() {
        return id_examen;
    }

    public void setId_examen(Long id_examen) {
        this.id_examen = id_examen;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public Filiacion getFiliacion() {
        return filiacion;
    }

    public void setFiliacion(Filiacion filiacion) {
        this.filiacion = filiacion;
    }

    public Double getCreatinina() {
        return creatinina;
    }

    public void setCreatinina(Double creatinina) {
        this.creatinina = creatinina;
    }

    public Double getCloro() {
        return cloro;
    }

    public void setCloro(Double cloro) {
        this.cloro = cloro;
    }

    public Double getAlbuminia() {
        return albuminia;
    }

    public void setAlbuminia(Double albuminia) {
        this.albuminia = albuminia;
    }

    public Double getPotasio() {
        return potasio;
    }

    public void setPotasio(Double potasio) {
        this.potasio = potasio;
    }

    public Double getSodio() {
        return sodio;
    }

    public void setSodio(Double sodio) {
        this.sodio = sodio;
    }

    public LocalDate getFecha_examen() {
        return fecha_examen;
    }

    public void setFecha_examen(LocalDate fecha_examen) {
        this.fecha_examen = fecha_examen;
    }

    public Boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    @Override
    public String toString() {
        return "Examen{" +
                "id_examen=" + id_examen +
                ", creatinina=" + creatinina +
                ", cloro=" + cloro +
                ", albuminia=" + albuminia +
                ", potasio=" + potasio +
                ", sodio=" + sodio +
                ", fecha_examen=" + fecha_examen +
                ", visto=" + visto +
                ", filiacion=" + filiacion +
                '}';
    }
}

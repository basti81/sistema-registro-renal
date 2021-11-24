package com.sirere.sistema_registro_renal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_examen;
    private Integer id_filicacion;
    private double creatinina;
    private double cloro;
    private double albuminia;
    private double potasio;
    private double sodio;
    private Date fecha_examen;
    private boolean visto;

    public Examen() {
    }

    public Long getId_examen() {
        return id_examen;
    }

    public void setId_examen(Long id_examen) {
        this.id_examen = id_examen;
    }

    public Integer getId_filicacion() {
        return id_filicacion;
    }

    public void setId_filicacion(Integer id_filicacion) {
        this.id_filicacion = id_filicacion;
    }

    public double getCreatinina() {
        return creatinina;
    }

    public void setCreatinina(double creatinina) {
        this.creatinina = creatinina;
    }

    public double getCloro() {
        return cloro;
    }

    public void setCloro(double cloro) {
        this.cloro = cloro;
    }

    public double getAlbuminia() {
        return albuminia;
    }

    public void setAlbuminia(double albuminia) {
        this.albuminia = albuminia;
    }

    public double getPotasio() {
        return potasio;
    }

    public void setPotasio(double potasio) {
        this.potasio = potasio;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public Date getFecha_examen() {
        return fecha_examen;
    }

    public void setFecha_examen(Date fecha_examen) {
        this.fecha_examen = fecha_examen;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}

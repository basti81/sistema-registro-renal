package com.sirere.sistema_registro_renal.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table (name = "paciente")
public class Paciente{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;

    @Column(name = "region", columnDefinition = "varchar(100)")
    private String region;

    @Column(name = "comuna", columnDefinition = "varchar(100)")
    private String comuna;

    @Column(name = "direccion", columnDefinition = "varchar(100)")
    private String direccion;

    @Column(name = "prevision", columnDefinition = "varchar(50)")
    private String prevision;

//    @OneToOne(mappedBy = "paciente",cascade = CascadeType.ALL,orphanRemoval = true)
//    private Filiacion filiacion;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;



    public Paciente() {
    }

    public Paciente(String region, String comuna, String direccion, String prevision) {
        this.region = region;
        this.comuna = comuna;
        this.direccion = direccion;
        this.prevision = prevision;
    }


//    public Filiacion getFiliacion() {
//        return filiacion;
//    }
//
//    public void setFiliacion(Filiacion filiacion) {
//        this.filiacion = filiacion;
//    }

    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "region='" + region + '\'' +
                ", comuna='" + comuna + '\'' +
                ", direccion='" + direccion + '\'' +
                ", prevision='" + prevision + '\'' +
                '}';
    }
}

package com.sirere.sistema_registro_renal.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table (name = "paciente")
public class Paciente {
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

//    private Filiacion filiacion;

    @Column(name = "fecha_nac")
    private Date fecha_nac;


    public Paciente() {
    }

    public Paciente(String region, String comuna, String direccion, String prevision, Date fecha_nac) {
        this.region = region;
        this.comuna = comuna;
        this.direccion = direccion;
        this.prevision = prevision;
        this.fecha_nac = fecha_nac;
    }
//    public Paciente(String rut, String nombre, String apellido, String username, String password, Set<Rol> roles, Date fecha_ingreso, String region, String comuna, String direccion, String prevision) {
//      super(rut, nombre, apellido, username, password, roles, fecha_ingreso);
//        this.region = region;
//        this.comuna = comuna;
//        this.direccion = direccion;
//        this.prevision = prevision;
//    }


    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
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

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
}

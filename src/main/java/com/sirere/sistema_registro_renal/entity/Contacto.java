package com.sirere.sistema_registro_renal.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Contacto {
    private Integer id_contacto;
    private String telefono;
    private String telefono_aux;
    private String correo;


    private Usuario usuario;

    public Contacto() {
    }


    public Integer getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_aux() {
        return telefono_aux;
    }

    public void setTelefono_aux(String telefono_aux) {
        this.telefono_aux = telefono_aux;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

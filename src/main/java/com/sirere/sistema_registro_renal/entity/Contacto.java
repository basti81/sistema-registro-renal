package com.sirere.sistema_registro_renal.entity;

public class Contacto {
    private Integer id_contacto;
    private Integer id_usuario;
    private String telefono;
    private String telefono_aux;
    private String correo;

    public Contacto() {
    }

    public Contacto(Integer id_contacto, Integer id_usuario, String telefono, String telefono_aux, String correo) {
        this.id_contacto = id_contacto;
        this.id_usuario = id_usuario;
        this.telefono = telefono;
        this.telefono_aux = telefono_aux;
        this.correo = correo;
    }

    public Integer getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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

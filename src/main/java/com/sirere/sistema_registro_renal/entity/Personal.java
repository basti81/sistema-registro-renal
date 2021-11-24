package com.sirere.sistema_registro_renal.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name ="personal")
public class Personal{

    private boolean habilitado;

    public Personal() {
    }

    public Personal(String rut, String nombre, String apellido, String username, String password, Set<Rol> roles, Date fecha_ingreso, boolean habilitado) {
//        super(rut, nombre, apellido, username, password, roles, fecha_ingreso);;
        this.habilitado = habilitado;
    }


    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
}

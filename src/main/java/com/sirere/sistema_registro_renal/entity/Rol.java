package com.sirere.sistema_registro_renal.entity;

import com.sirere.sistema_registro_renal.enums.RolNombre;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


}

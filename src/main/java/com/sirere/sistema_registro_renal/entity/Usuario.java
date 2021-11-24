package com.sirere.sistema_registro_renal.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name ="usuario")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @NotNull
    @Column(unique = true)
    private String rut;
    private String nombre;
    private String apellido;
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="usuario_rol",joinColumns = @JoinColumn (name = "id_usuario"),inverseJoinColumns =  @JoinColumn(name="id_rol"))
    private Set<Rol> roles = new HashSet<>();
//    private List<Consulta> consultas;
    private Date fecha_ingreso;


    public Usuario() {
    }

    public Usuario(String rut, String nombre, String apellido, String username, String password, Set<Rol> roles, Date fecha_ingreso) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.fecha_ingreso = fecha_ingreso;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }
}
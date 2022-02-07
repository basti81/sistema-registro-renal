package com.sirere.sistema_registro_renal.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name ="personal")
public class Personal{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_personal;
    private boolean habilitado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="per_especialidad",joinColumns = @JoinColumn (name = "id_personal"),inverseJoinColumns =  @JoinColumn(name="id_especialidad"))
    private Set<Especialidad> especialidad = new HashSet<>();

    @OneToMany(mappedBy = "personal",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Consulta> consultas;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public Personal() {
    }

    public Long getId_personal() {
        return id_personal;
    }

    public void setId_personal(Long id_personal) {
        this.id_personal = id_personal;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public Set<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Set<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id_personal=" + id_personal +
                ", habilitado=" + habilitado +
                ", especilidad=" + especialidad +
                ", consultas=" + consultas +
                ", usuario=" + usuario +
                '}';
    }
}

package com.sirere.sistema_registro_renal.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consulta;

    @DateTimeFormat(pattern="yyyy-MM-dd' T 'HH:mm")
    private LocalDateTime fecha_atencion;
    private LocalDate fecha_consulta;

    @ManyToOne
    @JoinColumn(name = "id_paciente",  nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_personal",  nullable = false)
    private Personal personal;

    private boolean visto;

    public Consulta() {
    }

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }

    public LocalDateTime getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(LocalDateTime fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public LocalDate getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(LocalDate fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id_consulta=" + id_consulta +
                ", fecha_atencion=" + fecha_atencion +
                ", fecha_consulta=" + fecha_consulta +
                ", visto=" + visto +
                '}';
    }
}

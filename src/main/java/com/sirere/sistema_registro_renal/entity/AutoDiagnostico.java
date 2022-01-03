package com.sirere.sistema_registro_renal.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

//@Entity
//@Table(name = "autoDiagnostico")
public class AutoDiagnostico {
    private Long id_autoDiagnostico;
    private String estado;
    private String descripcion;
    private LocalDate fecha;
    private Boolean visto;
//  @ManyToOne
    private Examen examen;
}

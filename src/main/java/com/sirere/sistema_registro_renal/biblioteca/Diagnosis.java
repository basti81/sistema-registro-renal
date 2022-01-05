//package com.sirere.sistema_registro_renal.biblioteca;
//
//import com.sirere.sistema_registro_renal.entity.Examen;
//import com.sirere.sistema_registro_renal.entity.Filiacion;
//import com.sirere.sistema_registro_renal.entity.aDiagnosticoExamen;
//
//public class Diagnosis {
//
//    private Calculate calculate = new Calculate();
//
//    public aDiagnosticoExamen getADiagnosticoExamen(Filiacion filiacion, Examen examen){
//        aDiagnosticoExamen diagnostico = new aDiagnosticoExamen();
//        int edad = calculate.sacaEdad(filiacion.getFecha_nac());
//        double mdrd4 = calculate.sacaMrdr4(edad,examen.getCreatinina(),filiacion.getSexo(), filiacion.getRaza());
//        int estadio = calculate.sacaEstadio(mdrd4);
//        String tipoEstadio = calculate.sacaTipoEstadio(estadio);
//        String text = "Paciente con fg("+mdrd4+")";
//        return diagnostico;
//    }
//}

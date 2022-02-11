package com.sirere.sistema_registro_renal.biblioteca;

import com.sirere.sistema_registro_renal.entity.*;
import com.sirere.sistema_registro_renal.enums.Enfermedad.EnfermedadEnum;

public class Diagnosis {

    private Calculate calculate = new Calculate();
    private Formato frt = new Formato();
    private int estado = 0;



    public AutoDiagnostico sacaAutoDiagnosticoExamen(Filiacion filiacion, Examen examen) {
        AutoDiagnostico diagnostico = new AutoDiagnostico();
        diagnostico.setDescripcion(sacaDescripcion(filiacion, examen));
        diagnostico.setEstado(estado);
        diagnostico.setFecha(examen.getFecha_examen().toLocalDate());
        diagnostico.setVisto(false);
        return diagnostico;
    }

    //----- SACA DESCRIPCION---------
    private String sacaDescripcion(Filiacion filiacion, Examen examen){
        EnfermedadEnum potasio = calculate.evaluatePotasio(examen.getPotasio());
        EnfermedadEnum albumina = calculate.evaluateAlbumina(examen.getAlbumina());
        EnfermedadEnum cloro = calculate.evaluateCloro(examen.getCloro());
        EnfermedadEnum sodio = calculate.evaluateSodio(examen.getSodio());
        EnfermedadEnum creatinina = calculate.evaluateCreatinina(filiacion.getEdad(),examen.getCreatinina(), filiacion.getSexo(), filiacion.getRaza());
        String str = "Fecha Examen: "+examen.getFecha_examen().toLocalDate()+"\n";

        if(creatinina.equals(EnfermedadEnum.NORMAL)){
            str = str +"Creatinina: "+creatinina.toString()+"\n";
        }else if(creatinina.equals(EnfermedadEnum.G3b_MODERADA_A_GRAVEMENTE_DISMINUIDO)){
            str= str + ("Creatinina: "+creatinina.toString()+", resultado alterado\n");
            estado = 3;
        }else if(creatinina.equals(EnfermedadEnum.G4_GRAVEMENTE_DISMINUIDO)){
            str= str + ("Creatinina: "+creatinina.toString()+", resultado alterado\n");
            estado = 4;
        }else if(creatinina.equals(EnfermedadEnum.G5_FALLO_RENAL)){
            str= str + ("Creatinina: "+creatinina.toString()+", resultado alterado\n");
            estado = 5;
        }else{
            str= str + ("Creatinina: "+creatinina.toString()+", resultado alterado\n");
            estado++;
        }

        if(potasio.equals(EnfermedadEnum.NORMAL)){
            str= str + ("Potasio: "+potasio.toString()+"\n");
        }else{
            str= str + ("Potasio: "+potasio.toString()+", resultado alterado\n");
            estado++;
        }

        if(albumina.equals(EnfermedadEnum.NORMAL)){
            str= str + ("Albumina: "+albumina.toString()+"\n");
        }else{
            str= str + ("Albumina: "+albumina.toString()+", resultado alterado\n");
            estado++;
        }

        if(cloro.equals(EnfermedadEnum.NORMAL)){
            str= str + ("Cloro: "+cloro.toString()+"\n");
        }else{
            str= str + ("Cloro: "+cloro.toString()+", resultado alterado\n");
            estado++;
        }

        if(sodio.equals(EnfermedadEnum.NORMAL)){
            str= str + ("Sodio: "+sodio.toString()+"\n");
        }else{
            str= str + ("Sodio: "+sodio.toString()+", resultado alterado\n");
            estado++;
        }


        System.out.println("ENTRE A AUTODIAGNOSTICO = "+str);
        return str;
    }
    //-------------------------------


    private Integer sacaEstado(){

        return 1;
    }



}

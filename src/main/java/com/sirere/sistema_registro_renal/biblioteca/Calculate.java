package com.sirere.sistema_registro_renal.biblioteca;

import java.time.LocalDate;

public class Calculate {

    private Formato formato = new Formato();

    //COCKCROFT-GAULT
    public double sacaCockGault(int edad, double peso, double creatinina, String sexo) {
        double num = 1;
        if (sexo.equals("F")) {
            num = 0.85;
        }
        return ((140 - edad) * peso / 72 * creatinina) * num;
    }

    //MRDR4
    public double sacaMrdr4(int edad, double creatinina, String sexo, String raza) {
        double res = 0;
        res = (186 * Math.pow(creatinina, (-1.154)) * Math.pow(edad, (-0.203)));
        if (sexo.equals("F")) {  // SI ES MUJER
            res = res * (0.742);
        }
        if (raza.equals("ng")) { // SI ES AFROAMERICANA
            res = res * (1.21);
        }
        return res;
    }

    //ESTADIO SEGUN DANO RENAL
    public int sacaEstadio(double fg) {
        int tipoEstadio = 0;
        if (fg >= 90) {
            tipoEstadio = 1;
        } else if (fg > 60 && fg < 89) {
            tipoEstadio = 2;
        } else if (fg > 30 && fg < 59) {
            tipoEstadio = 3;
        } else if (fg > 15 && fg < 29) {
            tipoEstadio = 4;
        } else if (fg <= 15) {
            tipoEstadio = 5;
        }
        return tipoEstadio;
    }

    // SACA TIPO DE ESTADIO SEGUN EL INT
    public String sacaTipoEstadio(int tipoEstadio) {
        String str = "";
        switch (tipoEstadio) {
            case 1:
                str = "Normal";
                break;
            case 2:
                str = "Leve";
                break;
            case 3:
                str = "Moderado";
                break;
            case 4:
                str = "Severa";
                break;
            case 5:
                str = "Fallo Renal";
                break;
        }
        return str;
    }

    //INDICE DE MASA CORPORAL
    public double sacaImc(Double peso, Double altura, String sexo) {
        double imc = peso / Math.pow(altura, 2);
        imc = Math.round(imc * 100.0) / 100.0;
        return imc;
    }

    //CLASIFICACION DE IMC
    public String sacaClaificacionImc(Double imc) {
        String str = "";
        if (imc <= 18.4) {
            str = "Bajo peso";
        } else if (imc > 18.4 && imc <= 24.9) {
            str = "Normal";
        } else if (imc > 24.9 && imc <= 29.9) {
            str = "Sobrepeso";
        } else if (imc > 29.9 && imc <= 34.9) {
            str = "Obesidad clase = 1";
        } else if (imc > 34.9 && imc <= 39.9) {
            str = "Obesidad clase = 2";
        } else if (imc > 39.9) {
            str = "Obesidad clase = 3";
        }
        return str;
    }

    //EDAD
    public int sacaEdad(LocalDate fecha_nac) {
        return formato.today().getYear() - fecha_nac.getYear();
    }
}

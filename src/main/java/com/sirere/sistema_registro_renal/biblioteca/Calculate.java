package com.sirere.sistema_registro_renal.biblioteca;

public class Calculate {

    //MRDR4
    private double sacaMrdr4(int edad, double creatinina, String sexo, String raza){
        double res = 0;
        res = (186 * Math.pow(creatinina,(-1.154)) * Math.pow(edad, (-0.203)));
        if(sexo.equals("F")){  // SI ES MUJER
            res = res * (0.742);
        }
        if(raza.equals("ng")){ // SI ES AFROAMERICANA
            res = res * (1.21);
        }
        return res;
    }

    //INDICE DE MASA CORPORAL
    public double sacaImc(Double peso, Double altura, String sexo) {
        double imc =  peso/Math.pow(altura,2);
        imc = Math.round(imc*100.0)/100.0;
        return imc;
    }
    //CLASIFICACION DE IMC
    public String sacaClaificacionImc(Double imc) {
        String str = "";
        if (imc <= 18.4) {
            str = "Bajo peso";
        } else if (imc > 18.4 && imc <= 24.9) {
            str = "Normal";
        } else if (imc > 24.9 && imc<=29.9){
            str = "Sobrepeso";
        }else if (imc > 29.9 && imc <= 34.9) {
            str = "Obesidad clase = 1";
        } else if (imc > 34.9 && imc <= 39.9) {
            str = "Obesidad clase = 2";
        } else if (imc > 39.9) {
            str = "Obesidad clase = 3";
        }
        return str;
    }

}

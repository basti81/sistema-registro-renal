package com.sirere.sistema_registro_renal.biblioteca;

public class Calculador {

    public double sacaImc(Double peso, Double altura, int sexo) {
        double resp = 0;
        resp = peso/Math.pow(altura,2);
        if (sexo == 0) {

            return (resp);
        } else if (sexo == 1) {
            return 0;
        } else {
            return 0;
        }
    }

    public String sacaCalificacionImc(Double imc) {
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

package com.ifba.exercicio_recursao;

 public class Potencia {

    public int calcular(int base, int expoente) {

        if (expoente == 0) {
            return 1;
        }

        return base * calcular(base, expoente - 1);
    }
}
package com.ifba.exercicio_recursao;

import java.util.Scanner;

public class MainP {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Potencia potencia = new Potencia();

        System.out.print("Digite a base: ");
        int base = teclado.nextInt();

        System.out.print("Digite o expoente: ");
        int expoente = teclado.nextInt();

        System.out.println("Resultado: " + potencia.calcular(base, expoente));

        teclado.close();
    }
}

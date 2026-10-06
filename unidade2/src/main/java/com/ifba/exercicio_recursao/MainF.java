package com.ifba.exercicio_recursao;

import java.util.Scanner;

public class MainF {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Fibonacci fibonacci = new Fibonacci();

        System.out.print("Digite a quantidade de termos: ");
        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci.calcular(i) + " ");
        }

        teclado.close();
    }
}
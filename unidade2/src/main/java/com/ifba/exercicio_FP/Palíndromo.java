package com.ifba.exercicio_FP;

import java.util.Stack;
import java.util.Scanner;

public class Palíndromo{

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = entrada.nextLine();

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < palavra.length(); i++) {
            pilha.push(palavra.charAt(i));
        }

        boolean palindromo = true;

       
        for (int i = 0; i < palavra.length(); i++) {

            if (palavra.charAt(i) != pilha.pop()) {
                palindromo = false;
                break;
            }
        }

        if (palindromo) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo!");
        }

        entrada.close();
    }
}

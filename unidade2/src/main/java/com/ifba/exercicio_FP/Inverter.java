package com.ifba.exercicio_FP;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Inverter {

    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        fila.add("A");
        fila.add("B");
        fila.add("C");
        fila.add("D");

        System.out.println("Fila normal:");

        for (String elemento : fila) {
            System.out.print(elemento + " ");
        }

        Stack<String> pilha = new Stack<>();

        
        while (!fila.isEmpty()) {
            pilha.push(fila.remove());
        }

        
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }

        System.out.println("\n\nFila invertida:");

        for (String elemento : fila) {
            System.out.print(elemento + " ");
        }
    }
}

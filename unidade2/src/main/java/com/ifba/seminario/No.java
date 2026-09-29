package com.ifba.seminario;

public class No {
     int valor;
    No esquerda;
    No direita;
    int altura;


    // 1. Cria um novo nó
    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}


package com.ifba.seminario;

public class Main {
    public static void main(String[] args) {


        // 1. Cria uma nova árvore AVL
        ArvoreAVL arvore = new ArvoreAVL();


        // 2. Insere os valores
        System.out.println("Inserindo: 30");
        arvore.raiz = arvore.inserir(arvore.raiz, 30);


        System.out.println("Inserindo: 20");
        arvore.raiz = arvore.inserir(arvore.raiz, 20);


        System.out.println("Inserindo: 10");
        arvore.raiz = arvore.inserir(arvore.raiz, 10);


        // 3. Mostra os valores em ordem
        System.out.println();
        System.out.println("Valores em ordem:");


        arvore.emOrdem(arvore.raiz);


        // 4. Mostra a estrutura da árvore
        System.out.println();
        System.out.println();
        System.out.println("Estrutura da arvore:");


        arvore.mostrarArvore(arvore.raiz, "");
    }

}
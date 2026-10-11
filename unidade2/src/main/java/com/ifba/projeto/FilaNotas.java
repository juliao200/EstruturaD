package com.ifba.projeto;

public class FilaNotas {

    private class No {
        Nota nota;
        No proximo;

        public No(Nota nota) {
            this.nota = nota;
            this.proximo = null;
        }
    }

    private No inicio;
    private No fim;

    public FilaNotas() {
        inicio = null;
        fim = null;
    }

    public void adicionar(Nota nota) {
        No novo = new No(nota);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }

        System.out.println("Nota adicionada a fila!");
    }

    public void consultarProxima() {
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.println("Proxima nota pendente:");
        inicio.nota.mostrarNota();
    }

    public void retirar() {
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.println("Nota retirada da fila:");
        inicio.nota.mostrarNota();

        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }
    }

    public void listarFila() {
        if (inicio == null) {
            System.out.println("Fila vazia!");
            return;
        }

        No atual = inicio;

        while (atual != null) {
            atual.nota.mostrarNota();
            System.out.println("--------------------");

            atual = atual.proximo;
        }
    }
}
package com.ifba.projeto;

public class ListaNotas {

    private class No {
        Nota nota;
        No proximo;

        public No(Nota nota) {
            this.nota = nota;
            this.proximo = null;
        }
    }

    private No inicio;

    public ListaNotas() {
        inicio = null;
    }

    public void inserirInicio(Nota nota) {
        No novo = new No(nota);

        novo.proximo = inicio;
        inicio = novo;
    }

    public void inserirFim(Nota nota) {
        No novo = new No(nota);

        if (inicio == null) {
            inicio = novo;
            return;
        }

        No atual = inicio;

        while (atual.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = novo;
    }

    public void inserirPosicao(Nota nota, int posicao) {
        if (posicao < 1) {
            System.out.println("Posicao invalida!");
            return;
        }

        if (posicao == 1) {
            inserirInicio(nota);
            return;
        }

        No atual = inicio;
        int contador = 1;

        while (atual != null && contador < posicao - 1) {
            atual = atual.proximo;
            contador++;
        }

        if (atual == null) {
            System.out.println("Posicao invalida!");
            return;
        }

        No novo = new No(nota);
        novo.proximo = atual.proximo;
        atual.proximo = novo;
    }

    public void removerInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        inicio = inicio.proximo;
        System.out.println("Nota removida!");
    }

    public void removerFim() {
        if (inicio == null) {
            System.out.println("Lista vazia!");
            return;
        }

        if (inicio.proximo == null) {
            inicio = null;
            System.out.println("Nota removida!");
            return;
        }

        No atual = inicio;

        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }

        atual.proximo = null;
        System.out.println("Nota removida!");
    }

    public void removerPosicao(int posicao) {
        if (inicio == null || posicao < 1) {
            System.out.println("Posicao invalida!");
            return;
        }

        if (posicao == 1) {
            removerInicio();
            return;
        }

        No atual = inicio;
        int contador = 1;

        while (atual.proximo != null && contador < posicao - 1) {
            atual = atual.proximo;
            contador++;
        }

        if (atual.proximo == null) {
            System.out.println("Posicao invalida!");
            return;
        }

        atual.proximo = atual.proximo.proximo;
        System.out.println("Nota removida!");
    }

    public void listarNotas() {
        if (inicio == null) {
            System.out.println("Nenhuma nota cadastrada!");
            return;
        }

        No atual = inicio;
        int posicao = 1;

        while (atual != null) {
            System.out.println("\nPosicao: " + posicao);
            atual.nota.mostrarNota();
            System.out.println("--------------------");

            atual = atual.proximo;
            posicao++;
        }
    }

    public void pesquisarNota(String nome) {
        No atual = inicio;
        boolean encontrou = false;

        while (atual != null) {
            if (atual.nota.nomeAluno.equalsIgnoreCase(nome)) {
                atual.nota.mostrarNota();
                System.out.println("--------------------");
                encontrou = true;
            }

            atual = atual.proximo;
        }

        if (!encontrou) {
            System.out.println("Nenhuma nota encontrada para esse aluno!");
        }
    }

    public void verificarPosicao(String nome) {
        No atual = inicio;
        int posicao = 1;
        boolean encontrou = false;

        while (atual != null) {
            if (atual.nota.nomeAluno.equalsIgnoreCase(nome)) {
                System.out.println(nome + " esta na posicao " + posicao);
                encontrou = true;
            }

            atual = atual.proximo;
            posicao++;
        }

        if (!encontrou) {
            System.out.println("Aluno nao encontrado!");
        }
    }
}

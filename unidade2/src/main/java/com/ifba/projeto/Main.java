package com.ifba.projeto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ListaNotas lista = new ListaNotas();
        FilaNotas fila = new FilaNotas();

        int opcao;

        do {
            System.out.println("\n===== CADASTRO DE NOTAS =====");
            System.out.println("1 - Inserir nota no inicio");
            System.out.println("2 - Inserir nota no fim");
            System.out.println("3 - Inserir nota em uma posicao");
            System.out.println("4 - Remover nota do inicio");
            System.out.println("5 - Remover nota do fim");
            System.out.println("6 - Remover nota de uma posicao");
            System.out.println("7 - Listar todas as notas");
            System.out.println("8 - Pesquisar nota por aluno");
            System.out.println("9 - Verificar posicao do aluno");
            System.out.println("10 - Adicionar nota a fila");
            System.out.println("11 - Consultar proxima nota da fila");
            System.out.println("12 - Retirar nota da fila");
            System.out.println("13 - Listar fila");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1:
                case 2:
                case 3:
                    System.out.print("Nome do aluno: ");
                    String nome = entrada.nextLine();

                    System.out.print("Disciplina: ");
                    String disciplina = entrada.nextLine();

                    System.out.print("Nota: ");
                    double valor = entrada.nextDouble();
                    entrada.nextLine();

                    Nota nota = new Nota(nome, disciplina, valor);

                    if (opcao == 1) {
                        lista.inserirInicio(nota);
                        System.out.println("Nota inserida no inicio!");
                    } else if (opcao == 2) {
                        lista.inserirFim(nota);
                        System.out.println("Nota inserida no fim!");
                    } else {
                        System.out.print("Posicao desejada: ");
                        int posicao = entrada.nextInt();
                        entrada.nextLine();

                        lista.inserirPosicao(nota, posicao);
                    }
                    break;

                case 4:
                    lista.removerInicio();
                    break;

                case 5:
                    lista.removerFim();
                    break;

                case 6:
                    System.out.print("Posicao para remover: ");
                    int posicaoRemover = entrada.nextInt();
                    entrada.nextLine();

                    lista.removerPosicao(posicaoRemover);
                    break;

                case 7:
                    lista.listarNotas();
                    break;

                case 8:
                    System.out.print("Nome do aluno para pesquisar: ");
                    String nomePesquisa = entrada.nextLine();

                    lista.pesquisarNota(nomePesquisa);
                    break;

                case 9:
                    System.out.print("Nome do aluno: ");
                    String nomePosicao = entrada.nextLine();

                    lista.verificarPosicao(nomePosicao);
                    break;

                case 10:
                    System.out.print("Nome do aluno: ");
                    String nomeFila = entrada.nextLine();

                    System.out.print("Disciplina: ");
                    String disciplinaFila = entrada.nextLine();

                    System.out.print("Nota: ");
                    double valorFila = entrada.nextDouble();
                    entrada.nextLine();

                    Nota notaFila = new Nota(
                        nomeFila,
                        disciplinaFila,
                        valorFila
                    );

                    fila.adicionar(notaFila);
                    break;

                case 11:
                    fila.consultarProxima();
                    break;

                case 12:
                    fila.retirar();
                    break;

                case 13:
                    fila.listarFila();
                    break;

                case 0:
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        entrada.close();
    }
}

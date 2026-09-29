package com.ifba.seminario;

public class ArvoreAVL {
    No raiz;

    // 1. Calcula a altura de um nó
    int altura(No no) {


        if (no == null) {
            return 0;
        }


        return no.altura;
    }

    // 2. Calcula o fator de balanceamento
    // Fórmula:
    // altura da direita - altura da esquerda
    int fatorBalanceamento(No no) {


        if (no == null) {
            return 0;
        }


        return altura(no.esquerda) - altura(no.direita);
    }

    // 3. Realiza uma rotação simples à direita
    // Utilizada no caso LL
    No rotacaoDireita(No y) {


        No x = y.esquerda;
        No T2 = x.direita;


        // Reorganiza os nós
        x.direita = y;
        y.esquerda = T2;


        // Atualiza a altura do nó que desceu
        y.altura = 1 + Math.max(
                altura(y.esquerda),
                altura(y.direita)
        );


        // Atualiza a altura do novo nó raiz
        x.altura = 1 + Math.max(
                altura(x.esquerda),
                altura(x.direita)
        );


        // Retorna a nova raiz
        return x;
    }




    // 4. Realiza uma rotação simples à esquerda
    // Utilizada no caso RR
    No rotacaoEsquerda(No x) {


        No y = x.direita;
        No T2 = y.esquerda;


        // Reorganiza os nós
        y.esquerda = x;
        x.direita = T2;


        // Atualiza a altura do nó que desceu
        x.altura = 1 + Math.max(
                altura(x.esquerda),
                altura(x.direita)
        );


        // Atualiza a altura do novo nó raiz
        y.altura = 1 + Math.max(
                altura(y.esquerda),
                altura(y.direita)
        );


        // Retorna a nova raiz
        return y;
    }




    // 5. Insere um novo valor na árvore
    No inserir(No no, int valor) {


        // 5.1. Inserção normal de uma BST
        if (no == null) {
            return new No(valor);
        }

        // 5.2. Se o valor for menor, vai para a esquerda
        if (valor < no.valor) {

            no.esquerda = inserir(no.esquerda, valor);

        }

        // 5.3. Se o valor for maior, vai para a direita
        else if (valor > no.valor) {

            no.direita = inserir(no.direita, valor);

        }

        // 5.4. Se o valor já existir, não insere novamente
        else {

            return no;
        }

        // 6. Atualiza a altura do nó
        no.altura = 1 + Math.max(
                altura(no.esquerda),
                altura(no.direita)
        );

        // 7. Calcula o fator de balanceamento
        int fb = fatorBalanceamento(no);

        // 8. Caso LL
        // A árvore está pesada para a esquerda
        // e o novo valor foi inserido à esquerda
        if (fb > 1 && valor < no.esquerda.valor) {


            System.out.println("Caso LL -> Rotacao a direita");


            return rotacaoDireita(no);
        }




        // 9. Caso RR
        // A árvore está pesada para a direita
        // e o novo valor foi inserido à direita
        if (fb < -1 && valor > no.direita.valor) {


            System.out.println("Caso RR -> Rotacao a esquerda");


            return rotacaoEsquerda(no);
        }




        // 10. Caso LR
        // A árvore está pesada para a esquerda,
        // mas o novo valor foi inserido à direita
        if (fb > 1 && valor > no.esquerda.valor) {


            System.out.println(
                    "Caso LR -> Rotacao a esquerda + direita"
            );


            // Primeiro faz rotação à esquerda
            no.esquerda = rotacaoEsquerda(no.esquerda);


            // Depois faz rotação à direita
            return rotacaoDireita(no);
        }




        // 11. Caso RL
        // A árvore está pesada para a direita,
        // mas o novo valor foi inserido à esquerda
        if (fb < -1 && valor < no.direita.valor) {


            System.out.println(
                    "Caso RL -> Rotacao a direita + esquerda"
            );


            // Primeiro faz rotação à direita
            no.direita = rotacaoDireita(no.direita);


            // Depois faz rotação à esquerda
            return rotacaoEsquerda(no);
        }




        // 12. Se estiver balanceada, retorna o nó normalmente
        return no;
    }




    // 13. Percorre a árvore em ordem
    // Esquerda -> Raiz -> Direita
    void emOrdem(No no) {


        if (no != null) {


            emOrdem(no.esquerda);


            System.out.print(no.valor + " ");


            emOrdem(no.direita);
        }
    }




    // 14. Mostra a estrutura da árvore
    void mostrarArvore(No no, String espaco) {


        if (no == null) {
            return;
        }


        mostrarArvore(no.direita, espaco + "    ");


        System.out.println(
                espaco + no.valor +
                " (altura: " + no.altura +
                ", FB: " + fatorBalanceamento(no) + ")"
        );


        mostrarArvore(no.esquerda, espaco + "    ");
    }
}



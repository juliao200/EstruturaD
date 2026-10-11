package com.ifba.projeto;

public class Nota {

    String nomeAluno;
    String disciplina;
    double valorNota;

    public Nota(String nomeAluno, String disciplina, double valorNota) {
        this.nomeAluno = nomeAluno;
        this.disciplina = disciplina;
        this.valorNota = valorNota;
    }

    public void mostrarNota() {
        System.out.println("Aluno: " + nomeAluno);
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Nota: " + valorNota);
    }
}

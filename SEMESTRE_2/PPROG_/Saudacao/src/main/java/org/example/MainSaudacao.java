package org.example;

public class MainSaudacao {
    public static void main(String[] args) {

        Pessoa p1 = new Pessoa("Ana", 1);
        System.out.printf("Olá %s de idade %d ano(s).%n", p1.getNome(), p1.getIdade());

        p1.setNome("Maria");
        p1.setIdade(14);
        System.out.printf(p1.toString());
    }
}
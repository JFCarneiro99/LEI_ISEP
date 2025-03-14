package org.example;


public class MainVencimentos {
    public static void main(String[] args) {
        Trabalhador t1 = new TrabalhadorPeca("Jorge Silva", 53, 62);
        Trabalhador t2 = new TrabalhadorComissao("Susana Ferreira", 650.00f, 2731.50f, 4.5f);
        Trabalhador t3 = new TrabalhadorHora("Carlos Miguel", 168, 4.50f);

        Trabalhador[] contentor = new Trabalhador[10];

        contentor[0] = new TrabalhadorPeca("Jorge Silva", 53, 62);
        contentor[1] = new TrabalhadorComissao("Susana Ferreira", 650.00f, 2731.50f, 4.5f);
        contentor[2] = new TrabalhadorHora("Carlos Miguel", 168, 4.50f);

        System.out.println("Lista de todos os trabalhadores:");
        for (Trabalhador t : contentor) {
            if (t != null) {
                System.out.println(t);
            }
        }

        System.out.println("\nLista apenas dos trabalhadores à hora:");
        for (Trabalhador t : contentor) {
            if (t instanceof TrabalhadorHora) {
                System.out.println(t);
            }
        }

        System.out.println("\nLista dos nomes dos trabalhadores com vencimentos:");
        for (Trabalhador t : contentor) {
            if (t != null) {
                System.out.printf("%s: %.2f€%n", t.getNome(), t.calcularVencimento());
            }
        }
    }
}
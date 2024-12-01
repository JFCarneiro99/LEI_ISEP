import java.util.Scanner;

public class Programa_qualidade2 {
    public static Scanner ler = new Scanner(System.in);
    public static final int MINIMO_REJECT_LOW = 0;
    public static final int MAXIMO_REJECT_LOW = 49;
    public static final int MAXIMO_APROVED = 90;
    public static final int MAXIMO_REJECT_HIGH = 100;
    public static final int N_MINIMO = 5;
    public static final int N_MAXIMO = 50;

    public static void main(String[] args) {

        int n = verificarIntervalo(N_MINIMO, N_MAXIMO);
        int sequenciaAtual = 0, sequenciaMaxima = 0;
        int lowRejected = 0, aprovados = 0;
        int soma = 0;

        for (int i = 1; i <= n; i++) {
            int valor = verificarIntervalo(MINIMO_REJECT_LOW, MAXIMO_REJECT_HIGH);
            soma += valor;
            if (valor <= MAXIMO_REJECT_LOW) {
                lowRejected++;
                sequenciaAtual = 0;

            } else if (valor <= MAXIMO_APROVED) {
                aprovados++;
                sequenciaAtual++;
                if (sequenciaAtual > sequenciaMaxima)
                    sequenciaMaxima = sequenciaAtual;
            } else {
                sequenciaAtual = 0;
            }
        }

        if (aprovados > 0) {
            System.out.println("Número de produtos aprovados = " + aprovados);
            System.out.println("Maior sequência de produtos aprovados = " + sequenciaMaxima);
        } else {
            System.out.println("Nenhum produto foi aprovado");


        }
        double media = ((double)soma / n);
        double percentagemLowrejected = ((double)lowRejected / n)*100.00;
        System.out.printf("Valor médio da qualidade dos produtos = %.2f%n", media);
        System.out.printf("Rejected (low) = %.2f%%%n", percentagemLowrejected);
    }

    public static int verificarIntervalo(int min, int max) {
        int valor = ler.nextInt();
        while (valor < min || valor > max) {
            valor = ler.nextInt();
        }
        return valor;
    }
}


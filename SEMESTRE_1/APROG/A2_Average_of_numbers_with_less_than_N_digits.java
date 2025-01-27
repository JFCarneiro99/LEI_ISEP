import java.util.Scanner;

public class A2_Average_of_numbers_with_less_than_N_digits {

    static final int K = 5;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int maximoAlgarismos = ler.nextInt();
        int numero;
        int sequencia = 0;
        int soma = 0;
        do {
            numero = ler.nextInt();
            if (qttAlgarismos(numero) < maximoAlgarismos) {
                soma += numero;
                sequencia++;
            } else if (sequencia == 0) {
                sequencia = 1;
            }
        } while (sequencia < K && qttAlgarismos(numero) < maximoAlgarismos);

        System.out.printf("%.2f%n", (double) soma / sequencia);

    }

    public static int qttAlgarismos(int numero) {
        int qttAlgarismos = 1;
        while (numero > 9) {
            qttAlgarismos++;
            numero /= 10;
        }
        return qttAlgarismos;
    }
}



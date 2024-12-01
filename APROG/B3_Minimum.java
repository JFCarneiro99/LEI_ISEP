import java.util.Scanner;

public class B3_Minimum {
    public static Scanner ler = new Scanner(System.in);
    public static int MAX_ARRAY = 100;

    public static void main(String[] args) {

        int[] numeros = new int[MAX_ARRAY];

        int totalNumeros = inserirNumeros(numeros);
        int menorNumero = encontrarMenorNumero(numeros, totalNumeros);
        int ocurrencias = contarOcurrencias(numeros, totalNumeros, menorNumero);

        if (totalNumeros != 0) {
            System.out.println("min=" + menorNumero);
            System.out.println("occurrences=" + ocurrencias);
        }
    }

    public static int inserirNumeros(int[] numeros) {

        int totalNumeros = 0;
        int numero = ler.nextInt();

        while (numero >= 0) {

            numeros[totalNumeros] = numero;
            totalNumeros++;
            numero = ler.nextInt();
        }

        if (totalNumeros > -1) {
            return totalNumeros;
        } else {
            return 0;
        }
    }

    public static int contarOcurrencias(int[] numeros, int totalNumeros, int menorNumero) {
        int contador = 0;

        for (int i = 0; i < (totalNumeros); i++) {
            if (numeros[i] == menorNumero) {
                contador = contador + 1;
            }
        }
        return contador;
    }

    public static int encontrarMenorNumero(int[] numeros, int totalNumeros) {
        int menorNumero = Math.max(numeros[0], numeros[totalNumeros]);

        for (int i = 0; i < (totalNumeros); i++) {
            if (numeros[i] < menorNumero) {
                menorNumero = numeros[i];
            }
        }
        return menorNumero;
    }
}

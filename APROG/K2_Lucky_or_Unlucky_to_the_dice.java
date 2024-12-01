import java.util.Scanner;

public class K2_Lucky_or_Unlucky_to_the_dice {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num = ler.nextInt();
        if (verificarNumero(num) == true) {
            System.out.println("points=" + resultado(num));
        }
    }

    public static int resultado(int num) {
        int alg1;
        int alg2 = 0;
        int numInvertido = inverterNumero(num);
        int resultado = 0;
        int contador = 0;

        while (numInvertido > 0) {

            alg1 = numInvertido % 10;
            numInvertido = numInvertido / 10;

            if (alg2 != alg1) {
                resultado += alg1;
            }

            if (alg1 == alg2) {
                if (contador == 0) {
                    resultado = -resultado - alg1;
                    contador = contador + 1;
                } else {
                    resultado = resultado - alg1;
                    contador = contador + 1;
                }
            }
            alg2 = alg1;
        }
        return (resultado);
    }

    public static int inverterNumero(int num) {

        int alg;
        int numinvertido = num;
        int numinicial = num;
        int qntalg = 0;

        while (numinvertido > 0) {
            numinvertido = numinvertido / 10;
            qntalg = qntalg + 1;
        }

        for (num = numinicial; qntalg > 0; qntalg--) {
            alg = num % 10;
            num = num / 10;
            numinvertido = numinvertido + alg * (int) Math.pow(10, qntalg - 1);
        }
        return (numinvertido);
    }

    public static boolean verificarNumero(int num) {
        int numVerificado = num;
        int alg;
        int verificacao = 0;

        while (numVerificado > 0) {
            alg = numVerificado % 10;
            numVerificado /= 10;
            if (alg > 0 && alg <= 6) {
                verificacao++;
            }
        }

        if (verificacao == numeroAlgarismos(num)) {
            return true;
        } else {
            return false;
        }
    }

    public static int numeroAlgarismos(int num) {
        int numalg = 0;
        int algarismos = num;

        while (algarismos > 0) {
            algarismos = algarismos / 10;
            numalg = numalg + 1;
        }
        return numalg;
    }
}

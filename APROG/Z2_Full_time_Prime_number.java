import java.util.Scanner;

public class Z2_Full_time_Prime_number {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int inicio = ler.nextInt();
        int fim = ler.nextInt();

        int contadorPrimosATempoInteiro = 0;

            for (int i = inicio; i <= fim; i++) {
                if (isPrimoATempoInteiro(i)) {
                    System.out.println(i);
                    contadorPrimosATempoInteiro++;

            }
        }
        System.out.println("(" + contadorPrimosATempoInteiro + ")");
    }

    public static boolean isPrimoATempoInteiro(int num) {

        int inversoes = (int) Math.log10(num) + 1;
        int numeroInvertido = num;
        if (num <= 1){
            return false;
        }
        for (int i = 0; i < inversoes; i++) {
            if (!isPrimo(numeroInvertido)) {
                return false;
            }
            numeroInvertido = inverteDireita(numeroInvertido);
        }
        return true;
    }

    public static int inverteDireita(int num) {
        int alg = num % 10;
        int resto = num / 10;
        int potencia = (int) Math.pow(10, (int) Math.log10(num));
        return alg * potencia + resto;
    }

    public static boolean isPrimo(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}


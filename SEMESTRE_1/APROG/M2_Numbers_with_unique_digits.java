import java.util.Scanner;

public class M2_Numbers_with_unique_digits {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int positivos = 0;
        int negativos = 0;
        int unicos = 0;
        int total = 0;

        int num = ler.nextInt();

        while (num != 0) {

            if (num > 0) {
                positivos++;
            } else {
                negativos++;
            }

            if ((verificarDigitos(num)) == true){
                System.out.println(num);
                unicos++;
            }
            total++;
            num = ler.nextInt();
        }
        if (total > 0){
            double percentagemNegativos = (double)negativos * 100.0 / total;
            double percentagemPositivos = (double)positivos * 100.0 / total;
            double percentagemUnicos = (double)unicos * 100.0 / total;

            System.out.printf("negatives: %.2f%%%n", percentagemNegativos);
            System.out.printf("positives: %.2f%%%n", percentagemPositivos);
            System.out.printf("with unique digits: %.2f%%%n", percentagemUnicos);
        }
    }

    public static boolean verificarDigitos(int num) {
        int numVerificado = Math.abs(num);
        int marcadorNumero = 0;

        while (numVerificado > 0) {
            int alg = numVerificado % 10;
            int mascaraNumero = 1 << alg;

            if ((marcadorNumero & mascaraNumero) != 0) {
                return false;
            }
            marcadorNumero |= mascaraNumero;
            numVerificado /= 10;
        }
        return true;
    }
}
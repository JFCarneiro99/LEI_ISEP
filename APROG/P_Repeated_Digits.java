import java.util.Scanner;

public class P_Repeated_Digits {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);


        int numero = ler.nextInt();
        while (numero >=0) {
            int contador = 0;
            String numeroStr = Integer.toString(numero);
            boolean repetidoEncontrado = false;

            for (int i = numeroStr.length() - 1; i >= 0 && !repetidoEncontrado; i--) {
                char digito = numeroStr.charAt(i);
                int posicao = numeroStr.length() - i;

                for (int j = i - 1; j >= 0; j--) {
                    if (numeroStr.charAt(j) == digito && contador == 0) {
                        int posicaoAnterior = numeroStr.length() - j;
                        System.out.printf("%d : digit (%c) repeated in positions (%d) and (%d)%n",
                                numero, digito, posicao, posicaoAnterior);
                        repetidoEncontrado = true;
                        contador++;
                    }
                }
            }
            numero = ler.nextInt();
        }
    }
}
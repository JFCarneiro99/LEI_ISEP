import java.util.Scanner;

public class J_Percentage_of_digits {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int N, numlido, num, i, contadorAlgarismos, contadorNumeros;
        double alg, maiorpercentagem, percentagem;

        maiorpercentagem = 0;

        N = ler.nextInt();
        if (N > 0){
            for (i = 0; i < N; i++) {

                numlido = ler.nextInt();

                num = numlido;
                contadorNumeros = 0;
                contadorAlgarismos = 0;

                while (num > 0) {
                    alg = num % 10;
                    num = num / 10;
                    contadorNumeros = contadorNumeros + 1;
                    if (alg != 0 && numlido % alg == 0) {
                        contadorAlgarismos = contadorAlgarismos + 1;
                    }
                }
                percentagem = ((double)contadorAlgarismos / contadorNumeros) * 100;
                System.out.printf("%.2f%%\n", percentagem);

                if (percentagem > maiorpercentagem){
                    maiorpercentagem = percentagem;
                }
            }
            System.out.printf("(%.2f%%)\n", maiorpercentagem);
        }
    }
}

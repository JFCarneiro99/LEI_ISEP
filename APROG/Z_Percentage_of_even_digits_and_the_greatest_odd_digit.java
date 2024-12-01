import java.util.Scanner;

public class Z_Percentage_of_even_digits_and_the_greatest_odd_digit {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int numero = ler.nextInt();

        if (numero > 0) {
            int totalAlgarismos = 0;
            int contPares = 0;
            int maiorImpar = -1;


            while (numero > 0) {
                int digito = numero % 10;
                totalAlgarismos++;


                if (digito % 2 == 0) {
                    contPares++;
                } else {

                    if (digito > maiorImpar) {
                        maiorImpar = digito;
                    }
                }
                numero /= 10;
            }

            double percentagemPares = (double) contPares / totalAlgarismos * 100;

            System.out.printf("%.2f%%\n", percentagemPares);

            if (maiorImpar == -1) {
                System.out.println("no odd digits");
            } else {
                System.out.println(maiorImpar);
            }
        }
    }
}

import java.util.Scanner;
public class B_Sum_even_digits_v2 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numlido, num, alg, soma;

        numlido = ler.nextInt();


        while (numlido >= 0){
            soma = 0;
            num = numlido;

            while (num > 0){
                alg = num % 10;
                num = num / 10;

                if (alg % 2 == 0) {
                    soma = soma + alg;
                }
            }
            System.out.println(soma);
            numlido = ler.nextInt();
        }
    }
}
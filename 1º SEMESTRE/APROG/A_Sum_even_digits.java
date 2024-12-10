import java.util.Scanner;

public class A_Sum_even_digit {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num, alg, soma;
        soma = 0;
        num = ler.nextInt();

        while (num > 0){
            alg = num % 10;
            num = num / 10;

            if (alg % 2 == 0) {
                soma = soma + alg;
            }
        }
        System.out.println(soma);
        }
}

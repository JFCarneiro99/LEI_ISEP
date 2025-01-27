import java.util.Scanner;

public class L_Perfect_Numbers {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int N, num, contador, somaDivisores;

        N = ler.nextInt();
        contador = 0;
        num = 1;

        while (contador < N) {
            somaDivisores = 0;

            for (int i = 1; i < num;  i++) {
                if (num % i == 0) {
                    somaDivisores += i;
                }
            }
            if (somaDivisores == num){
                System.out.println(num);
                contador++;
            }
            num++;
        }
    }
}

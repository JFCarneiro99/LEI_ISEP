import java.util.Scanner;

public class K_Prime_numbers_below_a_limit {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int N, numerodivisores;

        N = ler.nextInt();

        for (int num = 2; num <= N; num++) {
            numerodivisores = 0;
           for (int divisor = 1; divisor <= num; divisor++) {
               if (num % divisor == 0){
                   numerodivisores++;
               }
            }
           if (numerodivisores == 2){
               System.out.println(num);
           }
        }
    }
}

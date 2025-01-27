import java.util.Scanner;

public class M_Fibonacci_Sequence {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int N, primeirotermo, segundotermo, proximo;

        N = ler.nextInt();

        primeirotermo = 0;
        segundotermo = 1;

        for (int i = 1; i <= N; i++) {
            if (i == 1){
                System.out.println(primeirotermo);
            } else if (i == 2){
                System.out.println(segundotermo);
            } else {
                proximo = primeirotermo + segundotermo;
                System.out.println(proximo);
                primeirotermo = segundotermo;
                segundotermo = proximo;
            }
        }
    }
}
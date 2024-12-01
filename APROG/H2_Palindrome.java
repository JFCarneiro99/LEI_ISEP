import java.util.Scanner;

public class H2_Palindrome {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int MAX_TENTATIVAS = 5;
        int tentativas = 1;
        int numero = ler.nextInt();

        while(isPalindrome(numero) == false && tentativas < MAX_TENTATIVAS) {
            tentativas++;
            numero = ler.nextInt();
        }

        if (tentativas < MAX_TENTATIVAS)
            System.out.println("palindrome");

        else
            System.out.println("attempts exceeded");

    }

    public static boolean isPalindrome(int numero) {
        int aux = numero;
        int result = 0;

        while (aux > 0) {
            int algarismos = aux % 10;
            aux /= 10;
            result = result * 10 + algarismos;
        }
        return (result == numero);
    }
}

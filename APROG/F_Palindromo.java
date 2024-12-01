import java.util.Scanner;

public class F_Palindromo {
    public static void main(String[] args) {

        int num, numinicial, numqnt, numinvertido, alg, qntalg;

        Scanner ler = new Scanner(System.in);
        numinicial = ler.nextInt();

        numinvertido = 0;
        numqnt = numinicial;
        qntalg = 0;

        if(numinicial>0){
            while (numqnt > 0) {
                numqnt = numqnt / 10;
                qntalg = qntalg + 1;
            }

            for (num = numinicial; qntalg > 0; qntalg--) {
                alg = num % 10;
                num = num / 10;
                numinvertido = numinvertido + alg * (int) Math.pow(10, qntalg-1);
            }

            if (numinicial == numinvertido) {
                System.out.println("palindrome");
            } else{
                System.out.println("not palindrome");
            }
        }
    }
}
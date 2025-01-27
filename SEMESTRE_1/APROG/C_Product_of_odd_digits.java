import java.util.Scanner;

public class C_Product_of_odd_digits {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num, alg;
        int prdt = 1;
        int contador = 0;

        num = ler.nextInt();

        if (num > 0) {
                while (num > 0) {
                    alg = num % 10;
                    num = num / 10;

                    if (alg % 2 != 0) {
                        prdt = prdt * alg;
                        contador += 1;
                    }
                }
            if (contador >= 1) {
                System.out.println(prdt);
            } else
                System.out.println("no odd digits");
        }
    }
}

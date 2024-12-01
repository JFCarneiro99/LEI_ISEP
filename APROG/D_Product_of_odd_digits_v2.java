import java.util.Scanner;

public class D_Product_of_odd_digits_v2 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num, alg, numlido, prdt;
        numlido = ler.nextInt();
        boolean numimpar = false;

        while (numlido >= 0) {
            prdt = 1;
            num = numlido;


            while (num > 0){
                alg = num % 10;
                num = num / 10;

                if (alg % 2 != 0) {
                    prdt = prdt * alg;
                    numimpar = true;
                }
            }
            if (numimpar) {
                System.out.println(prdt);
            } else
                System.out.println("no odd digits");

            numlido = ler.nextInt();
            numimpar = false;
        }
    }
}


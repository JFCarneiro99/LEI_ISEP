import java.util.Scanner;

public class Y_Dividers_multiples_of_3 {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int numero = ler.nextInt();

        if (numero <= 0) {

        } else {
            int contador = 0;

            for (int i = 1; i <= numero; i++) {
                if (numero % i == 0) {
                    if (i % 3 == 0) {
                        System.out.println(i);
                        contador++;
                    }
                }
            }

            if (contador == 0) {
                System.out.println("without dividers multiples of 3");
            }
        }
    }
}

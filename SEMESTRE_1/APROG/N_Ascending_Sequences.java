import java.util.Scanner;

public class N_Ascending_Sequences {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num, numseguinte;

        num = ler.nextInt();
        if (num >= 0) {
            numseguinte = ler.nextInt();

            while (numseguinte >= 0) {

                if (numseguinte > num && numseguinte >= 0) {
                    int temp = numseguinte;
                    int digitoAnterior = 10;

                    int crescente = 1;
                    while (temp > 0) {
                        int digitoAtual = temp % 10;
                        temp /= 10;

                        if (digitoAtual >= digitoAnterior) {
                            crescente = 0;
                        }
                        digitoAnterior = digitoAtual;
                    }

                    if (crescente == 1) {
                        System.out.println(numseguinte);
                    }
                }
                num = numseguinte;
                numseguinte = ler.nextInt();
            }
        }
    }
}


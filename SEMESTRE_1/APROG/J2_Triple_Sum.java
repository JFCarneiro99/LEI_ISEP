import java.util.Scanner;

public class J2_Triple_Sum {
    public static void main(String[] args) {
        final int N = 100;

        Scanner ler = new Scanner(System.in);
        int num = Integer.parseInt(ler.nextLine());

        if (num >0 && num <= N) {
            System.out.println("triples=" + tripleSum(num));

        }
    }

    public static int tripleSum(int num) {

        int contagemTriplas = 0;

        for (int primeiroalgarismo = num; primeiroalgarismo >= 1; primeiroalgarismo--) {
            for (int segundoalgarismo = primeiroalgarismo; segundoalgarismo >= 1; segundoalgarismo--) {
                for (int terceiroalgarismo = segundoalgarismo; terceiroalgarismo >= 1; terceiroalgarismo--) {
                    if (primeiroalgarismo + segundoalgarismo + terceiroalgarismo == num) {
                        System.out.println(primeiroalgarismo + " + " + segundoalgarismo + " + " + terceiroalgarismo);
                        contagemTriplas++;
                    }
                }
            }
        }
        return contagemTriplas;
    }
}
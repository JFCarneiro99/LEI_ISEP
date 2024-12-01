import java.util.Scanner;

public class E_Convert_from_base_8_to_decimal {
    public static void main(String[] args) {

        int numoctal, alg, num;
        double ordem, numdecimal;

        Scanner ler = new Scanner(System.in);

        num = ler.nextInt();
        while (num >= 0) {

            numoctal = num;
            numdecimal = 0;
            ordem = 0;
            while (numoctal > 0) {
                alg = numoctal % 10;
                numdecimal = numdecimal + alg * Math.pow(8, ordem);
                ordem = ordem + 1;
                numoctal = numoctal / 10;
            }
            System.out.printf("%.0f%n" , numdecimal);
            num = ler.nextInt();
        }
    }
}

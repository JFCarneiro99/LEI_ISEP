import java.util.Scanner;

public class D2_Combinations_and_permutations {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int m = ler.nextInt();
        int n = ler.nextInt();

        if (m >= n) {
            System.out.printf("C(%d,%d)=%d%n", m, n, combinations(m, n));
            System.out.printf("P(%d,%d)=%d%n", m, n, permutations(m, n));
        }
    }

    public static int factorial(int n) {
        int fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public static int combinations(int m, int n) {
        int combinacoes = factorial(m) / (factorial(n) * factorial(m - n));
        return combinacoes;
    }

    public static int permutations(int m, int n) {
        int permutacoes = factorial(m) / factorial(m - n);
        return permutacoes;
    }
}

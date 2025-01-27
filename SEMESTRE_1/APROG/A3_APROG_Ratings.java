import java.util.Scanner;

public class A3_APROG_Ratings {
    public static final int NOTA_MINIMA = 10;
    public static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int N = ler.nextInt();
        double [] alunos = new double [N];

        double media = lerAlunos(alunos)/N;
        int reprovados = obterReprovados(alunos);

        System.out.printf("average=%.1f%n", media);
        System.out.printf("failures=%d%n", reprovados);
    }

    public static double lerAlunos(double [] alunos) {
        double soma = 0.0;

        for(int i = 0; i < alunos.length; i++) {
            alunos[i] = ler.nextDouble();
            soma += alunos[i];
        }
        return soma;
    }

    public static int obterReprovados(double [] alunos) {
        int reprovados = 0;

        for(int i = 0; i < alunos.length; i++) {
            if (alunos[i] < NOTA_MINIMA) {
                reprovados++;
            }
        }
        return reprovados;
    }
}

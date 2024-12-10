import java.util.Scanner;

public class B2_Ranking_chart {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int numeroAlunos, numeroDisciplinas, numeroAlunosAprovados;
        String nomeDisciplina;

        numeroAlunos = Integer.parseInt(ler.nextLine());
        numeroDisciplinas = Integer.parseInt(ler.nextLine());

        for (int disciplina = 0; disciplina < numeroDisciplinas; disciplina++) {
            nomeDisciplina = ler.nextLine();
            numeroAlunosAprovados = Integer.parseInt(ler.nextLine());
            imprimirInformacao(nomeDisciplina, numeroAlunos, numeroAlunosAprovados);
        }
    }

    public static void imprimirInformacao(String nomeDisciplina, int numeroAlunos, int numeroAlunosAprovados) {
        System.out.println("Subject: " + nomeDisciplina);
        System.out.print("- Approved: ");

        for (int i = 0; i < numeroAlunosAprovados; i++)
            System.out.print("*");

        System.out.println();
        System.out.print("- Failed: ");

        for (int i = 0; i < (numeroAlunos - numeroAlunosAprovados); i++)
            System.out.print("*");

        System.out.println();

    }
}

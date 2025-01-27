import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exame_2024n {
    static final int MAX_ALUNOS = 100;
    static final String FILE_NAME = "C:\\Users\\josef\\Desktop\\alunos.txt";
    static final int FILAS = 7;
    static final int LUGARES_POR_FILA = 10;
    static final String[] TURMAS = {"1DA", "1DB", "1DC", "1DD"};

    public static void main(String[] args) throws FileNotFoundException {
        int[] numeros = new int[MAX_ALUNOS];
        String[][] nomesTurmas = new String[MAX_ALUNOS][2];

        // 1. Ler informação do ficheiro
        int totalAlunos = lerInformacaoDoFicheiro(FILE_NAME, numeros, nomesTurmas);
        System.out.println("Total de alunos lidos: " + totalAlunos);

        // 2. Obter distribuição dos alunos pela sala
        int[][] ocupacaoDaSala = obterDistribuicaoDosAlunos(totalAlunos, numeros);
        imprimirSala(ocupacaoDaSala);

        // 3. Obter quantidade de alunos por turma
        int[] alunosPorTurma = obterQuantidadeDeAlunosPorTurma(totalAlunos, nomesTurmas);
        for (int i = 0; i < TURMAS.length; i++) {
            System.out.println("Turma " + TURMAS[i] + ": " + alunosPorTurma[i] + " alunos");
        }
    }

    // Metodo 1: Ler dados do ficheiro e armazenar em arrays
    public static int lerInformacaoDoFicheiro(String fileName, int[] numeros, String[][] nomesTurmas) throws FileNotFoundException {
        File ficheiro = new File(fileName);
        Scanner scanner = new Scanner(ficheiro);
        int count = 0;

        while (scanner.hasNextLine() && count < MAX_ALUNOS) {
            String linha = scanner.nextLine();
            String[] partes = linha.split(",\\s*");

            if (partes.length == 3) {
                nomesTurmas[count][0] = partes[0];  // Nome
                numeros[count] = Integer.parseInt(partes[1]);  // Número mecanográfico
                nomesTurmas[count][1] = partes[2];  // Turma
                count++;
            }
        }

        scanner.close();
        return count;
    }

    // Metodo 2: Distribuir os alunos pelos lugares disponíveis na sala
    public static int[][] obterDistribuicaoDosAlunos(int totalAlunos, int[] numeros) {
        int[][] sala = new int[FILAS][LUGARES_POR_FILA];

        // Preencher sala com zeros
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < LUGARES_POR_FILA; j++) {
                sala[i][j] = 0;
            }
        }

        int indexAluno = 0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < LUGARES_POR_FILA; j += 2) { // Computadores em posições pares
                if (indexAluno < totalAlunos) {
                    sala[i][j] = numeros[indexAluno];
                    indexAluno++;
                }
            }
        }

        return sala;
    }

    // Metodo 3: Contar alunos por turma
    public static int[] obterQuantidadeDeAlunosPorTurma(int totalAlunos, String[][] nomesTurmas) {
        int[] contagemTurmas = new int[TURMAS.length];

        for (int i = 0; i < totalAlunos; i++) {
            for (int j = 0; j < TURMAS.length; j++) {
                if (nomesTurmas[i][1].equals(TURMAS[j])) {
                    contagemTurmas[j]++;
                }
            }
        }

        return contagemTurmas;
    }

    // Metodo auxiliar: Imprimir a ocupação da sala
    public static void imprimirSala(int[][] sala) {
        System.out.println("Distribuição da sala:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < LUGARES_POR_FILA; j++) {
                System.out.printf("%4d", sala[i][j]);
            }
            System.out.println();
        }
    }
}

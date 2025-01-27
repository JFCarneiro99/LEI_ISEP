import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    public static double[][] preencherMatrizDeUmFicheiroDouble(File ficheiro, double [][] matriz) throws FileNotFoundException {
        Scanner sc = new Scanner (ficheiro);

        for (int linha = 0; linha < matriz.length; linha++) {
            String[] itensDaLinha = sc.nextLine().split(",");
            for (int coluna = 0; coluna < itensDaLinha.length; coluna++) {
                matriz[linha][coluna] = Integer.parseInt(itensDaLinha[coluna]);
            }
        }
        sc.close();
        return matriz;
    }

    public static void preencherMatrizDeUmFicheiro(File ficheiro, int [][] matriz) throws FileNotFoundException {
        Scanner sc = new Scanner (ficheiro);

        for (int linha = 0; linha < matriz.length; linha++) {
            String[] itensDaLinha = sc.nextLine().split(",");
            for (int coluna = 0; coluna < itensDaLinha.length; coluna++) {
                matriz[linha][coluna] = Integer.parseInt(itensDaLinha[coluna]);
            }
        }
        sc.close();
    }

}

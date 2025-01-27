import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validacoes {
    public static int VALORMAX_PIXEL = 255;
    public static int VALORMAX_MATRIZ = 256;

    public static boolean validarMatrizDoFicheiro1(File ficheiro) throws FileNotFoundException {

        int contadorAlturaMatriz = 0;
        int larguraMatriz = 0;
        int larguraAuxiliar = 0;
        Scanner sc = new Scanner(ficheiro);
        while (sc.hasNextLine()) {

            // Alterar para verificar se a linha é vazia
            String linha = sc.nextLine().trim();
            if (linha.isEmpty()) {
                //ignorar linha vazia
            }else {

                String[] intensDaLinha = linha.split(",");
                larguraMatriz = intensDaLinha.length;

                if (larguraMatriz > VALORMAX_MATRIZ) {
                    System.out.println("Erro: Valores da matriz incorretos!");
                    return false;
                }

                for (int i = 0; i < intensDaLinha.length; i++) {

                    int valor = Integer.parseInt(intensDaLinha[i]);

                    if (!verificarValores(valor, VALORMAX_PIXEL)) {
                        System.out.println("Erro: Valores da matriz incorretos!");
                        return false;
                    }
                }
                if (contadorAlturaMatriz == 0) {
                    larguraAuxiliar = larguraMatriz;
                } else if (larguraMatriz != larguraAuxiliar) {
                    System.out.println("Erro: Matriz não é quadrada!");
                    return false;
                }
                contadorAlturaMatriz++;
            }
        }
        sc.close();

        if (larguraMatriz != contadorAlturaMatriz) {
            System.out.println("Erro: Matriz não é quadrada!");
            return false;
        }

        return true;
    }

    public static boolean eSimetrica(double[][] matriz) {
        if (matriz.length != matriz[0].length)
            return false;

        for (int linha = 0; linha < matriz[0].length; linha++) {
            for (int coluna = 0; coluna < matriz.length; coluna++) {
                if (matriz[linha][coluna] != matriz[coluna][linha]) {
                    System.out.println("Matriz não é simetrica!");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean verificarValores(int valor , int max) {
        if (valor > max || valor < 0) {
            return false;
        }
        return true;
    }

    public static boolean validarParametros(int funcionalidade, int k, String ficheiroEntrada, String baseImagens, String ficheiroSaida, boolean modoInterativo) {
        boolean valido = true;

        if (funcionalidade != 1 && (k < -1 || k == 0 || k > 255)) {
            System.out.printf("%nErro: Número de eigenfaces inválido. Deve ser -1 ou um número inteiro positivo até 255.");
            valido = false;
        }
        if (funcionalidade == 1 && (k < -1 || k == 0 || k > 255 )) {
            System.out.printf("%nErro: Número de valores próprios inválido. Deve ser -1 ou um número inteiro positivo até 255.");
            valido = false;
        }
        if (funcionalidade == 1  && (ficheiroEntrada == null || !new File(ficheiroEntrada).exists())) {
            System.out.printf("%nErro: Ficheiro de entrada inválido ou não encontrado.");
            valido = false;
        }
        if (funcionalidade != 1 && (baseImagens == null || !new File(baseImagens).exists())) {
            System.out.printf("%nErro: Base de imagens inválida ou não encontrada.");
            valido = false;
        }
        if (funcionalidade!= 4 && (modoInterativo == false  && (ficheiroSaida == null || ficheiroSaida.isEmpty()))) {
            System.out.printf("%nErro: Nome do ficheiro de saída não pode estar vazio.%n");
            valido = false;
        }

        return valido;
    }

    public static int validarK(int k, int tamanhoMatriz) {
        int OPCAO_DEFAULT = -1;

        if (k == OPCAO_DEFAULT || k > tamanhoMatriz ) {
            k = tamanhoMatriz;
        }

        return k;
    }

    public static void validarQuantidadeDeParametros(String[] args) {
        switch (args[Menu.encontrarPosicaoDaChave(args,"-f")]) {
            case "1":
                if (args.length != 7) {
                    System.out.printf("%nErro: Número de argumentos inválido para a funcionalidade 1.");
                    System.exit(0);
                }
                break;
            case "2":
                if (args.length != 7) {
                    System.out.printf("%nErro: Número de argumentos inválido para a funcionalidade 2.");
                    System.exit(0);
                }
                break;
            case "3":
                if (args.length != 9) {
                    System.out.printf("%nErro: Número de argumentos inválido para a funcionalidade 3.");
                    System.exit(0);
                }
                break;
            case "4":
                if (args.length != 6) {
                    System.out.printf("%nErro: Número de argumentos inválido para a funcionalidade 4.");
                    System.exit(0);
                }
                break;
            default:
                System.out.printf("%nErro: Funcionalidade inválida.");
                System.exit(1);
        }
    }
}

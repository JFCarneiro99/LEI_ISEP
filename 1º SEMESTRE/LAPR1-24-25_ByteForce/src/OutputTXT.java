import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputTXT {

    public static void imprimirMatriz(double[][] matriz, PrintWriter out) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                out.printf("%7.2f ", matriz[i][j]);
            }
            out.println();
        }
        out.println();
    }

    public static void escreverMatrizNumFicheiro(int[][] matriz, String caminhoFicheiro, String nomeFicheiro, PrintWriter out) throws FileNotFoundException {

        PrintWriter outputMatriz = new PrintWriter(new File(caminhoFicheiro, nomeFicheiro));
        for (int i = 0; i < matriz.length; i++) {
            int j = 0;
            while (j < matriz[i].length - 1) {
                outputMatriz.print(matriz[i][j++] + ",");
            }
            outputMatriz.print(matriz[i][j] + "\n");
        }
        outputMatriz.close();

        //out.printf("%nA matriz reconstruida foi escrita com sucesso na pasta %s.%n", caminhoFicheiro);
    }


    public static void imprimirEAM(double[][] matrizCVS, double[][] matrizk, PrintWriter out) {

        double EAM = Operacoes_Matrizes.calcularEAM(matrizCVS, matrizk);
        out.printf("O erro absoluto médio (EAM) é %.2f.%n", EAM);
    }


    public static void imprimirVetor(double[] vetor, PrintWriter out) {
        for (int i = 0; i < vetor.length; i++) {
            out.printf("%7.2f ", vetor[i]);
        }
        out.printf("%n%n");
    }

    public static void imprimirEAMDeCadaImagem(double[][] matrizOriginal,double[][] matrizReconstruida, PrintWriter out){
        double[] vetorImagemOriginal=new double[matrizOriginal.length];
        double[] vetorImagemReconstruida=new double[matrizReconstruida.length];
        for (int coluna = 0; coluna < matrizOriginal[0].length; coluna++) {
            for (int linha = 0; linha < matrizOriginal.length; linha++) {
                vetorImagemOriginal[linha]=matrizOriginal[linha][coluna];
                vetorImagemReconstruida[linha]=matrizReconstruida[linha][coluna];
            }
            double EAM=Operacoes_Matrizes.calcularEAMVetor(vetorImagemOriginal,vetorImagemReconstruida);
            out.printf("EAM da imagem %d: %.2f%n", coluna +1,EAM);
        }
    }

    public static void imprimirVetorPesos(double[] vetor, int linha, PrintWriter out) {

        out.printf("Vetor de Pesos da Imagem %02d1: %n", (linha));
        imprimirVetor(vetor, out);
    }

    public static void escreverImagem(int[][] matriz, String outputPath,String nomeFicheiro, String operacaoFeita) {
        // Create an instance of GreyscaleImageWriter
        GreyscaleImageWriter imageWriter = new GreyscaleImageWriter();

        try {
            imageWriter.writeArrayAsImage(matriz, outputPath + "\\" + nomeFicheiro);
            //System.out.printf("A %s foi escrita com sucesso na pasta %s.%n", operacaoFeita, outputPath);
            //System.out.println("A Imagem reconstruida foi escrita com sucesso na pasta " + outputPath);
        } catch (IOException e) {
            System.err.println("Failed to write the image: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid pixel values in the array: " + e.getMessage());
        }
    }

    public static void imprimirImagensDaMatriz(double[][] matriz, String caminho, String operacaoFeita, PrintWriter out) throws FileNotFoundException {

        double[][] matrizTransposta = Operacoes_Matrizes.obterTransposta(matriz);

//        double [][]matrizImagensNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizTransposta);


        for (int i = 0; i < matrizTransposta.length; i++) {
            double[][] matrizTemp = Operacoes_Matrizes.converterVetorEmMatriz(matrizTransposta[i]);
            double[][] matrizTempNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizTemp);

            int[][] matrizTempInt = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizTemp);
            OutputTXT.escreverMatrizNumFicheiro(matrizTempInt, caminho, "Imagem_" + i + ".csv", out);

            if (!(matrizTempNormalizada == null)) {
                int[][] matrizTempNormalizadaInt = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizTempNormalizada);
                OutputTXT.escreverMatrizNumFicheiro(matrizTempNormalizadaInt, caminho, "Imagem_" + i + "_transformada.csv", out);
                OutputTXT.escreverImagem(matrizTempNormalizadaInt, caminho , "Imagem_" + i + ".jpg", operacaoFeita);
            } else {
                OutputTXT.escreverImagem(matrizTempInt, caminho , "Imagem_" + i + ".jpg", operacaoFeita);
            }

        }
    }

    public static void imprimirDiagonalDeUmaMatriz(double[][] matrizDiagonal, PrintWriter out) {
        for (int i = 0; i < matrizDiagonal.length; i++) {
            out.printf("%7.2f ", matrizDiagonal[i][i]);
        }
        out.printf("%n%n");
    }

    public static void imprimirVetoresDeUmaMatriz(double[][] matriz, PrintWriter out) {
        double[][] matrizTransposta = Operacoes_Matrizes.obterTransposta(matriz);
        for (int i = 0; i < matrizTransposta.length; i++) {
            out.printf("Vetor %d: ", i + 1);
            OutputTXT.imprimirVetor(matrizTransposta[i], out);
        }
    }

    public static void imprimirVetoresPesosParaCadaImagem(double[][] matrizVetorPesosTransposta, PrintWriter out) {
        for (int i = 0; i < matrizVetorPesosTransposta.length; i++) {
            OutputTXT.imprimirVetorPesos(matrizVetorPesosTransposta[i], i, out);
        }

    }


    public static void imprimirVetorPesosEDistanciaEuclidianaDeCadaImagem(double[] distanciasEuclidianas, double[][] matrizVetoresPesosTransposta, PrintWriter out) {
        for (int imagem = 0; imagem < matrizVetoresPesosTransposta.length; imagem++){
            OutputTXT.imprimirVetorPesos(matrizVetoresPesosTransposta[imagem], imagem, out);
            out.printf("Distancia Euclidiana da Imagem %02d1: %.2f\n\n", imagem , distanciasEuclidianas[imagem]);
        }
    }
}

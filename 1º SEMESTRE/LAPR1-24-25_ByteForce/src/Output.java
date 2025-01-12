import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {

    public static void imprimirMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%7.2f ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void escreverMatrizNumFicheiro(int[][] matriz, String caminhoFicheiro, String nomeFicheiro) throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File(caminhoFicheiro, nomeFicheiro));
        for (int i = 0; i < matriz.length; i++) {
            int j = 0;
            while (j < matriz[i].length - 1) {
                out.print(matriz[i][j++] + ",");
            }
            out.print(matriz[i][j] + "\n");
        }
        out.close();
        //System.out.printf("%nA matriz reconstruída foi escrita com sucesso na pasta %s.%n", caminhoFicheiro);
    }

    public static void escreverVetorNumFicheiro(double[] vetor, String caminhoFicheiro, String nomeFicheiro) throws FileNotFoundException {

        PrintWriter out = new PrintWriter(new File(caminhoFicheiro, nomeFicheiro));
        int j = 0;

        while (j < vetor.length - 1) {
            out.print(vetor[j++] + ",");
        }
        out.print(vetor[j] + "\n");

        out.close();
    }

    public static void imprimirEAM(double[][] matrizCVS, double[][] matrizk) {

        double EAM = Operacoes_Matrizes.calcularEAM(matrizCVS, matrizk);
        System.out.printf("O erro absoluto médio (EAM) é %.2f.%n", EAM);
    }



    public static void imprimirVetor(double[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("%7.2f ", vetor[i]);
        }
        System.out.printf("%n%n");
    }

    public static void imprimirEAMDeCadaImagem(double[][] matrizOriginal,double[][] matrizReconstruida){
        double[] vetorImagemOriginal=new double[matrizOriginal.length];
        double[] vetorImagemReconstruida=new double[matrizReconstruida.length];
        for (int coluna = 0; coluna < matrizOriginal[0].length; coluna++) {
            for (int linha = 0; linha < matrizOriginal.length; linha++) {
                vetorImagemOriginal[linha]=matrizOriginal[linha][coluna];
                vetorImagemReconstruida[linha]=matrizReconstruida[linha][coluna];
            }
            double EAM=Operacoes_Matrizes.calcularEAMVetor(vetorImagemOriginal,vetorImagemReconstruida);
            System.out.printf("EAM da imagem %d: %.2f%n", coluna +1,EAM);
        }
    }

    public static void imprimirVetorPesos(double[] vetor, int linha) {
        //System.out.println("Vetor de Pesos da Imagem " + (linha + 1));
        System.out.printf("Vetor de Pesos da Imagem %02d1: %n", (linha));
        imprimirVetor(vetor);
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

    public static void imprimirImagensDaMatriz(double[][] matriz, String caminho, String operacaoFeita) throws FileNotFoundException {

        double[][] matrizTransposta = Operacoes_Matrizes.obterTransposta(matriz);

//        double [][]matrizImagensNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizTransposta);


        for (int i = 0; i < matrizTransposta.length; i++) {
            double[][] matrizTemp = Operacoes_Matrizes.converterVetorEmMatriz(matrizTransposta[i]);
            double[][] matrizTempNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizTemp);

            int[][] matrizTempInt = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizTemp);
            Output.escreverMatrizNumFicheiro(matrizTempInt, caminho, "Imagem_" + i + ".csv");

            if (!(matrizTempNormalizada == null)) {
                int[][] matrizTempNormalizadaInt = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizTempNormalizada);
                Output.escreverMatrizNumFicheiro(matrizTempNormalizadaInt, caminho, "Imagem_" + i + "_transformada.csv");
                Output.escreverImagem(matrizTempNormalizadaInt, caminho , "Imagem_" + i + ".jpg", operacaoFeita);
            } else {
                Output.escreverImagem(matrizTempInt, caminho , "Imagem_" + i + ".jpg", operacaoFeita);
            }

        }
    }

    public static void imprimirDiagonalDeUmaMatriz(double[][] matrizDiagonal) {
        for (int i = 0; i < matrizDiagonal.length; i++) {
            System.out.printf("%7.2f ", matrizDiagonal[i][i]);
        }
        System.out.printf("%n%n");
    }

    public static void imprimirVetoresDeUmaMatriz(double[][] matriz) {
        double[][] matrizTransposta = Operacoes_Matrizes.obterTransposta(matriz);
        for (int i = 0; i < matrizTransposta.length; i++) {
            System.out.printf("Vetor %d: ", i + 1);
            Output.imprimirVetor(matrizTransposta[i]);
        }
    }

    public static void imprimirVetoresPesosParaCadaImagem(double[][] matrizVetorPesosTransposta) {
        for (int i = 0; i < matrizVetorPesosTransposta.length; i++) {
            Output.imprimirVetorPesos(matrizVetorPesosTransposta[i], i);
        }

    }


    public static void imprimirVetorPesosEDistanciaEuclidianaDeCadaImagem(double[] distanciasEuclidianas, double[][] matrizVetoresPesosTransposta) {
        for (int imagem = 0; imagem < matrizVetoresPesosTransposta.length; imagem++){
            Output.imprimirVetorPesos(matrizVetoresPesosTransposta[imagem], imagem);
            System.out.printf("Distancia Euclidiana da Imagem %02d1: %.2f\n\n", imagem , distanciasEuclidianas[imagem]);
        }
    }
}

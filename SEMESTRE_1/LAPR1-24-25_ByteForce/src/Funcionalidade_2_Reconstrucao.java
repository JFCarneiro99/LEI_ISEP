import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Funcionalidade_2_Reconstrucao {
    public static final String OUTPUT_EIGENFACES = "Eigenfaces\\";
    public static final String OUTPUT_IMAGENS_RECONSTRUIDAS = "ImagensReconstruidas\\";

    public static void executarFuncionalidade(int k, String baseImagens,String ficheiroTXT, boolean modoInterativo) throws FileNotFoundException {

        double[][] matrizImagens = Operacoes_Matrizes.construirMatrizDeImagens(baseImagens);
        if (matrizImagens == null) {
            //Ocorreu um erro ao construir a matriz de imagens.
        }else {

            k = Validacoes.validarK(k, matrizImagens[0].length);
            double[] vetorMedia = Operacoes_Matrizes.obterVetorMedia(matrizImagens);
            double[][] matrizPhiA = Operacoes_Matrizes.obterMatrizPhiBase(matrizImagens, vetorMedia);
            double[][] matrizPhiATransposta = Operacoes_Matrizes.obterTransposta(matrizPhiA);
            double[][] matrizAtA = Operacoes_Matrizes.multiplicarMatrizes(matrizPhiATransposta, matrizPhiA);
            double[][][] matrizesDecompostasAAt = Operacoes_Matrizes.obterMatrizVetoresPropriosAAt(matrizPhiA, matrizAtA);
            double[][][] matrizesDecompostasAAtReduzida = Operacoes_Matrizes.obterMatrizesReduzidasValoresEVetoresProprios(matrizesDecompostasAAt, k);
            double[][] matrizVetoresPropriosK = matrizesDecompostasAAtReduzida[0];
            double[][] matrizEigenfaces = Operacoes_Matrizes.normalizarMatriz(matrizVetoresPropriosK);
            double[][] matrizVetorPesosTransposta = Operacoes_Matrizes.obterMatrizPesosDasImagensTransposta(matrizImagens, matrizEigenfaces, vetorMedia);
            double[][] matrizImagensReconstruidas = Operacoes_Matrizes.obterMatrizImagensReconstruidaTransposta(matrizVetorPesosTransposta, matrizEigenfaces, vetorMedia);

            if(modoInterativo) {
                System.out.printf("%nO vetor média é:%n");
                Output.imprimirVetor(vetorMedia);
                System.out.printf("O numero de eigenfaces utilizadas na reconstrução das imagens é %d.%n", k);
                System.out.printf("%nO vetores Peso para cada imagem são: %n%n");
                Output.imprimirVetoresPesosParaCadaImagem(matrizVetorPesosTransposta);
                System.out.println("EAM de cada imagem:");
                Output.imprimirEAMDeCadaImagem(matrizImagens, matrizImagensReconstruidas);
                Output.imprimirImagensDaMatriz(matrizImagensReconstruidas, OUTPUT_IMAGENS_RECONSTRUIDAS, "Imagem Reconstruida");
                Output.imprimirImagensDaMatriz((matrizEigenfaces), OUTPUT_EIGENFACES, "Eigenface");
            }else {
                PrintWriter out = new PrintWriter(ficheiroTXT);
                out.printf("%nO vetor média é:%n");
                OutputTXT.imprimirVetor(vetorMedia, out);
                out.printf("O numero de eigenfaces utilizadas na reconstrução das imagens é %d.%n", k);
                out.printf("%nO vetores Peso para cada imagem são: %n%n");
                OutputTXT.imprimirVetoresPesosParaCadaImagem(matrizVetorPesosTransposta, out);
                out.println("EAM de cada imagem:");
                OutputTXT.imprimirEAMDeCadaImagem(matrizImagens, matrizImagensReconstruidas, out);
                OutputTXT.imprimirImagensDaMatriz(matrizImagensReconstruidas, OUTPUT_IMAGENS_RECONSTRUIDAS, "Imagem Reconstruida", out);
                OutputTXT.imprimirImagensDaMatriz((matrizEigenfaces), OUTPUT_EIGENFACES, "Eigenface", out);
                out.close();
            }
        }
    }
}

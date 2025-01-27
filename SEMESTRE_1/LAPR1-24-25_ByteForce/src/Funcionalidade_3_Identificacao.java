import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Funcionalidade_3_Identificacao {
    public static final String OUTPUT = "Identificacao\\";

    public static void executarFuncionalidade(int k, String caminhoNovaImagem, String baseImagens,String ficheiroTXT, boolean modoInterativo) throws FileNotFoundException {

        double[][] matrizImagens = Operacoes_Matrizes.construirMatrizDeImagens(baseImagens);
        if (matrizImagens == null) {
            //Ocorreu um erro ao construir a matriz de imagens.
        } else {
            k = Validacoes.validarK(k, matrizImagens[0].length);
            double[] vetorMedia = Operacoes_Matrizes.obterVetorMedia(matrizImagens);
            double[][] matrizPhiA = Operacoes_Matrizes.obterMatrizPhiBase(matrizImagens, vetorMedia);
            double[][] matrizPhiATransposta = Operacoes_Matrizes.obterTransposta(matrizPhiA);
            double[][] matrizAtA = Operacoes_Matrizes.multiplicarMatrizes(matrizPhiATransposta, matrizPhiA);
            double[][][] matrizesDecompostasAAt = Operacoes_Matrizes.obterMatrizVetoresPropriosAAt(matrizPhiA, matrizAtA);
            double[][][] matrizesDecompostasAAtReduzida = Operacoes_Matrizes.obterMatrizesReduzidasValoresEVetoresProprios(matrizesDecompostasAAt, k);
            double[][] matrizVetoresPropriosK = matrizesDecompostasAAtReduzida[0];
            double[][] matrizEigenfaces = Operacoes_Matrizes.normalizarMatriz(matrizVetoresPropriosK);
            double[][] matrizVetoresPesosTransposta = Operacoes_Matrizes.obterMatrizPesosDasImagensTransposta(matrizImagens, matrizEigenfaces, vetorMedia);
            double[][] matrizImagemAComparar = Operacoes_Matrizes.construirMatrizDaImagemAcomparar(caminhoNovaImagem);

            if (matrizImagemAComparar == null) {
                //Ocorreu um erro ao construir a matriz imagem a comparar.
            } else {
                double[] vetorImagemAComparar = Operacoes_Matrizes.obterVetorImagem(matrizImagemAComparar);
                double[] vetorPesosImagemAComparar = Operacoes_Matrizes.obterVetorPesos(vetorImagemAComparar, matrizEigenfaces, vetorMedia);
                double[] distanciasEuclidianas = Operacoes_Matrizes.calcularDistanciaEuclidiana(matrizVetoresPesosTransposta, vetorPesosImagemAComparar);
                int indiceImagemMaisProxima = Operacoes_Matrizes.obterIndiceImagemMaisProxima(distanciasEuclidianas);
                double[][] matrizAImprimir = Operacoes_Matrizes.converterVetorEmMatriz(Operacoes_Matrizes.obterTransposta(matrizImagens)[indiceImagemMaisProxima]);
                if(modoInterativo) {
                    System.out.printf("\nO número de Eigenfaces/Pesos utilizados foi: %d\n\n", k);
                    System.out.printf("Vetor de Pesos da Imagem a Comparar:\n");
                    Output.imprimirVetor(vetorPesosImagemAComparar);
                    Output.imprimirVetorPesosEDistanciaEuclidianaDeCadaImagem(distanciasEuclidianas, matrizVetoresPesosTransposta);
                    Output.escreverImagem(Operacoes_Matrizes.transformarEmMatrizInteiros(matrizAImprimir), OUTPUT, "Imagem.jpg", "Imagem Mais Próxima");
                }else {
                    PrintWriter out = new PrintWriter(ficheiroTXT);
                    out.printf("\nO número de Eigenfaces/Pesos utilizados foi: %d\n\n", k);
                    out.printf("Vetor de Pesos da Imagem a Comparar:\n");
                    OutputTXT.imprimirVetor(vetorPesosImagemAComparar, out);
                    OutputTXT.imprimirVetorPesosEDistanciaEuclidianaDeCadaImagem(distanciasEuclidianas, matrizVetoresPesosTransposta, out);
                    OutputTXT.escreverImagem(Operacoes_Matrizes.transformarEmMatrizInteiros(matrizAImprimir), OUTPUT, "Imagem.jpg", "Imagem Mais Próxima");
                    out.close();
                }
            }
        }
    }
}
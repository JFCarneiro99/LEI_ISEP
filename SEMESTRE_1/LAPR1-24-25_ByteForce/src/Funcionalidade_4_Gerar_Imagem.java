import java.io.FileNotFoundException;

public class Funcionalidade_4_Gerar_Imagem {
    public static final String OUTPUT = "Output\\";

    public static void executarFuncionalidade(int k, String baseImagens) throws FileNotFoundException {

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
            double[][] matrizValoresPropriosK = matrizesDecompostasAAtReduzida[1];
            double[][] matrizEigenfaces = Operacoes_Matrizes.normalizarMatriz(matrizVetoresPropriosK);
            double[] vetorPesosAleatorios = Operacoes_Matrizes.obterVetorPesosAleatorio(matrizValoresPropriosK);
            double[][] imagemGerada = Operacoes_Matrizes.converterVetorEmMatriz(Operacoes_Matrizes.reconstroiImagem(matrizEigenfaces, vetorMedia, vetorPesosAleatorios));
            double[][] imagemGeradaNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(imagemGerada);

            if (!(imagemGeradaNormalizada == null)) {
                Output.escreverImagem(Operacoes_Matrizes.transformarEmMatrizInteiros(imagemGeradaNormalizada), OUTPUT , "Imagem_gerada.jpg", "Imagem gerada");
                Output.escreverMatrizNumFicheiro(Operacoes_Matrizes.transformarEmMatrizInteiros(imagemGeradaNormalizada), OUTPUT, "Imagem_gerada.csv");

            } else {
                Output.escreverImagem(Operacoes_Matrizes.transformarEmMatrizInteiros(imagemGerada), OUTPUT ,   "Imagem_gerada.jpg", "Imagem gerada");
                Output.escreverMatrizNumFicheiro(Operacoes_Matrizes.transformarEmMatrizInteiros(imagemGerada), OUTPUT, "Imagem_gerada.csv");
            }
        }
    }
}

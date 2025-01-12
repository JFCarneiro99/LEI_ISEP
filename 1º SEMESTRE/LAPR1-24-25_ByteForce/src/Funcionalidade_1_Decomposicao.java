import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class Funcionalidade_1_Decomposicao {

    public static final String OUTPUT = "Output\\";

    public static void executarFuncionalidade(int k, String ficheiroEntrada, String nomeFicheiroSaida, boolean modoInterativo) throws FileNotFoundException {
        File ficheiro = new File(ficheiroEntrada);
        if (!Validacoes.validarMatrizDoFicheiro1(ficheiro)) {
            //nok
        } else {
            int tamanhoMatriz = Operacoes_Matrizes.calcularDimensaoMatriz(ficheiro);
            double[][] matrizA = new double[tamanhoMatriz][tamanhoMatriz];
            k = Validacoes.validarK(k, matrizA.length);
            matrizA = Input.preencherMatrizDeUmFicheiroDouble(ficheiro, matrizA);
             if (!Validacoes.eSimetrica(matrizA)) {
                 //não é simetrica
            } else {
                RealMatrix matriz = MatrixUtils.createRealMatrix(matrizA);
                RealMatrix[] resultado = Operacoes_Matrizes.obterMatrizesValorEVetoresProprios(matriz);
                double[][][] matrizResultado = {resultado[0].getData(), resultado[1].getData()};
                double[][][] decomposicaoDaMatrizAK = Operacoes_Matrizes.obterMatrizesReduzidasValoresEVetoresProprios(matrizResultado, k);
                double[][] matrizVetoresPropriosK = decomposicaoDaMatrizAK[0];
                double[][] matrizValoresPropriosK = decomposicaoDaMatrizAK[1];
                double[][] matrizAK = Operacoes_Matrizes.preencherMatrizK(matrizVetoresPropriosK, matrizValoresPropriosK);
                double[][] matrizAKNormalizada = Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizAK);
                int[][] matrizAKInt = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizAK);

                if (modoInterativo) {

                    System.out.printf("%nO número de valores e vetores próprios utilizados na decomposição é %d.%n", k);
                    System.out.printf("%n Os valores próprios utilizados na decomposição são: %n");
                    Output.imprimirDiagonalDeUmaMatriz(matrizValoresPropriosK);
                    System.out.printf("Vetores próprios utilizados na decomposição:%n");
                    Output.imprimirVetoresDeUmaMatriz(matrizVetoresPropriosK);
                    Output.imprimirEAM(matrizA, matrizAK);

                    if (matrizAKNormalizada != null) {
                        Output.escreverMatrizNumFicheiro(matrizAKInt, OUTPUT, "Matriz_reconstruida.csv");
                        int[][] matrizAKIntNormalizada = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizAKNormalizada);
                        Output.escreverMatrizNumFicheiro(matrizAKIntNormalizada, OUTPUT, "Matriz_reconstruida_Transformada.csv");
                    } else {
                        Output.escreverMatrizNumFicheiro(matrizAKInt, OUTPUT, "Matriz_reconstruida.csv");
                    }
                }
                else {
                    PrintWriter out = new PrintWriter(nomeFicheiroSaida);

                    out.printf("%nO número de valores e vetores próprios utilizados na decomposição é %d.%n", k);
                    out.printf("%n Os valores próprios utilizados na decomposição são: %n");
                    OutputTXT.imprimirDiagonalDeUmaMatriz(matrizValoresPropriosK, out);
                    out.printf("Vetores próprios utilizados na decomposição:%n");
                    OutputTXT.imprimirVetoresDeUmaMatriz(matrizVetoresPropriosK, out);
                    OutputTXT.imprimirEAM(matrizA, matrizAK, out);

                    if (matrizAKNormalizada != null) {
                        OutputTXT.escreverMatrizNumFicheiro(matrizAKInt, OUTPUT, "Matriz_reconstruida.csv", out);
                        int[][] matrizAKIntNormalizada = Operacoes_Matrizes.transformarEmMatrizInteiros(matrizAKNormalizada);
                        OutputTXT.escreverMatrizNumFicheiro(matrizAKIntNormalizada, OUTPUT, "Matriz_reconstruida_Transformada.csv", out);
                    } else {
                        OutputTXT.escreverMatrizNumFicheiro(matrizAKInt, OUTPUT, "Matriz_reconstruida.csv", out);
                    }
                    out.close();
                }
            }
        }
    }
}

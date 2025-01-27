import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Testes_Unitarios {

    final static double[][] matriz1Teste = {{5, 5, 6},
            {4, 5, 7,},
            {6, 7, 8}};

    final static double[][] matriz2Teste = {{2, 3, 2},
            {3, 3, 3},
            {3, 2, 3}};

    final static double[][] matriz3Teste = {{6, 4, 5, 8, 3},
            {0, 1, 2, 4, 3}};

    final static  double[][] matriz4Teste = {{43, 42, 43},
            {44, 41, 44},
            {57, 55, 57}};

    final static double[][] matriz5Teste = {{8, 6, 5, 4, 3},
            {4, 0, 2, 1, 3}};

    final static double[][] matriz6Teste = {{2, 0, 0, 0},
            {0, 5, 0, 0},
            {0, 0, 3, 0},
            {0, 0, 0, 7}};

    final static double[][] matriz7Teste = {{7, 5, 3, 2},
            {3, 1, 2, 0}};

    final static double[][] matriz8Teste = {{6, 0, 0, 0},
            {0, 4, 0, 0},
            {0, 0, 5, 0},
            {0, 0, 0, 8}};

    final static double[][] matriz9Teste = {{1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}};

    final static double[][] matriz10Teste = {{1, 2, 3, 5},
            {6, 7, 8, 10},
            {11, 12, 13, 15},
            {16, 17, 18, 20},
            {21, 22, 23, 25}};

    final static double[][][] matriz11Teste ={ {{4, 1, 2, 3, 6},
            {1, 3, 0, 1, 6},
            {2, 0, 2, 1, 6},
            {3, 1, 1, 5, 6},
            {3, 1, 1, 5, 6}},

            { {4, 0, 0, 0, 0},
                    {0, 3, 0, 0, 0},
                    {0, 0, 2, 0, 0},
                    {0, 0, 0, 5, 0},
                    {0, 0, 0, 0, 6}}};

    final static double[][] matriz12Teste = {{4, 0, 0, 0},
            {0, 3, 0, 0},
            {0, 0, 5, 0},
            {0, 0, 0, 6}};

    final static double[][] matriz13Teste = {{4, 1, 3, 6},
            {1, 3, 1, 6},
            {2, 0, 1, 6},
            {3, 1, 5, 6},
            {3, 1, 5, 6}};

    final static double[][] matriz14Teste = {{5, 5, 6},
            {4, 5, 7,},
            {6, 7, 8}};

    final static double[][] matriz15Teste = {{5, 4, 6},
            {5, 5, 7},
            {6, 7, 8}};

    final static double[][] matriz16Teste = {{2, 3, 2},
            {3, 3, 3},
            {3, 2, 3}};

    final static double[][] matriz17Teste = {{3, 4, 3},
            {4, 4, 4},
            {4, 3, 4}};

    final static double[][] matriz18Teste={{2,2},
            {2,2}};

    final static double[][] matriz19Teste = {{2, 3},
            {3, 2},
            {2, 2},
            {3, 3}};

    final static double[][] matriz20Teste = {{41, 43},
            {13, 15}};

    final static double[][] matriz21Teste={{41, 43},
            {13, 15}};

    final static double[][] matriz22Teste = {{6, 0, 0, 0},
            {0, 4, 0, 0},
            {0, 0, 5, 0},
            {0, 0, 0, 8}};

    final static double[][] matriz23Teste={{4,-2,-2,-2},
            {-2,2,-2,-2},
            {-2,-2,3,-2},
            {-2,-2,-2,6}};

    final static double[][] matriz24Teste={{50, 50, 40, 60},
            {50, 50, 40, 60},
            {40, 40, 32, 48},
            {60, 60, 48, 72}};

    final static double[][] matriz25Teste={{ 0.03419927840283847, 0.06421612990679355, 0.09065968278232492, 0.13483997249264842},
            {0.20519567041703082, 0.22475645467377744, 0.24175915408619977, 0.26967994498529685},
            { 0.37619206243122316, 0.38529677944076135, 0.3928586253900746, 0.40451991747794525},
            { 0.5471884544454155, 0.5458371042077452, 0.5439580966939495, 0.5393598899705937},
            {0.7181848464596079, 0.7063774289747291, 0.6950575679978244, 0.674199862463242}};

    final static double[][] matriz26Teste={{-1.0, -4.0, -3.0},
            {10.0, 8.0, 12.0},
            {31.0, 29.0, 40.0}};

    final static double[][] matriz27Teste = {{1, 2, 6, 4, 7},
            {6, 7, 8, 9, 10},
            {11, 10, 10, 12, 15},
            {12, 17, 18, 19, 20},
            {1, 2, 20, 15, 4}};

    final static double[][] matriz28Teste={{53.40685691863355, 0, 0, 0, 0},
            {0, -6.341216279343017, 0, 0, 0},
            {0, 0, -6.341216279343017, 0, 0},
            {0, 0, 0, 1.3235849054095272, 0},
            {0, 0, 0, 0, -1.0480092653570965}};

    final static double[][] matriz29Teste={{7.04273437826409, 12.49491453914289, 3.7316446910530114, -1.0365350012703711, 2.2102466448405567},
            {17.35906575563306, 7.3336179160671335, 0.17537902031529207, -0.31308379406353937, 0.7212088623345552},
            {27.67539713300203, 2.17232129299137, -3.3808866504224255, 0.41036741314329206, -0.7678289201714454},
            {37.991728510371, -2.9889753300843864, -6.937152321160145, 1.1338186203501226, -2.2568667026774447},
            {48.30805988773997, -8.150271953160143, -10.493417991897864, 1.8572698275569532, -3.7459044851834413}};

    final static double[][] matriz30Teste= {{300,300,300,300,300},
            {200,200,200,200,200},
            {100,100,100,100,100},
            {0,0,0,0,0},
            {-300,-300,-300,-300,-300}};

    final static double[][] matriz31Teste= {{255.0, 255.0, 255.0, 255.0, 255.0},
            {212.5, 212.5, 212.5, 212.5, 212.5},
            {170.0, 170.0, 170.0, 170.0, 170.0},
            {127.5, 127.5, 127.5, 127.5, 127.5},
            {0,0,0,0,0}};

    final static double[][] matriz32Teste={{76, 176, 276, 376, 476},
            {133, 333, 533, 733, 933},
            {188, 478, 768, 1058, 1348},
            {281, 711, 1141, 1571, 2001},
            {152, 362, 572, 782, 992}};

    final static int[][] matriz33Teste={{50, 50, 40, 60},
            {50, 50, 40, 60},
            {40, 40, 32, 48},
            {60, 60, 48, 72}};

    final static  double[][] matriz34Teste = {{-0.5155028296536841, -0.7119913058386228, 0.5449090357300442},
            {-0.5202581421171956, -9.471590178833367E-15, -0.8285552799285087},
            {-0.6808731880312288, 0.7119913058386309, 0.2494040805607971}};

    final static  double[][] matriz35Teste = {{142.1815875940258, 0.0, 0.0},
            {0.0, -2.4875833001553743E-15, 0.0 },
            {0.0, 0.0, -1.181587594025836}};


    final static double valorTeste1 = 0;
    final static int valorTeste2 = 1;
    final static double valorTeste3 = 2;
    final static double valorTeste4 = 4;
    final static double valorTeste5 = 28;
    final static double valorTeste6 = 300;
    final static double valorTeste7 = -300;
    final static int valorTeste8 = 0;
    final static int valorTeste9 = -1;



    final static double[] vetor1Teste = {42, 14};
    final static double[] vetor2Teste = {2,2,2,2};
    final static double[] vetor3Teste = {4,4,4,4};
    final static double[] vetor4Teste = {9.273618495495704, 9.486832980505138, 12.206555615733702};
    final static double[] vetor5Teste = {6,6,6,6};
    final static double[] vetor6Teste = {-2,-2,-2,-2};
    final static double[] vetor7Teste = {2,3,4,5};
    final static double[] vetor8Teste = {-4,-8,-6,0};
    final static double[] vetor9Teste = {3,5,7};
    final static double[] vetor10Teste = {-838,-837,-668,-1003};
    final static double[] vetor11Teste = {-1110,-1110,-888,-1332};
    final static double[] vetor12Teste = {4, 1, 3, 6, 1, 3, 1, 6, 2, 0, 1, 6, 3, 1, 5, 6, 3, 1, 5, 6};
    final static double[] vetor13Teste = {2,3,4,5,7};


    final static int k = 4;


    public static void main(String[] args) {

       run_testes();
    }

    public static void run_testes() {

        System.out.println("multiplicacaoMatrizes:" + (test_multiplicacaoMatrizes(matriz1Teste, matriz2Teste, matriz4Teste) ? "OK" : "NOT OK"));
        System.out.println("multiplicacaoMatrizes:" + (test_multiplicacaoMatrizes(matriz7Teste, matriz19Teste, matriz20Teste) ? "OK" : "NOT OK"));
        System.out.println("calcularEAM:" + (test_calcularEAM(matriz16Teste, matriz16Teste, valorTeste1) ? "OK" : "NOT OK"));
        System.out.println("calcularEAM:" + (test_calcularEAM(matriz16Teste, matriz17Teste, valorTeste2) ? "OK" : "NOT OK"));
        System.out.println("ordenarMatrizPorValores:" + (test_ordenarMatrizPorValores(matriz3Teste, matriz5Teste) ? "OK" : "NOT OK"));
        System.out.println("obterMatrizOrdenadaValoresProprios:" + (test_obterMatrizOrdenadaValoresProprios(matriz6Teste, matriz7Teste) ? "OK" : "NOT OK"));
        System.out.println("ordenarMatrizPorIndice:" + (test_ordenarMatrizPorIndice(matriz5Teste, matriz3Teste, k) ? "OK" : "NOT OK"));
        System.out.println("reduzirMatrizValoresP:" + (test_reduzirMatrizValoresP(matriz3Teste, matriz8Teste, k) ? "OK" : "NOT OK"));
        System.out.println("reduzirMatrizVetoresP:" + (test_reduzirMatrizVetoresP(matriz3Teste, matriz9Teste, matriz10Teste, k) ? "OK" : "NOT OK"));
        System.out.println("obterMatrizesReduzidasValoresEVetoresProprios_valores:" + (test_obterMatrizesReduzidasValoresEVetoresProprios(matriz11Teste, matriz12Teste, matriz13Teste, k) ? "OK" : "NOT OK"));
        System.out.println("obterTransposta:" + (test_obterTransposta(matriz14Teste, matriz15Teste) ? "OK" : "NOT OK"));
        System.out.println("obterVetorMedia:" + (test_obterVetorMedia(matriz21Teste, vetor1Teste) ? "OK" : "NOT OK"));
        System.out.println("obterMatrizPhiBase:" + (test_obterMatrizPhiBase(matriz22Teste, vetor2Teste, matriz23Teste) ? "OK" : "NOT OK"));
        System.out.println("obterMatrizNorma:" + (test_obterMatrizNorma(matriz15Teste, vetor4Teste) ? "OK" : "NOT OK"));
        System.out.println("converterVetorEmMatriz:" + (test_converterVetorEmMatriz(vetor2Teste, matriz18Teste) ? "OK" : "NOT OK"));
        System.out.println("normalizarMatriz:" + (test_normalizarMatriz(matriz10Teste, matriz25Teste) ? "OK" : "NOT OK"));
        System.out.println("calcularNorma:" + (test_calcularNorma(vetor2Teste, valorTeste4) ? "OK" : "NOT OK"));
        System.out.println("preencherMatrizK:" + (test_preencherMatrizK(matriz19Teste, matriz18Teste, matriz24Teste) ? "OK" : "NOT OK"));
        System.out.println("calcularEAMVetor:" + (test_calcularEAMVetor(vetor2Teste, vetor3Teste, valorTeste3) ? "OK" : "NOT OK"));
        System.out.println("reconstroiImagem:"+(test_reconstroiImagem(matriz24Teste,vetor7Teste,vetor8Teste,vetor10Teste)?"OK":"NOT OK"));
        System.out.println("ObterMatrizPesosDasImagensTranspostas:"+(test_obterMatrizPesosDasImagensTranspostas(matriz14Teste,matriz15Teste,vetor9Teste,matriz26Teste)?"OK":"NOT OK"));
        System.out.println("multiplicarMatrizPorVetor:"+(test_multiplicarMatrizPorVetor(matriz23Teste,vetor2Teste,vetor8Teste)?"OK":"NOT OK"));
        System.out.println("somarVetores:" + (test_somarVetores(vetor3Teste, vetor2Teste, vetor5Teste) ? "OK" : "NOT OK"));
        System.out.println("subtrairVetores:" + (test_subtrairVetores(vetor3Teste, vetor5Teste, vetor6Teste) ? "OK" : "NOT OK"));
        System.out.println("obterProdutoVetorial:" + (test_obterProdutoVetorial(vetor2Teste, vetor7Teste, valorTeste5) ? "OK" : "NOT OK"));
        System.out.println("obterVetorPesos:"+(test_obterVetorPesos(vetor6Teste,matriz24Teste,vetor7Teste,vetor11Teste)?"OK":"NOT OK"));
        System.out.println("obterMatrizVetoresPropriosAAt:"+(test_obterMatrizVetoresPropriosAAt(matriz9Teste,matriz27Teste,matriz28Teste,matriz29Teste)?"OK":"NOT OK"));
        System.out.println("obterIndiceImagemMaisProxima:"+(test_obterIndiceImagemMaisProxima(matriz17Teste,vetor9Teste,valorTeste8)?"OK":"NOT OK"));
        System.out.println("obterMatrizImagensReconstruidaTransposta:" + (test_obterMatrizImagensReconstruidaTransposta(matriz9Teste,matriz27Teste,vetor13Teste,matriz32Teste) ? "OK" : "NOT OK"));
        System.out.println("obterVetorImagem:"+(test_obterVetorImagem(matriz13Teste,vetor12Teste)?"OK":"NOT OK"));
        System.out.println("normalizarEigenfaces:"+(test_normalizarEigenfaces(matriz30Teste,matriz31Teste)?"OK":"NOT OK"));
        System.out.println("obterMinimoEMaximodeMatriz:"+(test_obterMinimoEMaximodeMatriz(matriz30Teste,valorTeste6,valorTeste7)?"OK":"NOT OK"));
        System.out.println("converterMatrizInteiroParaDouble:" + (test_converterMatrizInteiroParaDouble(matriz33Teste, matriz24Teste) ? "OK" : "NOT OK"));
        System.out.println("transformarEmMatrizInteiros:" + (test_transformarEmMatrizInteiros(matriz24Teste, matriz33Teste) ? "OK" : "NOT OK"));
        System.out.println("obterMatrizesValorEVetoresProprios:" + (test_obterMatrizesValorEVetoresProprios(matriz4Teste, matriz35Teste, matriz34Teste) ? "OK" : "NOT OK"));
        System.out.println("eSimetrica:" + (test_eSimetrica(matriz6Teste) ? "OK" : "NOT OK"));
        System.out.println("verificarValores:" + (test_verificarValores(valorTeste8,valorTeste2) ? "OK" : "NOT OK"));
        System.out.println("validarK:" + (test_validarK(valorTeste9,valorTeste2,valorTeste2) ? "OK" : "NOT OK"));

    }

    public static boolean test_multiplicacaoMatrizes(double[][] matriz1Entrada, double[][] matriz2Entrada, double[][] matrizResultadoEsperado) {

        double[][] matrizRetornada = Operacoes_Matrizes.multiplicarMatrizes(matriz1Entrada, matriz2Entrada);

        return compararMatrizes(matrizRetornada, matrizResultadoEsperado);
    }

    public static boolean test_calcularEAM(double[][] matriz1Entrada, double[][] matriz2Entrada, double resultadoEsperado) {

        double resultadoRetornado = Operacoes_Matrizes.calcularEAM(matriz1Entrada, matriz2Entrada);

        return resultadoRetornado == resultadoEsperado;
    }

    public static boolean test_ordenarMatrizPorValores(double[][] matriz2DEntrada, double[][] matrizResultadoEsperado) {

        double[][] matriz2DEntradaCopia = criarMatrizCopia(matriz2DEntrada);

        double[][] matrizRetornada = Operacoes_Matrizes.ordenarMatrizPorValores(matriz2DEntradaCopia);

        return compararMatrizes(matrizRetornada, matrizResultadoEsperado);
    }

    public static boolean test_obterMatrizOrdenadaValoresProprios(double[][] matrizEntrada, double[][] matrizResultadoEsperado) {

        double[][] matrizRetornada = Operacoes_Matrizes.obterMatrizOrdenadaValoresProprios(matrizEntrada);

        return compararMatrizes(matrizRetornada, matrizResultadoEsperado);
    }


    public static boolean test_ordenarMatrizPorIndice(double[][] matrizEntrada, double[][] matrizResultadoEsperado, int k) {


        double[][] matrizTesteCopia = criarMatrizCopia(matrizEntrada);

        double[][] matrizRetornada = Operacoes_Matrizes.ordenarMatrizPorIndice(matrizTesteCopia, k);

        return compararMatrizes(matrizRetornada, matrizResultadoEsperado);

    }

    public static boolean test_reduzirMatrizValoresP(double[][] matrizEntrada, double[][] matrizResultadoEsperado, int k) {

        double[][] matrizRetornada = Operacoes_Matrizes.reduzirMatrizValoresP(matrizEntrada, k);

        return compararMatrizes(matrizRetornada, matrizResultadoEsperado);
    }

    public static boolean test_reduzirMatrizVetoresP(double[][] matriz1Entrada, double[][] matriz2Entrada, double[][] matrizResultadoEsperado, int k) {

        return compararMatrizes(Operacoes_Matrizes.reduzirMatrizVetoresP(matriz2Entrada, matriz1Entrada, k), matrizResultadoEsperado);

    }

    public static boolean test_obterMatrizesReduzidasValoresEVetoresProprios(double[][][] matrizOriginal,double[][] matrizValoresResultadoEsperado, double[][] matrizVetoresResultadoEsperado, int k) {

        double[][][] matriz3DRetornada = Operacoes_Matrizes.obterMatrizesReduzidasValoresEVetoresProprios(matrizOriginal, k);
        double[][] matrizValoresPropriosRetornada = matriz3DRetornada[1];
        double[][] matrizVetoresPropriosRetornada = matriz3DRetornada[0];

        if (!compararMatrizes(matrizValoresPropriosRetornada,matrizValoresResultadoEsperado))
            return false;

        if (!compararMatrizes(matrizVetoresPropriosRetornada,matrizVetoresResultadoEsperado))
            return false;

        return true;
    }


    public static boolean test_obterTransposta(double[][] matrizEntrada, double[][] matrizResultadoEsperado) {

        return compararMatrizes(Operacoes_Matrizes.obterTransposta(matrizEntrada), matrizResultadoEsperado);
    }

    public static boolean test_obterVetorMedia(double[][] matrizEntrada, double[] vetorResultadoEsperado) {

        return compararArrays(Operacoes_Matrizes.obterVetorMedia(matrizEntrada), vetorResultadoEsperado);

    }

    public static boolean test_obterMatrizPhiBase(double[][] matrizEntrada, double[] vetorEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.obterMatrizPhiBase(matrizEntrada, vetorEntrada), matrizResultadoEsperado);
    }

    public static boolean test_converterVetorEmMatriz(double[] vetorEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.converterVetorEmMatriz(vetorEntrada), matrizResultadoEsperado);
    }

    public static boolean test_normalizarMatriz(double[][] matrizEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.normalizarMatriz(matrizEntrada),matrizResultadoEsperado);
    }

    public static boolean test_obterMatrizNorma(double[][] matrizEntrada, double[] resultadoEsperado){

        return compararArrays(Operacoes_Matrizes.obterMatrizNorma(matrizEntrada),resultadoEsperado);
    }

    public static boolean test_calcularNorma(double[] vetorEntrada,double resultadoEsperado){

        return Operacoes_Matrizes.calcularNorma(vetorEntrada) == resultadoEsperado;
    }

    public static boolean test_preencherMatrizK(double[][] matriz1Entrada, double[][] matriz2Entrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.preencherMatrizK(matriz1Entrada,matriz2Entrada),matrizResultadoEsperado);
    }

    public static boolean test_calcularEAMVetor(double[] vetor1Entrada, double[] vetor2Entrada, double resultadoEsperado){

        return Operacoes_Matrizes.calcularEAMVetor(vetor1Entrada,vetor2Entrada)==resultadoEsperado;
    }

    public static boolean test_somarVetores(double[] vetor1Entrada, double[] vetor2Entrada, double[] resultadoEsperado){

        return compararArrays(Operacoes_Matrizes.somarVetores(vetor1Entrada,vetor2Entrada),resultadoEsperado);
    }

    public static boolean test_subtrairVetores(double[] vetor1Entrada, double[] vetor2Entrada, double[] resultadoEsperado){

        return compararArrays(Operacoes_Matrizes.subtrairVetores(vetor1Entrada,vetor2Entrada),resultadoEsperado);
    }

    public static boolean test_obterProdutoVetorial(double[] vetor1Entrada, double[] vetor2Entrada, double resultadoEsperado){

        return Operacoes_Matrizes.obterProdutoVetorial(vetor1Entrada,vetor2Entrada)==resultadoEsperado;
    }

    public static boolean test_multiplicarMatrizPorVetor(double[][] matrizEntrada, double[] vetorEntrada, double[] vetorResultadoEsperado){

        return compararArrays(Operacoes_Matrizes.multiplicarMatrizPorVetor(matrizEntrada,vetorEntrada),vetorResultadoEsperado);
    }

    public static boolean test_obterMatrizPesosDasImagensTranspostas(double[][] matriz1Entrada, double[][] matriz2Entrada, double[] vetorEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.obterMatrizPesosDasImagensTransposta(matriz1Entrada,matriz2Entrada,vetorEntrada),matrizResultadoEsperado);
    }

    public static boolean test_reconstroiImagem(double[][] matrizEntrada, double[] vetor1Entrada, double[] vetor2Entrada,double[] vetorResultadoEsperado){

        return compararArrays(Operacoes_Matrizes.reconstroiImagem(matrizEntrada,vetor1Entrada,vetor2Entrada),vetorResultadoEsperado);
    }

    public static boolean test_obterVetorPesos(double[] vetor1Entrada, double[][] matrizEntrada, double[] vetor2Entrada, double[] vetorResultadoEsperado){

        return compararArrays(Operacoes_Matrizes.obterVetorPesos(vetor1Entrada,matrizEntrada,vetor2Entrada),vetorResultadoEsperado);
    }

    public static boolean test_obterMatrizVetoresPropriosAAt(double[][] matriz1Entrada, double[][] matriz2Entrada, double[][] matriz1ResultadoEsperado, double[][] matriz2ResultadoEsperado){

        double[][][] matriz3DRetornada = Operacoes_Matrizes.obterMatrizVetoresPropriosAAt(matriz1Entrada,matriz2Entrada);
        double[][] matrizValoresPropriosRetornada = matriz3DRetornada[1];
        double[][] matrizVetoresPropriosRetornada = matriz3DRetornada[0];

        if (!compararMatrizes(matrizValoresPropriosRetornada,matriz1ResultadoEsperado))
            return false;

        if (!compararMatrizes(matrizVetoresPropriosRetornada,matriz2ResultadoEsperado))
            return false;

        return true;
    }

    public static boolean test_obterMatrizImagensReconstruidaTransposta(double[][] matrizEntrada1, double[][] matrizEntrada2, double[] vetorEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.obterMatrizImagensReconstruidaTransposta(matrizEntrada1,matrizEntrada2,vetorEntrada),matrizResultadoEsperado);
    }

    public static boolean test_obterIndiceImagemMaisProxima(double[][] matrizEntrada, double[] vetorEntrada,int valorResultadoEsperado){

        //return (Operacoes_Matrizes.obterIndiceImagemMaisProxima(matrizEntrada)==valorResultadoEsperado);
        return (Operacoes_Matrizes.obterIndiceImagemMaisProxima(vetorEntrada)==valorResultadoEsperado);
    }

    public static boolean test_obterVetorImagem(double[][] matrizEntrada, double[] vetorResultadoEsperado){

        return compararArrays(Operacoes_Matrizes.obterVetorImagem(matrizEntrada), vetorResultadoEsperado);
    }

    public static boolean test_normalizarEigenfaces(double[][] matrizEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.normalizarMatrizNoIntervalo(matrizEntrada),matrizResultadoEsperado);
    }

    public static boolean test_obterMinimoEMaximodeMatriz(double[][] matrizEntrada,double minimo, double maximo){

        double[] vetorMinimoMaximo = Operacoes_Matrizes.obterMinimoEMaximodeMatriz(matrizEntrada);
        double valorMinimo = vetorMinimoMaximo[1];
        double valorMaximo = vetorMinimoMaximo[0];

        if (valorMinimo!=minimo)
            return false;

        if (valorMaximo!=maximo)
            return false;

        return true;
    }

    public static boolean test_converterMatrizInteiroParaDouble(int[][] matrizEntrada, double[][] matrizResultadoEsperado){

        return compararMatrizes(Operacoes_Matrizes.converterMatrizInteiroParaDouble(matrizEntrada),matrizResultadoEsperado);
    }

    public static boolean test_transformarEmMatrizInteiros(double[][] matrizEntrada, int[][] matrizResultadoEsperado){

        return compararMatrizesInt(Operacoes_Matrizes.transformarEmMatrizInteiros(matrizEntrada),matrizResultadoEsperado);
    }

    public static boolean test_obterMatrizesValorEVetoresProprios(double[][] matrizEntrada,double[][] matriz1ResultadoEsperado,double[][] matriz2ResultadoEsperado){

        RealMatrix matriz = MatrixUtils.createRealMatrix(matrizEntrada);

        RealMatrix[] resultado = Operacoes_Matrizes.obterMatrizesValorEVetoresProprios(matriz);

        double[][] matrizVetoresP = resultado[0].getData();
        double[][] matrizValoresP = resultado[1].getData();

        if (!compararMatrizes(matrizValoresP,matriz1ResultadoEsperado))
            return false;

        if (!compararMatrizes(matrizVetoresP,matriz2ResultadoEsperado))
            return false;

        return true;
    }

    public static boolean test_eSimetrica(double[][] matrizEntrada){

        return Validacoes.eSimetrica(matrizEntrada);
    }

    public static boolean test_verificarValores(int valorEntrada1, int valorEntrada2){

        return Validacoes.verificarValores(valorEntrada1,valorEntrada2);
    }

    public static boolean test_validarK(int valorEntrada1, int valorEntrada2, int valorResultadoEsperado){

        return Validacoes.validarK(valorEntrada1,valorEntrada2)==valorResultadoEsperado;
    }

    public static double[][] criarMatrizCopia(double[][] matriz){
        double[][] matrizCopia = new double[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matrizCopia[i][j] = matriz[i][j];
            }
        }
        return matrizCopia;
    }

    public static boolean compararArrays(double[] array1, double[] array2) {
        if (array1.length != array2.length) {
            return false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i]!=array2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compararMatrizes(double[][] matriz1, double[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return false;
        } else {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[0].length; j++) {
                    if (matriz1[i][j]!=matriz2[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean compararMatrizesInt(int[][] matriz1, int[][] matriz2) {
        if (matriz1.length != matriz2.length || matriz1[0].length != matriz2[0].length) {
            return false;
        } else {
            for (int i = 0; i < matriz1.length; i++) {
                for (int j = 0; j < matriz1[0].length; j++) {
                    if (matriz1[i][j]!=matriz2[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
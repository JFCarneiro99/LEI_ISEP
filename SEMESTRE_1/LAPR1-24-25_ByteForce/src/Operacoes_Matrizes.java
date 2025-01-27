import org.apache.commons.math3.linear.EigenDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Operacoes_Matrizes {

    public static double[][] obterMatrizImagensReconstruidaTransposta(double[][] matrizPesosTransposta, double[][] matrizEigenfaces, double[] vetorMedia) {
        double[][] matrizImagensReconstruidas = new double[matrizPesosTransposta.length][matrizEigenfaces.length];
        for (int linha = 0; linha < matrizPesosTransposta.length; linha++) {
            matrizImagensReconstruidas[linha] = reconstroiImagem(matrizEigenfaces, vetorMedia, matrizPesosTransposta[linha]);

        }
        return Operacoes_Matrizes.obterTransposta(matrizImagensReconstruidas);
    }

    public static RealMatrix[] obterMatrizesValorEVetoresProprios(RealMatrix matriz) {

        EigenDecomposition eigenDecomposition = new EigenDecomposition(matriz);

        double[] valoresProprios = eigenDecomposition.getRealEigenvalues();
        RealMatrix matrizValoresProprios = MatrixUtils.createRealDiagonalMatrix(valoresProprios);

        RealMatrix matrizVetoresProprios = eigenDecomposition.getV();

        return new RealMatrix[]{matrizVetoresProprios, matrizValoresProprios};
    }

    public static double[][] construirMatrizDeImagens(String caminhoDiretorio) throws FileNotFoundException {

        File diretorio = new File(caminhoDiretorio);


        File[] imagensCSV = null;
        int[][] matrizImagens;

        if (diretorio.exists() && diretorio.isDirectory()) {
            imagensCSV = diretorio.listFiles(file -> file.isFile() && file.getName().endsWith(".csv"));
        }

        matrizImagens = Operacoes_Matrizes.criarMatrizComAsImagensDoDiretorio(imagensCSV);
        if(matrizImagens == null){
            return null;
        }


        return Operacoes_Matrizes.converterMatrizInteiroParaDouble(matrizImagens);
    }

    public static double[][] converterMatrizInteiroParaDouble(int[][] matrizImagens) {
        double[][] matrizImagensDouble = new double[matrizImagens.length][matrizImagens[0].length];
        for (int i = 0; i < matrizImagens.length; i++) {
            for (int j = 0; j < matrizImagens[0].length; j++) {
                matrizImagensDouble[i][j] = (double) matrizImagens[i][j];
            }
        }
        return matrizImagensDouble;
    }

    public static double[][] obterTransposta(double[][] matriz) {

        double[][] matrizT = new double[matriz[0].length][matriz.length];

        for (int linha = 0; linha < matrizT.length; linha++) {
            for (int coluna = 0; coluna < matrizT[0].length; coluna++) {
                matrizT[linha][coluna] = matriz[coluna][linha];
            }
        }

        return matrizT;
    }

    public static double[][][] obterMatrizesReduzidasValoresEVetoresProprios(double[][][] matriz, int k) {

        double[][] matrizVetoresP = matriz[0];
        double[][] matrizValoresP = matriz[1];


        if (k == matrizValoresP.length)
            return new double[][][]{matrizVetoresP, matrizValoresP};

        double[][] matrizParaSelecionarValoresProprios = ordenarMatrizPorIndice(obterMatrizOrdenadaValoresProprios(matrizValoresP), k);
        //recebe uma matriz de valores proprios ordenados por maior valor absoluto, depois ordena os primeiros k valores por indice

        double[][] matrizVetoresTransposta = obterTransposta(matrizVetoresP);

        return new double[][][]{reduzirMatrizVetoresP(matrizVetoresP, matrizParaSelecionarValoresProprios, k), reduzirMatrizValoresP(matrizParaSelecionarValoresProprios, k)};
    }

    public static double[][] reduzirMatrizValoresP(double[][] matrizIndices, int k) {
        double[][] matrizReduzida = new double[k][k];

        for (int entrada = 0; entrada < k; entrada++) {
            matrizReduzida[entrada][entrada] = matrizIndices[0][entrada];
        }
        return matrizReduzida;
    }

    public static double[][] reduzirMatrizVetoresP(double[][] matrizP, double[][] ordem, int k) {
        double[][] matrizReduzida = new double[matrizP.length][k];

        int indice;

        for (int coluna = 0; coluna < k; coluna++) {
            for (int linha = 0; linha < matrizP.length; linha++) {
                indice = (int) ordem[1][coluna];
                matrizReduzida[linha][coluna] = matrizP[linha][indice];
            }
        }
        return matrizReduzida;
    }

    public static double[][] obterMatrizOrdenadaValoresProprios(double[][] matrizValoresProprios) {
        double[][] matriz2Linhas = new double[2][matrizValoresProprios.length];

        for (int i = 0; i < matrizValoresProprios.length; i++) {
            matriz2Linhas[0][i] = matrizValoresProprios[i][i];
            matriz2Linhas[1][i] = i;
        }
        ordenarMatrizPorValores(matriz2Linhas);

        return matriz2Linhas;
    }

    public static double[][] ordenarMatrizPorIndice(double[][] matriz, int k) {
        for (int coluna = 0; coluna < k; coluna++) {
            for (int proximaColuna = coluna + 1; proximaColuna < k; proximaColuna++) {
                if (matriz[1][coluna] > matriz[1][proximaColuna]) {
                    double auxiliar = matriz[0][coluna];
                    matriz[0][coluna] = matriz[0][proximaColuna];
                    matriz[0][proximaColuna] = auxiliar;

                    auxiliar = matriz[1][coluna];
                    matriz[1][coluna] = matriz[1][proximaColuna];
                    matriz[1][proximaColuna] = auxiliar;
                }
            }
        }
        return matriz;
    }

    public static double[][] ordenarMatrizPorValores(double[][] matriz) {
        int n = matriz[0].length;

        for (int coluna = 0; coluna < n - 1; coluna++) {
            for (int proximaColuna = coluna + 1; proximaColuna < n; proximaColuna++) {
                if (matriz[0][coluna] < matriz[0][proximaColuna]) {
                    double valorAuxiliar = matriz[0][coluna];
                    matriz[0][coluna] = matriz[0][proximaColuna];
                    matriz[0][proximaColuna] = valorAuxiliar;

                    valorAuxiliar = matriz[1][coluna];
                    matriz[1][coluna] = matriz[1][proximaColuna];
                    matriz[1][proximaColuna] = valorAuxiliar;
                }
            }
        }
        return matriz;
    }

    public static double[][] preencherMatrizK(double[][] matrizVetoresP, double[][] matrizValoresP) {

        double[][] matrizPxD = multiplicarMatrizes(matrizVetoresP, matrizValoresP);
        double[][] matrizPTransposta = Operacoes_Matrizes.obterTransposta(matrizVetoresP);
        double[][] matrizAK = multiplicarMatrizes(matrizPxD, matrizPTransposta);

        return matrizAK;
    }

    public static double[][] multiplicarMatrizes(double[][] matriz1, double[][] matriz2) {

        double[][] matrizM = new double[matriz1.length][matriz2[0].length];

        for (int k = 0; k < matriz1.length; k++) {
            for (int i = 0; i < matriz2[0].length; i++) {
                double produtoVetorial = 0;
                for (int j = 0; j < matriz2.length; j++) {
                    produtoVetorial += matriz1[k][j] * matriz2[j][i];
                }
                matrizM[k][i] = produtoVetorial;
            }
        }
        return matrizM;
    }

    public static double calcularEAM(double[][] matrizA, double[][] matrizAK) {
        double erro = 0;
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[1].length; j++) {
                erro += Math.abs(matrizA[i][j] - matrizAK[i][j]);
            }
        }
        return ((double) 1 / (matrizAK.length * matrizAK[0].length)) * erro;
    }

    public static double calcularEAMVetor(double[] vetorOriginal, double[] vetork) {
        double erro = 0;

        for (int j = 0; j < vetorOriginal.length; j++) {
            erro += Math.abs(vetorOriginal[j] - vetork[j]);
        }

        return ((double) 1 / (vetork.length) * erro);
    }

    public static double[][] converterVetorEmMatriz(double[] vetor) {
        int dimensaoMatriz = (int) Math.sqrt(vetor.length);
        double[][] matriz = new double[dimensaoMatriz][dimensaoMatriz];
        int indice = 0;
        for (int i = 0; i < dimensaoMatriz; i++) {
            for (int j = 0; j < dimensaoMatriz; j++) {
                matriz[i][j] = vetor[indice++];
            }
        }
        return matriz;
    }

    public static double[][] obterMatrizPhiBase(double[][] matriz, double[] vetorMedia) {
        double[][] matrizPhiBase = new double[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matrizPhiBase[j][i] = matriz[j][i] - vetorMedia[j];
            }
        }

        return matrizPhiBase;
    }

    public static double[] obterVetorMedia(double[][] matriz) {
        double[] vetorMedia = new double[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            int somaDaLinha = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                somaDaLinha += matriz[i][j];
            }
            vetorMedia[i] = (double) somaDaLinha / matriz[0].length;
        }

        return vetorMedia;
    }

    public static void preencherMatrizImagens(int[][] matrizImagens, int[][] matrizTempDoFicheiro, int coluna) {

        //A matriz temp vai passar  de linha em linha
        int indice = 0;
        for (int i = 0; i < matrizTempDoFicheiro.length; i++) {
            for (int j = 0; j < matrizTempDoFicheiro[i].length; j++) {
                matrizImagens[indice++][coluna] = matrizTempDoFicheiro[i][j];
            }
        }
    }

    public static int calcularDimensaoMatriz (File ficheiro) throws FileNotFoundException {
        int dimensao = 0;
        Scanner sc = new Scanner(ficheiro);
        String linha = sc.nextLine().trim();
        dimensao = linha.split(",").length;
        sc.close();
        return dimensao;
    }

    public static int[][] criarMatrizComAsImagensDoDiretorio(File[] imagens) throws FileNotFoundException {

        int tamanhoDasMatrizes = 0;
        int[][] matrizImagens = null;
        int[][] matrizTempDoFicheiro = null;
        for (int imagem = 0; imagem < imagens.length; imagem++) {
            if (!Validacoes.validarMatrizDoFicheiro1(imagens[imagem])) {
                return null;
            }

            if (imagem == 0) {
                tamanhoDasMatrizes = Operacoes_Matrizes.calcularDimensaoMatriz(imagens[imagem]);

                matrizImagens = new int[tamanhoDasMatrizes * tamanhoDasMatrizes][imagens.length];

                matrizTempDoFicheiro = new int[tamanhoDasMatrizes][tamanhoDasMatrizes];

                Input.preencherMatrizDeUmFicheiro(imagens[imagem], matrizTempDoFicheiro);

                preencherMatrizImagens(matrizImagens, matrizTempDoFicheiro, imagem);

            } else {
                if (Operacoes_Matrizes.calcularDimensaoMatriz(imagens[imagem]) != tamanhoDasMatrizes) {
                    System.out.printf("Erro: As imagens não têm a mesma dimensão!");
                    return null;
                }

                Input.preencherMatrizDeUmFicheiro(imagens[imagem], matrizTempDoFicheiro);

                preencherMatrizImagens(matrizImagens, matrizTempDoFicheiro, imagem);
            }

        }

        return matrizImagens;
    }

    public static double[][] normalizarMatriz(double[][] matriz) {

        double[] matrizNorma = obterMatrizNorma(matriz);

        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            for (int linha = 0; linha < matriz.length; linha++) {
                matriz[linha][coluna] = matriz[linha][coluna] / matrizNorma[coluna];
            }
        }

        return matriz;
    }

    public static double[] obterMatrizNorma(double[][] matriz) {
        double[] matrizNorma = new double[matriz[0].length];
        for (int colunas = 0; colunas < matriz[0].length; colunas++) {

            double[] vetorColuna = new double[matriz.length];

            for (int linha = 0; linha < matriz.length; linha++) {
                vetorColuna[linha] = matriz[linha][colunas];
            }
            matrizNorma[colunas] = calcularNorma(vetorColuna);
        }
        return matrizNorma;
    }

    public static double calcularNorma(double[] vetor) {
        double norma = 0;
        for (int i = 0; i < vetor.length; i++) {
            norma += Math.pow(vetor[i], 2);
        }
        return Math.sqrt(norma);
    }

    public static double[] reconstroiImagem(double[][] matrizEigenfaces, double[] media, double[] vetorPesos) {
        if (matrizEigenfaces[0].length != vetorPesos.length || media.length != matrizEigenfaces.length || media.length == 0 || vetorPesos.length == 0)
            return null;
        return somarVetores(media, multiplicarMatrizPorVetor(matrizEigenfaces, vetorPesos));
    }

    public static double[][] obterMatrizPesosDasImagensTransposta(double[][] matrizImagensBase, double[][] matrizEigenfaces, double[] vetorMedia) {
        double[][] matrizImagensBaseTransposta = Operacoes_Matrizes.obterTransposta(matrizImagensBase);
        double[][] matrizPesosDasImagensBaseTransposta = new double[matrizImagensBase[0].length][matrizEigenfaces.length];

        for (int imagem = 0; imagem < matrizImagensBaseTransposta.length; imagem++) {
            matrizPesosDasImagensBaseTransposta[imagem] = obterVetorPesos(matrizImagensBaseTransposta[imagem], matrizEigenfaces, vetorMedia);
        }
        return matrizPesosDasImagensBaseTransposta;
    }

    public static double[] multiplicarMatrizPorVetor(double[][] matriz, double[] vetor) {
        if (vetor.length != matriz[0].length || vetor.length == 0)
            return null;

        double[] vetorRes = new double[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            vetorRes[i] = obterProdutoVetorial(matriz[i], vetor);
        }
        return vetorRes;
    }

    public static double[] somarVetores(double[] vetorA, double[] vetorB) {
        if (vetorB.length != vetorA.length || vetorA.length == 0)
            return null;

        double[] vetorSoma = new double[vetorA.length];

        for (int i = 0; i < vetorA.length; i++) {
            vetorSoma[i] = vetorA[i] + vetorB[i];
        }

        return vetorSoma;
    }

    public static double[] subtrairVetores(double[] vetorA, double[] vetorB) {
        if (vetorB.length != vetorA.length || vetorA.length == 0)
            return null;

        double[] vetorSub = new double[vetorA.length];

        for (int i = 0; i < vetorA.length; i++) {
            vetorSub[i] = vetorA[i] - vetorB[i];
        }

        return vetorSub;
    }

    public static double obterProdutoVetorial(double[] vetorA, double[] vetorB) {
        if (vetorB.length != vetorA.length || vetorA.length == 0)
            return 0;

        double produtoVetorial = 0;

        for (int i = 0; i < vetorA.length; i++) {
            produtoVetorial += vetorA[i] * vetorB[i];
        }
        return produtoVetorial;
    }

    public static double[] obterVetorPesos(double[] vetorDaImagem, double[][] matrizEigenfaces, double[] vetorMedia) {
        if (vetorDaImagem.length != vetorMedia.length || vetorDaImagem.length != matrizEigenfaces.length || vetorDaImagem.length == 0)
            return null;

        double[] vetorPhi = subtrairVetores(vetorDaImagem, vetorMedia);
        double[][] matrizEigenfacesTransposta = Operacoes_Matrizes.obterTransposta(matrizEigenfaces);

        return multiplicarMatrizPorVetor(matrizEigenfacesTransposta, vetorPhi);
    }

    public static double[][][] obterMatrizVetoresPropriosAAt(double[][] matrizPhiA, double[][] matrizAtA) {

        RealMatrix matriz = MatrixUtils.createRealMatrix(matrizAtA);

        RealMatrix[] resultado = Operacoes_Matrizes.obterMatrizesValorEVetoresProprios(matriz);

        double[][] matrizVetoresP = resultado[0].getData();
        double[][] matrizValoresP = resultado[1].getData();

        double[][] matrizVetoresPropriosAAt = Operacoes_Matrizes.multiplicarMatrizes(matrizPhiA, matrizVetoresP);


        return new double[][][]{matrizVetoresPropriosAAt, matrizValoresP};
    }

    public static int[][] transformarEmMatrizInteiros(double[][] matrizImagensReconstruida) {
        int[][] matrizImagensReconstruidaInt = new int[matrizImagensReconstruida.length][matrizImagensReconstruida[0].length];
        for (int i = 0; i < matrizImagensReconstruida.length; i++) {
            for (int j = 0; j < matrizImagensReconstruida[0].length; j++) {
                matrizImagensReconstruidaInt[i][j] = (int) Math.round(matrizImagensReconstruida[i][j]);
            }
        }
        return matrizImagensReconstruidaInt;
    }

    public static double[] calcularDistanciaEuclidiana (double[][] matrizVetoresPesosTransposta, double[] vetorPesosImagemACompararTransposta) {
        double [] distanciasEuclidianas = new double[matrizVetoresPesosTransposta.length];
        for (int i = 0; i < matrizVetoresPesosTransposta.length; i++){
            distanciasEuclidianas[i] = Operacoes_Matrizes.calcularNorma(Operacoes_Matrizes.subtrairVetores(matrizVetoresPesosTransposta[i], vetorPesosImagemACompararTransposta));
        }
        return distanciasEuclidianas;
    }

    public static int obterIndiceImagemMaisProxima(double[] distanciasEuclidianas) {

        int indiceImagemMaisProxima = 0;
        for (int i = 1; i < distanciasEuclidianas.length; i++) {

            if (distanciasEuclidianas[i] < distanciasEuclidianas[indiceImagemMaisProxima]) {
                indiceImagemMaisProxima = i;
            }

        }
        return indiceImagemMaisProxima;
    }

    public static double[][] construirMatrizDaImagemAcomparar(String ficheiroEntrada) throws FileNotFoundException {

        File ficheiro = new File(ficheiroEntrada);

        if(!Validacoes.validarMatrizDoFicheiro1(ficheiro)){
            return null;
        }

        int dimensao = Operacoes_Matrizes.calcularDimensaoMatriz(ficheiro);

        int[][] matrizImagemACompararInt = new int[dimensao][dimensao];

        Input.preencherMatrizDeUmFicheiro(ficheiro, matrizImagemACompararInt);

        double[][] matrizImagemAComparar = new double[matrizImagemACompararInt.length][matrizImagemACompararInt[0].length];

        for (int i = 0; i < matrizImagemACompararInt.length; i++) {
            for (int j = 0; j < matrizImagemACompararInt[0].length; j++) {
                matrizImagemAComparar[i][j] = matrizImagemACompararInt[i][j];
            }
        }
        return matrizImagemAComparar;
    }

    public static double[] obterVetorImagem(double[][] matrizImagemAComparar) {
        double[] vetorImagemAComparar = new double[matrizImagemAComparar.length * matrizImagemAComparar[0].length];
        int indice = 0;
        for (int i = 0; i < matrizImagemAComparar.length; i++) {
            for (int j = 0; j < matrizImagemAComparar[0].length; j++) {
                vetorImagemAComparar[indice++] = matrizImagemAComparar[i][j];
            }
        }
        return vetorImagemAComparar;
    }

    public static double[][] normalizarMatrizNoIntervalo(double[][] matriz) {
        double[][] matrizNormalizada = new double[matriz.length][matriz[0].length];

        double[] extremos = obterMinimoEMaximodeMatriz(matriz);

        double valorMinimo = extremos[0];
        double valorMaximo = extremos[1];
        double valorDiferenca = Math.abs(valorMaximo - valorMinimo);

        if (valorMinimo >= 0 && valorMaximo <= 255) {
            return null;

        } else {
            for (int linha = 0; linha < matrizNormalizada.length; linha++) {
                for (int coluna = 0; coluna < matrizNormalizada[0].length; coluna++) {
                    matrizNormalizada[linha][coluna] = (matriz[linha][coluna] - valorMinimo) * Validacoes.VALORMAX_PIXEL / valorDiferenca;
                }
            }
        }

        return matrizNormalizada;
    }

    public static double[] obterMinimoEMaximodeMatriz(double[][] matriz) {
        double minimo = 0;
        double maximo = 0;

        for (int linhas = 0; linhas < matriz.length; linhas++) {
            for (int colunas = 0; colunas < matriz[0].length; colunas++) {
                if (matriz[linhas][colunas] > maximo || (linhas == 0 && colunas == 0))
                    maximo = matriz[linhas][colunas];

                if (matriz[linhas][colunas] < minimo || (linhas == 0 && colunas == 0))
                    minimo = matriz[linhas][colunas];
            }
        }
        return new double[]{minimo, maximo};
    }

    public static double [] obterVetorPesosAleatorio(double [][] matrizValoresProprios){
        double[] vetorPesosAleatorio = new double[matrizValoresProprios.length];
        double epslon = 0.0000001;

        for (int i = 0; i < vetorPesosAleatorio.length; i++) {
            double limit = Math.sqrt(Math.abs(matrizValoresProprios[i][i]))-epslon;

            vetorPesosAleatorio[i] = Math.random() * 2 * limit - limit;

        }
        return vetorPesosAleatorio;
    }
}

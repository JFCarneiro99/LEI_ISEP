import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NA_1232061_1232094 {
    public static final int MAX_AUTONOMIA = 100;
    public static final int X = 8;
    public static final double CUSTO_RECARGA_EUROS = 5.5;

    public static void main(String[] args) throws FileNotFoundException {
        int[][] matrizPlaneamento;
        int[] matrizKmAPercorrerPorVeiculo;
        double[][] matrizCargaBateriasFimDoDia;
        int[][] matrizQuantidadeCargasPorDia;
        double[] matrizMediasDeslocacoesDiarias;
        boolean[] matrizDeslocacoesSempreAcimaDaMedia;
        int[] matrizVeiculoDePrevencaoPorDia;
        int[] matrizCarregamentosConsecutivos;

        //a)zé
        matrizPlaneamento = preencherMatrizPlaneamento() ;
        System.out.println("a) planeamento (km/dia/veículo)");
        visualizarInformacaoPlaneamento(matrizPlaneamento);

        //b)Jorge
        matrizKmAPercorrerPorVeiculo = calcularKmAPercorrerPorVeiculo(matrizPlaneamento);
        System.out.println("b) total de km a percorrer");
        visualizarKmAPercorrerPorVeiculo(matrizKmAPercorrerPorVeiculo);

        //c)Zé
        matrizQuantidadeCargasPorDia = obterMatrizQuantidadeCargas(matrizPlaneamento);
        System.out.println("c) recargas das baterias");
        visualizarInformacaoPlaneamento(matrizQuantidadeCargasPorDia);

        //d)Jorge
        matrizCargaBateriasFimDoDia = obterMatrizNivelCarga(matrizPlaneamento);
        System.out.println("d) carga das baterias");
        visulizarCargaDeCadaVeiculoAoFimDoDia(matrizCargaBateriasFimDoDia);

        //e)Jorge
        matrizMediasDeslocacoesDiarias = calcularMediaDeslocacoesDiaria(matrizPlaneamento);

        System.out.println("e) média de km diários da frota");
        visualizarMediaKmPercorridosDaFrotaPorDia(matrizMediasDeslocacoesDiarias);

        //f)Jorge
        matrizDeslocacoesSempreAcimaDaMedia = determinarVeiculosComDeslocacoesDiariasAcimaDaFrota(matrizPlaneamento, matrizMediasDeslocacoesDiarias);
        System.out.println("f) deslocações sempre acima da média diária");
        mostrarVeiculosSempreAcimaDaMedia(matrizDeslocacoesSempreAcimaDaMedia);

        //g)Zé
        matrizCarregamentosConsecutivos = obterMatrizCarregamentosConsecutivos(matrizQuantidadeCargasPorDia);
        visualizarMaiorCarregamentoConsecutivo(matrizCarregamentosConsecutivos);

        //h)Zé
        visualizarDiaCarregamentoMaisTardio(obterDiaMaisTardioCarregamento(matrizQuantidadeCargasPorDia));

        //i)Zé
        visualizarValorCarregamentosSemanalTotal(obterTotalCarregamentosSemanais(matrizQuantidadeCargasPorDia));

        //j)Jorge
        matrizVeiculoDePrevencaoPorDia = obterMatrizPervencaoDiaria(matrizPlaneamento, matrizCargaBateriasFimDoDia);
        visualizarVeiculoDePrevencaoNoDiaX(matrizVeiculoDePrevencaoPorDia, X);
    }

    private static void visualizarVeiculoDePrevencaoNoDiaX(int[] matrizVeiculoDePrevencaoPorDia, int dia) {
        System.out.printf("j) veículo de prevenção no dia <%d> : V%d%n", dia, matrizVeiculoDePrevencaoPorDia[dia]);
        System.out.printf("%n");
    }

    private static int[] obterMatrizPervencaoDiaria(int[][] matrizPlaneamento, double[][] cargaBateriasFimDoDia) {
        int[] matrizVeiculoDePrevencaoDia = new int[matrizPlaneamento[0].length];
        for (int dia = 0; dia < matrizPlaneamento[0].length; dia++) {
            int veiculoComMenosUso = 0;
            int MenorKm = matrizPlaneamento[0][dia];
            for (int carro = 1; carro < matrizPlaneamento.length; carro++) {
                if (matrizPlaneamento[carro][dia] == MenorKm) {
                    veiculoComMenosUso = determinarQualTemMaisBateria(cargaBateriasFimDoDia, dia, veiculoComMenosUso, carro);
                } else if (matrizPlaneamento[carro][dia] <= MenorKm) {
                    MenorKm = matrizPlaneamento[carro][dia];
                    veiculoComMenosUso = carro;
                }
            }
            matrizVeiculoDePrevencaoDia[dia] = veiculoComMenosUso;
        }
        return matrizVeiculoDePrevencaoDia;
    }

    private static int determinarQualTemMaisBateria(double[][] cargaBateriasFimDoDia, int dia, int carro1, int carro2) {
        if (cargaBateriasFimDoDia[carro1][dia] < cargaBateriasFimDoDia[carro2][dia]) {
            return carro2;
        } else {
            return carro1;
        }
    }

    private static void mostrarVeiculosSempreAcimaDaMedia(boolean[] matrizDeslocacoesSempreAcimaDaMedia) {
        int quantidadeVeiculos = contarVeiculos(matrizDeslocacoesSempreAcimaDaMedia);
        if ( quantidadeVeiculos == 0 ) {
            System.out.printf("<%d> veículos" , quantidadeVeiculos);
        }
        else {
            System.out.printf("<%d> veículos : ", quantidadeVeiculos);
            for (int carro = 0; carro < matrizDeslocacoesSempreAcimaDaMedia.length; carro++) {
                if (matrizDeslocacoesSempreAcimaDaMedia[carro]) {
                    System.out.printf("[V%d]", carro);
                }
            }
        }
        System.out.printf("%n%n");
    }

    private static int contarVeiculos(boolean[] matrizDeslocacoesSempreAcimaDaMedia) {
        int quantidadeVeiculos = 0;
        for (int i = 0; i < matrizDeslocacoesSempreAcimaDaMedia.length; i++) {
            if (matrizDeslocacoesSempreAcimaDaMedia[i]) {
                quantidadeVeiculos++;
            }
        }
        return quantidadeVeiculos;
    }

    private static boolean[] determinarVeiculosComDeslocacoesDiariasAcimaDaFrota(int[][] matrizPlaneamento, double[] matrizMediasDeslocacoesDiarias) {
        boolean[] sempreAcimaDaMedia = new boolean[matrizPlaneamento.length];
        for (int carro = 0; carro < matrizPlaneamento.length; carro++) {
            sempreAcimaDaMedia[carro] = verificarSeDeslocacaoDiariaSempreAcimaDaMedia(matrizPlaneamento[carro], matrizMediasDeslocacoesDiarias);
        }
        return sempreAcimaDaMedia;
    }

    private static boolean verificarSeDeslocacaoDiariaSempreAcimaDaMedia(int[] matrizCarro, double[] matrizMediasDeslocacoesDiarias) {
        for (int dia = 0; dia < matrizCarro.length; dia++) {
            if (matrizCarro[dia] <= matrizMediasDeslocacoesDiarias[dia])
                return false;
        }
        return true;
    }

    private static void visualizarMediaKmPercorridosDaFrotaPorDia(double[] matrizMediasDeslocacoesDiarias) {
        imprimirCabecalho(matrizMediasDeslocacoesDiarias.length);
        System.out.print("km  :");
        for (int dia = 0; dia < matrizMediasDeslocacoesDiarias.length; dia++) {
            System.out.printf("%8.1f", matrizMediasDeslocacoesDiarias[dia]);
        }
        System.out.printf("%n%n");
    }

    private static double[] calcularMediaDeslocacoesDiaria(int[][] matrizPlaneamento) {
        double[] mediaDiaria = new double[matrizPlaneamento[0].length];
        for (int dia = 0; dia < matrizPlaneamento[0].length; dia++) {
            double somaKmDia = 0;
            for (int nCarro = 0; nCarro < matrizPlaneamento.length; nCarro++) {
                somaKmDia += matrizPlaneamento[nCarro][dia];
            }
            if (somaKmDia == 0) {
                mediaDiaria[dia] = 0;
            } else {
                mediaDiaria[dia] = somaKmDia / matrizPlaneamento.length;
            }
        }
        return mediaDiaria;
    }

    private static void visulizarCargaDeCadaVeiculoAoFimDoDia(double[][] cargaBateriasFimDoDia) {
        imprimirCabecalho(cargaBateriasFimDoDia[0].length);
        for (int carro = 0; carro < cargaBateriasFimDoDia.length; carro++) {
            System.out.printf("V%d  :", carro);
            for (int dia = 0; dia < cargaBateriasFimDoDia[carro].length; dia++) {
                System.out.printf("%7.1f%%", cargaBateriasFimDoDia[carro][dia]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }

    private static int[][] obterMatrizQuantidadeCargas(int[][] matrizPlaneamento) {

        int[][] matrizQuantidadeCargas = new int[matrizPlaneamento.length][matrizPlaneamento[0].length];
        int quantidadeCargas = 0;
        //int cargaTotal = 100; alterei por MAX_Autonomia
        int quantidadeDiaSeguinte = 0;
        int bateriaNecessariaDia;

        for (int carro = 0; carro < matrizPlaneamento.length; carro++) {
            int bateria = MAX_AUTONOMIA;

            for (int dia = 0; dia < matrizPlaneamento[0].length; dia++) {

                bateriaNecessariaDia = matrizPlaneamento[carro][dia];

                while (bateriaNecessariaDia >= bateria) {
                    bateria = bateria + MAX_AUTONOMIA;
                    quantidadeCargas++;
                }
                if (bateriaNecessariaDia < bateria) {
                    quantidadeDiaSeguinte = bateria - (bateriaNecessariaDia);
                }
                bateria = quantidadeDiaSeguinte;
                matrizQuantidadeCargas[carro][dia] = quantidadeCargas;
                quantidadeCargas = 0;
            }
        }
        return matrizQuantidadeCargas;
    }

    private static double[][] obterMatrizNivelCarga(int[][] matrizPlaneamento) {
        double[][] matrizCargas = new double[matrizPlaneamento.length][matrizPlaneamento[0].length];
        for (int carro = 0; carro < matrizPlaneamento.length; carro++) {
            int carga = MAX_AUTONOMIA;
            for (int dia = 0; dia < matrizPlaneamento[0].length; dia++) {
                carga -= matrizPlaneamento[carro][dia];
                if (carga <= 0) {
                    do {
                        carga += MAX_AUTONOMIA;
                    } while (carga <= 0);
                }
                matrizCargas[carro][dia] = carga;
            }
        }
        return matrizCargas;
    }

    private static void imprimirCabecalho(int qtDias) {

        System.out.print("dia : ");
        for (int dia = 0; dia < qtDias; dia++) {
            System.out.printf("%7d ", dia);
        }
        System.out.printf("%n");
        System.out.print("----|-");
        for (int carro = 0; carro < qtDias; carro++) {
            System.out.print("-------|");
        }
        System.out.printf("%n");
    }

    private static void visualizarKmAPercorrerPorVeiculo(int[] kmAPercorrerPorVeiculo) {

        for (int carro = 0; carro < kmAPercorrerPorVeiculo.length; carro++) {
            System.out.printf("V%d :%8d km%n", carro, kmAPercorrerPorVeiculo[carro]);
        }
        System.out.printf("%n");
    }

    private static int[] calcularKmAPercorrerPorVeiculo(int[][] matrizPlaneamento) {
        int[] kmPorVeiculo = new int[matrizPlaneamento.length];

        for (int carro = 0; carro < matrizPlaneamento.length; carro++) {
            kmPorVeiculo[carro] = somarLinhaArray(matrizPlaneamento, carro);
        }
        return kmPorVeiculo;
    }

    private static int somarLinhaArray(int[][] planeamento, int carro) {
        int soma = 0;
        for (int coluna = 0; coluna < planeamento[carro].length; coluna++) {
            soma += planeamento[carro][coluna];
        }
        return soma;
    }

    private static void visualizarInformacaoPlaneamento(int[][] matriz) {

        imprimirCabecalho(matriz[0].length);
        for (int carro = 0; carro < matriz.length; carro++) {
            System.out.printf("V%d  : ", carro);
            for (int dias = 0; dias < matriz[carro].length; dias++) {
                System.out.printf("%7d ", matriz[carro][dias]);
            }
            System.out.printf("%n");
        }
        System.out.printf("%n");
    }

    private static int[][] preencherMatrizPlaneamento() throws FileNotFoundException {

        File ficheiro = new File("ficheiro5.txt");
        Scanner sc = new Scanner(ficheiro);

        String informacaoPlaneamento = sc.nextLine();
        int numeroCarros = sc.nextInt();
        int numeroDias = sc.nextInt();
        sc.nextLine();

        int[][] matriz = new int[numeroCarros][numeroDias];

        for (int carro = 0; carro < matriz.length; carro++) {
            for (int dia = 0; dia < matriz[carro].length; dia++) {
                matriz[carro][dia] = sc.nextInt();

            }
        }

        sc.close();
        return matriz;
    }

    private static int[] obterMatrizCarregamentosConsecutivos(int[][] matrizQuantidadeCargasDia) {

        int[] matrizQuantidadeCargasConsecutivas = new int[matrizQuantidadeCargasDia.length];

        for (int carro = 0; carro < matrizQuantidadeCargasDia.length; carro++) {
            int quantidadeCargasConsecutivas = 0;
            int maiorQuantidadeCarregamentosConsecutivos = 0;
            for (int dia = 0; dia < matrizQuantidadeCargasDia[carro].length; dia++) {

                if (matrizQuantidadeCargasDia[carro][dia] > 0) {
                    quantidadeCargasConsecutivas++;
                    if (maiorQuantidadeCarregamentosConsecutivos <= quantidadeCargasConsecutivas) {
                        maiorQuantidadeCarregamentosConsecutivos = quantidadeCargasConsecutivas;
                    }
                } else
                    quantidadeCargasConsecutivas = 0;
            }
            if (maiorQuantidadeCarregamentosConsecutivos <= 1) {
                maiorQuantidadeCarregamentosConsecutivos = 0;
            }
            matrizQuantidadeCargasConsecutivas[carro] = maiorQuantidadeCarregamentosConsecutivos;
        }
        return matrizQuantidadeCargasConsecutivas;
    }

    private static void visualizarMaiorCarregamentoConsecutivo(int[] matrizQuantidadeCargasConsecutivas) {
        int maiorNumeroCarregamentosSeguidos = 0;
        for (int carro = 0; carro < matrizQuantidadeCargasConsecutivas.length; carro++) {

            if (matrizQuantidadeCargasConsecutivas[carro] > maiorNumeroCarregamentosSeguidos) {
                maiorNumeroCarregamentosSeguidos = matrizQuantidadeCargasConsecutivas[carro];
                carro = maiorNumeroCarregamentosSeguidos;
            }
        }

        if (maiorNumeroCarregamentosSeguidos == 0) {
            System.out.printf("g) nenhum carro necessitou de carregamento em dias conscutivos%n%n");
        }

        else{
            System.out.printf("g) veículos com mais dias consecutivos a necessitar de recarga%n<%d> dia(s) consecutivo(s), veículo(s) : ", maiorNumeroCarregamentosSeguidos);

            for (int carro = 0; carro < matrizQuantidadeCargasConsecutivas.length; carro++) {
                if (matrizQuantidadeCargasConsecutivas[carro] == maiorNumeroCarregamentosSeguidos) {
                    System.out.printf("[V%d]", carro);
                }
            }
            System.out.printf("%n%n");
        }
    }

    private static int obterDiaMaisTardioCarregamento(int[][] matrizQuantidadeCargasPorDia) {

        int primeiroDiaCarregamento = -1;

        int quantidadeCarros = matrizQuantidadeCargasPorDia.length;
        int quantidadeDias = matrizQuantidadeCargasPorDia[0].length;
        for (int dia = 0; dia < quantidadeDias; dia++) {
            if (compararDiasCarregamento(matrizQuantidadeCargasPorDia, dia, quantidadeCarros)) {
                return dia;
            }
        }
        return primeiroDiaCarregamento;
    }

    private static boolean compararDiasCarregamento(int[][] matrizQuantidadeCargasPorDia, int dia, int carro) {
        for (int carroComparar = 0; carroComparar < carro; carroComparar++) {
            if (matrizQuantidadeCargasPorDia[carroComparar][dia] == 0) {
                return false;
            }
        }
        return true;
    }

    private static void visualizarDiaCarregamentoMaisTardio(int dia) {
        System.out.printf("h) dia mais tardio em que todos os veículos necessitam de recarregar <%d>%n%n", dia);
    }

    private static int obterTotalCarregamentosSemanais(int[][] matrizCargaBateriasFimDoDia) {
        int totalCarregamentos = 0;
        for (int carro = 0; carro < matrizCargaBateriasFimDoDia.length; carro++) {
            for (int dia = 0; dia < matrizCargaBateriasFimDoDia[carro].length; dia++) {
                totalCarregamentos = totalCarregamentos + matrizCargaBateriasFimDoDia[carro][dia];
            }
        }
        return totalCarregamentos;
    }

    private static void visualizarValorCarregamentosSemanalTotal(int totalCarregamentos) {
        double custoCarregamentoSemanal = totalCarregamentos * CUSTO_RECARGA_EUROS;
        System.out.printf("i) custo das recargas da frota <%.2f €> %n%n", custoCarregamentoSemanal);
    }

}
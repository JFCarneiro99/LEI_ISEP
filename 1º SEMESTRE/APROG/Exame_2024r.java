public class Exame_2024r {

    static final int PILOTOS = 8;
    static final int CORRIDAS = 6;
    static final int[] PONTUACAO = {10, 8, 5, 2, 1};

    public static void main(String[] args) {

        int[][] classificacoes = lerClassificacoes();
        if (saoClassificacoesCorretas(classificacoes)) {

            int[] pontosTotaisDosPilotos = obterPontuacaoTotalDosPilotos(classificacoes, PONTUACAO);
            mostrarPilotosEmPrimeiroLugar(pontosTotaisDosPilotos);
        }
    }

    public static boolean saoClassificacoesCorretas(int[][] classificacoes) {

        for (int j = 0; j < CORRIDAS; j++) {
            boolean[] posicoes = new boolean[PILOTOS + 1];
            for (int i = 0; i < PILOTOS; i++) {
                int classificacao = classificacoes[i][j];
                if (classificacao < 1 || classificacao > PILOTOS || posicoes[classificacao]) {
                    return false;
                }
                posicoes[classificacao] = true;
            }
        }
        return true;
    }

    public static int[] obterPontuacaoTotalDosPilotos(int[][] classificacoes, int[] pontuacao) {
        int[] totalPontos = new int[PILOTOS];
        for (int i = 0; i < PILOTOS; i++) {
            for (int j = 0; j < CORRIDAS; j++) {
                int posicao = classificacoes[i][j] - 1;
                if (posicao < pontuacao.length) {
                    totalPontos[i] += pontuacao[posicao];
                }
            }
        }
        return totalPontos;

    }

    public static void mostrarPilotosEmPrimeiroLugar(int[] pontosTotaisDosPilotos) {
        int maxPontuacao = 0;
        for (int pontos : pontosTotaisDosPilotos) {
            if (pontos > maxPontuacao) {
                maxPontuacao = pontos;
            }
        }
        System.out.print("Pontuação máxima=" + maxPontuacao + " :Pilotos=");
        for (int i = 0; i < pontosTotaisDosPilotos.length; i++) {
            if (pontosTotaisDosPilotos[i] == maxPontuacao) {
                System.out.print("[" + (i + 1) + "]");
            }
        }
        System.out.println();
    }


    public static int[][] lerClassificacoes() {
        return new int[][]{
                {1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8},
                {4, 5, 6, 7, 8, 1},
                {5, 6, 7, 8, 1, 2},
                {6, 7, 8, 1, 2, 3},
                {7, 8, 1, 2, 3, 4},
                {8, 1, 2, 3, 4, 5}
        };
    }
}



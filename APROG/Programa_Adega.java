import java.util.Scanner;

public class Programa_Adega {
    public static final Scanner ler = new Scanner(System.in);
    public static final int N_PRODUTORES_MAXIMO = 10;
    public static final int N_PRODUTORES_MINIMO = 1;
    public static final int CAPACIDADE_MAXIMA_ADEGA = 4000;
    public static final int QUANTIDADE_MAXIMA_UVAS = 5000;
    public static final int QUANTIDADE_MINIMA_UVAS = 5;
    public static final int TEMPO_TRANSPORTE_MAXIMO = 3600;
    public static final int TEMPO_TRANSPORTE_MINIMO = 60;
    public static final int TEMPO_PESAGEM_MAXIMO = 1800;
    public static final int TEMPO_PESAGEM_MINIMO = 60;


    public static void main(String[] args) {
        int quantidadeProdutores = ler.nextInt();

        if (quantidadeProdutores >= N_PRODUTORES_MINIMO && quantidadeProdutores <= N_PRODUTORES_MAXIMO) {
            int quantidadeProdutoresRejeitados = 0;
            int quantidadeProdutoresAprovados = 0;
            int quantidadeUvasRejeitadas = 0;
            int totalUvas = 0;
            int maiorTempo = 0;
            int contadorMaiorTempo = 0;

            for (int i = 0; i < N_PRODUTORES_MAXIMO; i++) {
                int quantidadeUvas = ler.nextInt();
                int tempoTransporte = ler.nextInt();
                int tempoPesagem = ler.nextInt();
                int rejeitados = 0;
                if (quantidadeUvas <= CAPACIDADE_MAXIMA_ADEGA){

                    if (verificarDados(quantidadeUvas, tempoTransporte, tempoPesagem)) {
                        int tempoTotal = tempoTransporte + tempoPesagem;
                        totalUvas += quantidadeUvas;
                        quantidadeProdutoresAprovados++;

                        if (tempoTotal > maiorTempo) {
                            maiorTempo = tempoTotal;
                            contadorMaiorTempo = 1;
                        } else if (tempoTotal == maiorTempo) {
                            contadorMaiorTempo++;
                        } else {
                            quantidadeProdutoresRejeitados++;
                            quantidadeUvasRejeitadas += quantidadeUvas;
                        }
                    }
                    double percentagemProdutoresRjeitados = calcularPercentagem(quantidadeProdutoresRejeitados, quantidadeProdutores);
                    int totalCalculo = totalUvas + quantidadeUvasRejeitadas;
                    double percentagemUvasRejeitadas = calcularPercentagem(quantidadeUvasRejeitadas, (totalCalculo));
                    mostrarResultados(quantidadeProdutoresAprovados, maiorTempo, contadorMaiorTempo, percentagemUvasRejeitadas, percentagemProdutoresRjeitados);
                }
                else{
                    rejeitados++;
                }
                if (rejeitados != 0){
                    System.out.println("não foram aceites produtores");
                }

            }
        }
    }

    public static boolean verificarDados(int quantidadeUvas, int tempoTransporte, int tempoPesagem) {
        return (quantidadeUvas >= QUANTIDADE_MINIMA_UVAS && quantidadeUvas <= QUANTIDADE_MAXIMA_UVAS) &&
                (tempoTransporte >= TEMPO_TRANSPORTE_MINIMO && tempoTransporte <= TEMPO_TRANSPORTE_MAXIMO) &&
                (tempoPesagem >= TEMPO_PESAGEM_MINIMO && tempoPesagem <= TEMPO_PESAGEM_MAXIMO);
    }


    public static double calcularPercentagem(int parteCalculo, int calculoTotal) {
        double calculoPercentagem = (parteCalculo * 100.0) / calculoTotal;
        return calculoPercentagem;
    }

    public static void mostrarResultados(int quantidadeProdutoresAprovados, int maiorTempo,
                                         int contadorMaiorTempo, double percentagemUvasRejeitadas, double percentagemProdutoresRjeitadas) {
        if (quantidadeProdutoresAprovados == 0) {
            System.out.println("não foram aceites produtores");
        } else {
            System.out.printf("Maior tempo de processamento: %d segundos , %d produtores%n", maiorTempo, contadorMaiorTempo);
            System.out.printf("Rejeitados: uvas=%.2f%% , produtores=%.2f%%%n", percentagemUvasRejeitadas, percentagemProdutoresRjeitadas);
        }
    }
}

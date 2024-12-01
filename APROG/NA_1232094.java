import java.util.Scanner;

public class NA_1232094 {

    public static Scanner ler = new Scanner(System.in);
    public static final int NUMERO_MOEDAS_MINIMO = 2;
    public static final int NUMERO_MOEDAS_MAXIMO = 10;
    public static final int VALOR_PRIMEIRA_MAQUINA = 1;
    public static final int VALOR_ULTIMA_MAQUINA = 2;
    public static final int VALOR_MOEDAS_MINIMO = 1;
    public static final int VALOR_MOEDAS_MAXIMO = 2;
    public static final int NUMERO_RODADAS_MOEDA_MINIMA = 2;
    public static final int NUMERO_RODADAS_MOEDA_MAXIMA = 5;

    public static void main(String[] args) {

        int totalBolasAzuis = 0;
        int totalBolasVermelhas = 0;
        int totalBolas = 0;

        int valor = validarValores(NUMERO_MOEDAS_MINIMO, NUMERO_MOEDAS_MAXIMO);

        int valorMoeda = validarValores(VALOR_MOEDAS_MINIMO, VALOR_MOEDAS_MAXIMO);

        for (int i = 0; i < valor; i++){
            if (valorMoeda == VALOR_MOEDAS_MAXIMO) {

                for (int j = 0; j < NUMERO_RODADAS_MOEDA_MAXIMA; j++) {

                    int numeroMaquina = validarValores(VALOR_PRIMEIRA_MAQUINA, VALOR_ULTIMA_MAQUINA);
                    int testeValor = numeroMaquina;

                    if (testeValor % 2 == 0) {
                        totalBolasAzuis++;
                        totalBolas++;
                    } else {
                        totalBolasVermelhas++;
                        totalBolas++;
                    }
                }
            }

            else {
                for (int l = 0; l < NUMERO_RODADAS_MOEDA_MINIMA; l++) {

                    int numeroMaquina = validarValores(VALOR_PRIMEIRA_MAQUINA, VALOR_ULTIMA_MAQUINA);
                    int testeValor = numeroMaquina;

                    if (testeValor % 2 == 0) {
                        totalBolasAzuis++;
                        totalBolas++;
                    } else {
                        totalBolasVermelhas++;
                        totalBolas++;
                    }
                }
            }
        }

        double valorMedioBolasAzuis = ((double) totalBolasAzuis / totalBolas) / ((double)valor);
        double valorMedioBolasVermelhas = ((double) totalBolasVermelhas / totalBolas) / ((double)valor);

        System.out.println("Saíram " + totalBolasVermelhas + " bolas vermelhas e " + totalBolasAzuis + " bolas azuis");
        System.out.println("Valor médio das bolas vermelhas/azuis: " + valorMedioBolasVermelhas + "€/" + valorMedioBolasAzuis + "€");

        if (valorMedioBolasVermelhas > valorMedioBolasAzuis) {
            System.out.println("As bolas vermelhas são mais lucrativas que as bolas azuis");
        } else if (valorMedioBolasVermelhas < valorMedioBolasAzuis) {
            System.out.println("As bolas azuis são mais lucrativas que as bolas vermelhas");
        } else {
            System.out.println("As bolas vermelhas e azuis dão lucro idêntico");
        }
    }

    public static int validarValores(int valor_Min, int int_Max) {
        int valor = ler.nextInt();
        while (valor < valor_Min || valor > int_Max) {
            valor = ler.nextInt();
        }
        return valor;
    }
}
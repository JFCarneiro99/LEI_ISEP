import java.util.Scanner;

public class Programa_Temperaturas {

    public static Scanner sc = new Scanner(System.in);
    public static final int MIN_GRAUS = -459;
    public static final int MAX_GRAUS = 212;
    public static final int MIN_DIAS = 2;
    public static final int MAX_DIAS = 30;
    public static final int MINIMO_EXTREMO = 0;
    public static final int MAXIMO_EXTREMO = 40;

    public static void main(String[] args) {

        int dias;
        dias = Verificar(MIN_DIAS, MAX_DIAS);
        Imprimir(dias);
    }
    public static double MudarUnidade(int far){
        double celsius;
        celsius = (far - 32) * ((double) 5/9);
        return celsius;
    }

    public static boolean ExtremeWether(double graus){
        if (graus < MINIMO_EXTREMO || graus  > MAXIMO_EXTREMO){
            return true;
        }
        return false;
    }

    public static int Verificar(int minimo, int maximo){
        int num = sc.nextInt();
        while (num < minimo || num > maximo){
            num = sc.nextInt();
        }
        return num;
    }

    public static void Imprimir(int dias){
        int contador = 0, fahr, sequencia = 0;
        double celsius, diaAnterior = 10;
        for (int i = 0; i < dias; i++) {
            fahr = Verificar(MIN_GRAUS, MAX_GRAUS);
            celsius = MudarUnidade(fahr);
            if( ExtremeWether(celsius)){
                contador++;
                if (ExtremeWether(diaAnterior)){
                    sequencia++;
                }else{
                    sequencia = 1;
                }
            }

            diaAnterior = celsius;
        }
        if (contador > 0){
            System.out.println("Número de dias comn extreme weather = " + contador);
            System.out.println("Maior sequencia de extreme weather = " + sequencia);

        }else{
            System.out.println("Não há dias de extreme weather");
        }
    }



}
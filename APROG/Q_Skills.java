import java.util.Scanner;

public class Q_Skills {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int competenciasDistintas = 0;
        int numero = ler.nextInt();

        if (numero > 0) {
            while (numero > 0) {

                int potencia = 1;
                int aux = numero;
                while (aux >= 10) {
                    potencia *= 10;
                    aux /= 10;
                }

                while (potencia > 0) {
                    int digito = numero / potencia;
                    numero = numero % potencia;
                    potencia = potencia / 10;


                    if (digito != 0) {

                        int auxComp = competenciasDistintas;
                        int encontrado = 0;


                        while (auxComp > 0) {
                            if (auxComp % 10 == digito) {
                                encontrado = 1;
                                auxComp = 0;
                            } else {
                                auxComp = auxComp / 10;
                            }
                        }

                        if (encontrado == 0) {
                            competenciasDistintas = competenciasDistintas * 10 + digito;
                        }
                    }
                }
                numero = ler.nextInt();
            }
            System.out.println(competenciasDistintas);
        }
    }
}


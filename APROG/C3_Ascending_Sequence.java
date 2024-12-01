import java.util.Scanner;

public class C3_Ascending_Sequence {
    public static Scanner ler = new Scanner(System.in);
    public static int MAX_ARRAY = 100;

    public static void main(String[] args) {

        int tamanhoArray = ler.nextInt();
        while (tamanhoArray < 0) {
            tamanhoArray = ler.nextInt();
        }

        int[] arrayValores = inserirValores(tamanhoArray);

        if (verificarSequencia(arrayValores, tamanhoArray) == false) {
            System.out.println("always ascending = true");
            System.out.println("always ascending = false");
        }
    }

    public static int[] inserirValores(int tamanhoArray) {

        int[] arrayValores = new int[tamanhoArray];

        for (int i = 0; i < tamanhoArray; i++) {
            tamanhoArray = ler.nextInt();
        }
        return arrayValores;
    }

    public static boolean verificarSequencia(int[] arrayValores, int tamanhoArray) {
        for (int i = 0; i < tamanhoArray; i++) {
            if (arrayValores[i] == arrayValores[i + 1]) {
                return false;
            } else if (arrayValores[i] < arrayValores[i + 1]) {
                return true;
            } else if (-(arrayValores[i]) < -(arrayValores[i + 1])) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
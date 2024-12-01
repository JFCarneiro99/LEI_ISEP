import java.util.Scanner;

public class Y2_Multiplication_tables {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int inicio;
        int fim;

        int num = Integer.parseInt(ler.nextLine());

        if (readPositiveValue(num)==true){
            inicio = num;
        }
        else {
            while(readPositiveValue(num)!= true){
                num = Integer.parseInt(ler.nextLine());
            }
            inicio = num;
        }
        int num2 = Integer.parseInt(ler.nextLine());

        if (readPositiveValue(num2)==true){
            fim = num2;
        }
        else {
            while(readPositiveValue(num2)!= true){
                num2 = Integer.parseInt(ler.nextLine());
            }
            fim = num2;
        }

        showTablesInRange(inicio, fim);
    }

    public static void showTableOfNumber(int num) {
        System.out.println("Multiplication table of " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
    }

    public static void showTablesInRange(int inicio, int fim) {

        if (inicio > fim) {
            int novoN = inicio;
            inicio = fim;
            fim = novoN;
        }
        for (int i = inicio; i <= fim; i++) {
            showTableOfNumber(i);
        }
    }

    public static boolean readPositiveValue(int num) {
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }
}


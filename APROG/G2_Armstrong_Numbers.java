import java.util.Scanner;

public class G2_Armstrong_Numbers {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int N = ler.nextInt();
        for (int i = 0; i < N; i++) {
            int num = i;
            if (isArmstrong(num) == true){
                System.out.println(num);
            }
        }
    }


    public static boolean isArmstrong(int num) {
        int numArmstrong = 0;
        int alg;
        int numAlterado = num;
        int potencia = numeroAlgarismos(num);

        while (numAlterado > 0) {
            alg = numAlterado % 10;
            numAlterado = numAlterado / 10;
            numArmstrong += (int) Math.pow(alg, potencia);
        }
        if (numArmstrong == num) {
            return true;
        }else{
            return false;
        }
    }

    public static int numeroAlgarismos(int num) {
        int numalg = 0;
        int algarismos = num;

        while (algarismos > 0) {
            algarismos = algarismos / 10;
            numalg = numalg + 1;
        }
        return numalg;
    }
}

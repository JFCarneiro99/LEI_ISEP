import java.util.Scanner;

public class I_Least_common_multiple {
    public static void main(String[] args) {

        int num1, num2, mmc;
        Scanner ler = new Scanner(System.in);

        num1 = ler.nextInt();
        num2 = ler.nextInt();
        mmc = 0;

        if (num1 > 0 && num2 > 0){
            if (num1 > num2) {
                mmc = num1;
            } else if (num2 > num1) {
                mmc = num2;
            }

            while (mmc % num1 != 0 || mmc % num2 != 0){
                mmc = mmc + 1;
            }
            System.out.println(mmc);
        }
    }
}
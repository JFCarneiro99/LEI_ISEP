import java.util.Scanner;

public class H_Prime_Number {
    public static void main(String[] args) {

        int num, div, qntdiv;

        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();

        qntdiv = 0;

        if (num >0){
            for (div = 1;div <= num; div++) {
                if (num % div == 0) {
                    qntdiv = qntdiv + 1;
                }
            }
            if(qntdiv == 2){
                System.out.println("prime");
            } else{
                System.out.println("not prime");
            }
        }
    }
}

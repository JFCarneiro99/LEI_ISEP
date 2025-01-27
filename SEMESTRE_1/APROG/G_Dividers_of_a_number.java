import java.util.Scanner;

public class G_Dividers_of_a_number {
    public static void main(String[] args) {

        int num, qntdiv, div;
        Scanner ler = new Scanner(System.in);
        num = ler.nextInt();

        qntdiv = 0;
        if (num >0){
            for (div = 1;div <= num; div++) {
                if (num % div == 0) {
                    System.out.println(div);
                    qntdiv = qntdiv + 1;
                }
            }
            System.out.println("("+qntdiv+")");
        }
    }
}

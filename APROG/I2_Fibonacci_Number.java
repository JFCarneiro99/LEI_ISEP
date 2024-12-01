import java.util.Scanner;

public class I2_Fibonacci_Number {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int num = Integer.parseInt(ler.nextLine());
        if (fibonacci(num) == true){
            System.out.println("is a Fibonacci number");
        }
        else{
            System.out.println("is not a Fibonacci number");
        }

    }

    public static boolean fibonacci(int num) {
       if (num < 0){
           return false;
       }

       int primeirotermo = 0;
       int segundotermo = 1;

       while (primeirotermo < num){
           int proximo = primeirotermo + segundotermo;
           primeirotermo = segundotermo;
           segundotermo = proximo;
       }
       return primeirotermo == num;
    }
}

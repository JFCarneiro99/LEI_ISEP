import java.util.Scanner;

public class C2_Calculate_the_angles_of_a_triangle {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double a = ler.nextDouble();
        double b = ler.nextDouble();
        double c = ler.nextDouble();

        if (verificarTrianguloValido(a, b, c)) {

            double anguloAB = calculoAngulo(a, b, c);
            double anguloAC = calculoAngulo(a, c, b);
            double anguloBC = calculoAngulo(b, c, a);

            System.out.printf("a=%.2f%n", a);
            System.out.printf("b=%.2f%n", b);
            System.out.printf("c=%.2f%n", c);
            System.out.printf("ang(a,b)=%.2f%n", anguloAB);
            System.out.printf("ang(a,c)=%.2f%n", anguloAC);
            System.out.printf("ang(b,c)=%.2f%n", anguloBC);
        } else {
            System.out.println("impossible");
        }
    }

    public static boolean verificarTrianguloValido(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double calculoAngulo(double a, double b, double c) {
        double cosTheta = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);

        if (cosTheta < -1) cosTheta = -1;
        if (cosTheta > 1) cosTheta = 1;

        double anguloRadianos = Math.acos(cosTheta);
        return anguloRadianos * (180 / Math.PI);
    }
}

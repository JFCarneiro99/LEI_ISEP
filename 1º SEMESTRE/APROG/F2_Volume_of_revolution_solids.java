import java.util.Scanner;

public class F2_Volume_of_revolution_solids {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String tSolido = ler.nextLine();

        while (!tSolido.equals("end")) {

            if (tSolido.equals("cylinder")) {
                double raio = Double.parseDouble(ler.nextLine());
                double altura = Double.parseDouble(ler.nextLine());
                System.out.printf("%.2f%n", vcylinder(raio, altura));
            }

            if (tSolido.equals("cone")) {
                double raio = Double.parseDouble(ler.nextLine());
                double altura = Double.parseDouble(ler.nextLine());
                System.out.printf("%.2f%n", vcone(raio, altura));
            }

            if (tSolido.equals("sphere")) {
                double raio = Double.parseDouble(ler.nextLine());
                System.out.printf("%.2f%n", vsphere(raio));
            }
            tSolido = ler.nextLine();
        }
    }

    public static double vcone(double raio, double altura) {
        double volumeCone = (1.0 / 3 * Math.PI * raio * raio * altura);
        return (volumeCone);
    }

    public static double vsphere(double raio){
        double volumeEsfera = (4.0/3 * raio * raio * raio * Math.PI);
        return (volumeEsfera);
    }

    public static double vcylinder(double raio, double altura){
        double volumeCilindro = (Math.PI * raio * raio * altura);
        return (volumeCilindro);
    }
}

package org.dei.automovel;

public class MainAutomovel {
    public static void main(String[] args) {

        Automovel a1 = new Automovel("11-11-AA", "Toyota", 1400);

        System.out.println(a1);
        System.out.println(a1.getMatricula());
        System.out.println(Automovel.getTotalAutomoveis());

        Automovel a2 = new Automovel("22-22-BB", "Audi");

        System.out.println(a2);
        a2.setCilindrada(1800);
        System.out.println(a2);
        System.out.println(Automovel.getTotalAutomoveis());

        System.out.println(Math.abs(a1.calcularDiferencaCilindrada(a2)));

        if (a1.isCilindradaMaior(a2)){
            System.out.println("Automovel com a maior cilindrada " + a1.getMatricula());
        }
        else if (a2.isCilindradaMaior(a1)){
            System.out.println("Automovel com a maior cilindrada " + a2.getMatricula());
        }
        else {
            System.out.println("Os dois Automoveis tem a mesma cilindrada");
        }

    }
}
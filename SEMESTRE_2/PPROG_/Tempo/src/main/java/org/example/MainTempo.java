package org.example;

public class MainTempo {
    public static void main(String[] args) {
        Tempo t1 = new Tempo(05,30, 12);
        System.out.println(t1.formato12Horas());
        t1.acrescentarSegundo();
        System.out.println(t1.formato12Horas());
        System.out.println("");

        Tempo t2 = new Tempo(18,5, 20);
        System.out.println(t2.formato12Horas());

        System.out.println(t1.isMaior(t2));
        System.out.println(t1.isMaior(23,7,4));
        System.out.println("");

        System.out.println(t1.diferencaSegundos(t2) + " segundos");
        System.out.println((t1.diferencaTempo(t2)).formato24Horas());
    }
}
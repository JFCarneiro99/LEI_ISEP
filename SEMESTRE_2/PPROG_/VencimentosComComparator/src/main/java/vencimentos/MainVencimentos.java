package vencimentos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainVencimentos {

    public static void main(String[] args) {

        TrabalhadorComissao tc = new TrabalhadorComissao("Susana Ferreira",
                500.0f, 1500.0f, 6f);
        TrabalhadorPeca tp = new TrabalhadorPeca("Jorge Silva", 20, 30);
        TrabalhadorHora th = new TrabalhadorHora("Carlos Miguel", 160, 3.5f);

        List<Trabalhador> trabs = new ArrayList<>();
        trabs.add(tc);
        trabs.add(tp);
        trabs.add(th);

        System.out.println("### Trabalhadores ###");
        listar(trabs);

    }

    private static void listar(List<Trabalhador> trabs) {
        for (Trabalhador trab : trabs) {
            if (trab != null) {
                System.out.printf("%s, vencimento = %.2f€%n%n", trab.getNome(),
                        trab.calcularVencimento());
            }
        }

        Collections.sort(trabs);
        System.out.println("Ordem crescente dos vencimentos:");
        trabs.forEach(t -> System.out.println(t.getNome() + ": " + t.calcularVencimento()));

        Collections.sort(trabs, new Trabalhador.ComparatorVencimentoDesc());
        System.out.println("\nOrdem decrescente dos vencimentos:");
        trabs.forEach(t -> System.out.println(t.getNome() + ": " + t.calcularVencimento()));

        Collections.sort(trabs, new Trabalhador.ComparatorNome());
        System.out.println("\nOrdem alfabética dos nomes:");
        trabs.forEach(t -> System.out.println(t.getNome() + ": " + t.calcularVencimento()));
    }
}

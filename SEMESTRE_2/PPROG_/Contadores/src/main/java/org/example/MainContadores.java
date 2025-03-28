package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class MainContadores {
    public static void main(String[] args) {
        ArrayList<Contador> contadores = new ArrayList<>();

        contadores.add(new ContadorGas("GAS-1", "Carlos Silva", 50));
        contadores.add(new ContadorEletricidadeSimples("ELECT-1", "Ana Sousa", 200, 6.0));
        contadores.add(new ContadorEletricidadeBiHorario("ELECT-2", "João Pereira", 100, 150, 7.0));

        System.out.println("Identificadores e clientes:");
        for (Contador c : contadores) {
            System.out.println(c.getIdentificador() + " - " + c.getNomeCliente());
        }

        long countEletricidade = contadores.stream().filter(c -> c instanceof ContadorEletricidade).count();
        System.out.println("\nTotal de contadores de eletricidade: " + countEletricidade);

        System.out.println("\nContadores bi-horários:");
        contadores.stream().filter(c -> c instanceof ContadorEletricidadeBiHorario).forEach(c -> System.out.println(c.getIdentificador()));

        System.out.println("\nCusto do consumo:");
        for (Contador c : contadores) {
            System.out.println(c.getIdentificador() + ": " + c.calcularCusto() + "€");
        }

        Optional<ContadorGas> maxGas;
        maxGas = contadores.stream()
                .filter(c -> c instanceof ContadorGas)
                .map(c -> (ContadorGas) c)
                .max(Comparator.comparingInt(c -> c.consumoMes));
        maxGas.ifPresent(c -> System.out.println("\nMaior consumo de gás: " + c.getIdentificador()));

        // f) Listar nomes únicos de clientes
        System.out.println("\nNomes dos clientes:");
        contadores.stream().map(Contador::getNomeCliente).distinct().forEach(System.out::println);
    }
}
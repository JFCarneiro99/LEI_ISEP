package org.example;

public class MainGinasio {
    public static void main(String[] args) {
        Utente utente1 = new Utente("João", "Masculino", 17, 1.8, 70);
        System.out.println(utente1);

        Utente utente2 = new Utente("Ana", "Feminino", 21, 1.5, 50);
        System.out.printf("A diferença de idades é: %d%n%n", utente1.calcularDiferenca(utente2));

        System.out.printf("IMC de %s : %f%n", utente1.getNome(), utente1.calcularIMC());
        System.out.printf("Classificação: %s%n%n", utente1.classificarIMC());

        Utente maisNovo = utente1.maisNovo(utente2);
        if (maisNovo == null) {
            System.out.printf("Tem a mesma idade.%n%n");
        } else System.out.printf("O utente mais novo é: %s%n%n", maisNovo.getNome());

        System.out.printf("O número total de Utentes do ginásio é: %d%n", Utente.getTotalDeUtentes());

        Utente[] utentes = {
                new Utente("Carlos", "Masculino", 28, 1.80, 75),
                new Utente("Ana", "Feminino", 35, 1.65, 60),
                new Utente("Miguel", "Masculino", 22, 1.78, 85),
                new Utente("Sofia", "Feminino", 40, 1.70, 90)
        };

        System.out.println("Lista de utentes:");
        for (Utente utente : utentes) {
            System.out.println(utente);
        }

        System.out.println("\nIMC e grau de obesidade:");
        for (Utente utente : utentes) {
            System.out.printf("%s - IMC: %.2f - Classificação: %s%n", utente.getNome(), utente.calcularIMC(), utente.classificarIMC());
        }

        System.out.println("\nUtentes que não são Saudáveis:");
        for (Utente utente : utentes) {
            if (!utente.isSaudavel()) {
                System.out.printf("%s - Classificação: %s%n", utente.getNome(), utente.classificarIMC());
            }
        }

        Utente.setLimiteMagro(24);
        System.out.println("\nNova Classificação IMC após alteração dos valores de referência:");
        for (Utente utente : utentes) {
            System.out.printf("%s - IMC: %.2f - Nova Classificação: %s%n", utente.getNome(), utente.calcularIMC(), utente.classificarIMC());
        }

        utentes[0].setIdade(utentes[1].getIdade());
        System.out.printf("\nIdade de %s alterada para %d anos.%n", utentes[0].getNome(), utentes[0].getIdade());

        maisNovo = utentes[0].maisNovo(utentes[1]);
        if (maisNovo == null) {
            System.out.printf("Tem a mesma idade.%n%n");
        } else System.out.printf("O utente mais novo é: %s%n%n", maisNovo.getNome());
    }
}

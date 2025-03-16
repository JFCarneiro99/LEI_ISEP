package org.example;

public class MainImpostos {
    public static void main(String[] args) {
        // Criar objetos de cada classe
        Contribuinte[] contribuintes = new Contribuinte[6];

        contribuintes[0] = new ContribuinteReformado("José", "Lisboa", 25000, 10000);
        contribuintes[1] = new ContribuinteReformado("Maria", "Porto", 18000, 5000);
        contribuintes[2] = new ContribuinteTCO("Ana", "Coimbra", 28000, 7000);
        contribuintes[3] = new ContribuinteTCO("Carlos", "Faro", 35000, 12000);
        contribuintes[4] = new ContribuinteTCP("Miguel", "Braga", 40000, 60000);
        contribuintes[5] = new ContribuinteDesempregado("Rita", "Setúbal", 5000, 12);

        System.out.println("Lista de contribuintes e respetivo imposto:");
        for (Contribuinte c : contribuintes) {
            System.out.println(c + " | Imposto: " + c.calcularImposto() + "€");
        }

        System.out.println("\nContribuintes desempregados e imposto a pagar:");
        for (Contribuinte c : contribuintes) {
            if (c instanceof ContribuinteDesempregado) {
                System.out.println(c.getNome() + " | Imposto: " + c.calcularImposto() + "€");
            }
        }

        System.out.println("\nAlterando a taxa de desempregados para 3%...");
        ContribuinteDesempregado.setTaxaRT(0.03f);

        System.out.println("\nContribuintes desempregados após alteração da taxa:");
        for (Contribuinte c : contribuintes) {
            if (c instanceof ContribuinteDesempregado) {
                System.out.println(c.getNome() + " | Imposto: " + c.calcularImposto() + "€");
            }
        }
    }
}

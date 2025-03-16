package org.example;

public class ContribuinteDesempregado extends Contribuinte {
    private static float taxaRT = 0.02f;
    private int mesesParagem;

    public ContribuinteDesempregado(String nome, String morada, double rendimentoTrabalho, int mesesParagem) {
        super(nome, morada, rendimentoTrabalho, 0);
        this.mesesParagem = mesesParagem;
    }

    @Override
    public double calcularImposto() {
        return getRendimentoTrabalho() * taxaRT;
    }

    public static void setTaxaRT(float novaTaxa) {
        taxaRT = novaTaxa;
    }
}


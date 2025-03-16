package org.example;

public class ContribuinteTCO extends Contribuinte {
    private static float taxaOR = 0.02f;

    public ContribuinteTCO(String nome, String morada, double rendimentoTrabalho, double outrosRendimentos) {
        super(nome, morada, rendimentoTrabalho, outrosRendimentos);
    }

    @Override
    public double calcularImposto() {
        float taxaRT = getRendimentoTrabalho() <= 30000 ? 0.01f : 0.02f;
        return getRendimentoTrabalho() * taxaRT + getOutrosRendimentos() * taxaOR;
    }
}



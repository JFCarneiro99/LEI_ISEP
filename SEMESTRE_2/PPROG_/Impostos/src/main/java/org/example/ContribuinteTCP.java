package org.example;

public class ContribuinteTCP extends Contribuinte {

    private static float taxaRT = 0.03f;

    public ContribuinteTCP(String nome, String morada, double rendimentoTrabalho, double outrosRendimentos) {
        super(nome, morada, rendimentoTrabalho, outrosRendimentos);
    }

    @Override
    public double calcularImposto() {
        float taxaOR = getOutrosRendimentos() <= 50000 ? 0.02f : 0.05f;
        return getRendimentoTrabalho() * taxaRT + getOutrosRendimentos() * taxaOR;
    }
}


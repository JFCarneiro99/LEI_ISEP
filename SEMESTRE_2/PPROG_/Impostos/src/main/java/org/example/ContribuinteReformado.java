package org.example;

public class ContribuinteReformado extends Contribuinte {
    private static float taxaRT = 0.01f;
    private static float taxaOR = 0.03f;

    public ContribuinteReformado(String nome, String morada, double rendimentoTrabalho, double outrosRendimentos) {
        super(nome, morada, rendimentoTrabalho, outrosRendimentos);
    }

    @Override
    public double calcularImposto() {
        return getRendimentoTrabalho() * taxaRT + getOutrosRendimentos() * taxaOR;
    }
}

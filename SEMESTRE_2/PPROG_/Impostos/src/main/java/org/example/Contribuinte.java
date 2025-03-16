package org.example;

public abstract class Contribuinte {
    private String nome;
    private String morada;
    private double rendimentoTrabalho;
    private double outrosRendimentos;

    public Contribuinte() {
    }

    public Contribuinte(String nome, String morada, double rendimentoTrabalho, double outrosRendimentos) {
        this.nome = nome;
        this.morada = morada;
        this.rendimentoTrabalho = rendimentoTrabalho;
        this.outrosRendimentos = outrosRendimentos;
    }

    public abstract double calcularImposto();

    @Override
    public String toString() {
        return "Contribuinte{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", rendimentoTrabalho=" + rendimentoTrabalho +
                ", outrosRendimentos=" + outrosRendimentos +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public double getRendimentoTrabalho() {
        return rendimentoTrabalho;
    }

    public double getOutrosRendimentos() {
        return outrosRendimentos;
    }
}

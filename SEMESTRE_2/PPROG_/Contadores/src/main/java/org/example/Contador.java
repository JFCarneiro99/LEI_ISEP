package org.example;

public abstract class Contador {

    protected String identificador;
    protected String nomeCliente;
    protected int consumoMes;

    public Contador(String identificador, String nomeCliente, int consumoMes) {
        this.identificador = identificador;
        this.nomeCliente = nomeCliente;
        this.consumoMes = consumoMes;
    }

    public abstract double calcularCusto();

    public String getIdentificador() {
        return identificador;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
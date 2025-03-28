package org.example;

class ContadorGas extends Contador {
    private static final double CUSTO_UNITARIO = 0.8; // €/m³

    public ContadorGas(String identificador, String nomeCliente, int consumoMes) {
        super(identificador, nomeCliente, consumoMes);
    }

    @Override
    public double calcularCusto() {
        return consumoMes * CUSTO_UNITARIO;
    }
}
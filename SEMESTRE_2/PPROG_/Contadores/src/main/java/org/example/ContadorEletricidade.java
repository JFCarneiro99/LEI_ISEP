package org.example;

abstract class ContadorEletricidade extends Contador {
    public ContadorEletricidade(String identificador, String nomeCliente, int consumoMes) {
        super(identificador, nomeCliente, consumoMes);
    }
}
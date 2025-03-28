package org.example;

class ContadorEletricidadeSimples extends ContadorEletricidade {
    private double custoUnitario;

    public ContadorEletricidadeSimples(String identificador, String nomeCliente, int consumoMes, double potenciaContratada) {
        super(identificador, nomeCliente, consumoMes);
        this.custoUnitario = (potenciaContratada < 6.9) ? 0.13 : 0.16;
    }

    @Override
    public double calcularCusto() {
        return consumoMes * custoUnitario;
    }
}

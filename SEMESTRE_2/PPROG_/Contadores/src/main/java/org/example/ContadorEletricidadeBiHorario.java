package org.example;

class ContadorEletricidadeBiHorario extends ContadorEletricidade {
    private double consumoHorasVazio;
    private double consumoForaVazio;
    private double custoHorasVazio;
    private double custoForaVazio;

    public ContadorEletricidadeBiHorario(String identificador, String nomeCliente, int consumoHorasVazio, int consumoForaVazio, double potenciaContratada) {
        super(identificador, nomeCliente, consumoHorasVazio + consumoForaVazio);
        this.consumoHorasVazio = consumoHorasVazio;
        this.consumoForaVazio = consumoForaVazio;
        this.custoHorasVazio = (potenciaContratada < 6.9) ? 0.066 : 0.14;
        this.custoForaVazio = (potenciaContratada < 6.9) ? 0.14 : 0.16;
    }

    @Override
    public double calcularCusto() {
        return (consumoHorasVazio * custoHorasVazio) + (consumoForaVazio * custoForaVazio);
    }
}

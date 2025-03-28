package vencimentos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrabalhadorTest {

    @Test
    void calcularVencimentoTrabalhadorComissao() {
        TrabalhadorComissao trabalhador = new TrabalhadorComissao("João", 1000, 5000, 0.10f);
        assertEquals(1500, trabalhador.calcularVencimento(), 0.01, "Erro no cálculo do vencimento do trabalhador por comissão!");
    }

    @Test
    void calcularVencimentoTrabalhadorPorHora() {
        TrabalhadorHora trabalhador = new TrabalhadorHora("Carlos", 15, 160);
        assertEquals(2400, trabalhador.calcularVencimento(), 0.01, "Erro no cálculo do vencimento do trabalhador por hora!");
    }

    @Test
    void calcularVencimentoTrabalhadorPorPeca() {
        TrabalhadorPeca trabalhador = new TrabalhadorPeca("Ana", 200, 5);
        assertEquals(3200, trabalhador.calcularVencimento(), 0.01, "Erro no cálculo do vencimento do trabalhador por peça!");
    }

    @Test
    void testOrdenacaoPorVencimentoCrescente() {
        List<Trabalhador> trabalhadores = new ArrayList<>();
        trabalhadores.add(new TrabalhadorComissao("João", 1000, 5000, 0.10f)); // vencimento: 1500€
        trabalhadores.add(new TrabalhadorHora("Carlos", 15, 160));// vencimento: 2400€
        trabalhadores.add(new TrabalhadorPeca("Ana", 200, 5)); // vencimento: 3200€

        Collections.sort(trabalhadores);

        assertEquals("João", trabalhadores.get(0).getNome(), "Erro na ordenação por vencimento crescente!");
        assertEquals("Carlos", trabalhadores.get(1).getNome(), "Erro na ordenação por vencimento crescente!");
        assertEquals("Ana", trabalhadores.get(2).getNome(), "Erro na ordenação por vencimento crescente!");
    }

    @Test
    void testOrdenacaoPorVencimentoDecrescente() {
        List<Trabalhador> trabalhadores = new ArrayList<>();
        trabalhadores.add(new TrabalhadorComissao("João", 1000, 5000, 0.10f));  // 1500€
        trabalhadores.add(new TrabalhadorHora("Carlos", 15, 160));         // 2400€
        trabalhadores.add(new TrabalhadorPeca("Ana", 200, 5));                // 3200€

        trabalhadores.sort(new Trabalhador.ComparatorVencimentoDesc());

        assertEquals("Ana", trabalhadores.get(0).getNome(), "Erro na ordenação por vencimento decrescente!");
        assertEquals("Carlos", trabalhadores.get(1).getNome(), "Erro na ordenação por vencimento decrescente!");
        assertEquals("João", trabalhadores.get(2).getNome(), "Erro na ordenação por vencimento decrescente!");

    }

    @Test
    void testOrdenaralfabeticamenteOsValoresDosNomes() {
        List<Trabalhador> trabalhadores = new ArrayList<>();
        trabalhadores.add(new TrabalhadorComissao("João", 1000, 5000, 0.10f));  // 1500€
        trabalhadores.add(new TrabalhadorHora("Carlos", 15, 160));         // 2400€
        trabalhadores.add(new TrabalhadorPeca("Ana", 200, 5));                // 3200€

        trabalhadores.sort(new Trabalhador.ComparatorNome());
        assertEquals("Ana", trabalhadores.get(0).getNome(), "Erro na ordenação por nome alfabeticamente!");
        assertEquals("Carlos", trabalhadores.get(1).getNome(), "Erro na ordenação por nome alfabeticamente!");
        assertEquals("João", trabalhadores.get(2).getNome(), "Erro na ordenação por nome alfabeticamente!");
    }
}
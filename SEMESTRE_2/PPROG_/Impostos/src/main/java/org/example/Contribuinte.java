package org.example;

import org.w3c.dom.ls.LSOutput;

public class Contribuinte {

    private String nome;
    private String morada;

    private static final String NOME_POR_OMISSAO = "Sem nome";
    private static final String MORADA_POR_OMISSAO = "Sem morada";

    public Contribuinte(String nome , String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    public Contribuinte() {
        nome = NOME_POR_OMISSAO;
        morada = MORADA_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }
    public String getMorada() {
        return morada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String toString() {
        return nome + ", " + morada;
    }
}

package org.example;

public class Pessoa {
    private String nome;
    private int idade;
    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int IDADES_POR_OMISSAO = 0;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(){
        this.nome = NOME_POR_OMISSAO;
        this.idade = IDADES_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public int setIdade(int idade) {
        this.idade = idade;
        return idade;
    }

    public String toString(){
        return String.format("%s tem %d ano(s).", nome, idade);
    }
}

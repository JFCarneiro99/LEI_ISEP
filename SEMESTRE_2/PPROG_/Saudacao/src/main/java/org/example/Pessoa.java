package org.example;

/**
 * Representa uma saudação sendo fornecido um nome e uma idade
 *
 * @author JOSE_CARNEIRO
 */
public class Pessoa {
    /**
     * O nome da Pessoa
     */
    private String nome;
    /**
     * A idade da Pessoa
     */
    private int idade;
    /**
     * O nome da Pessoa por omissão.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * A idade da Pessoa por omissão.
     */
    private static final int IDADES_POR_OMISSAO = 0;

    /**
     * Constrói uma instância de Pessoa com o nome e idade.
     */
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    /**
     * Constrói uma instância de Pessoa com o nome e idade por omissão.
     */
    public Pessoa(){
        this.nome = NOME_POR_OMISSAO;
        this.idade = IDADES_POR_OMISSAO;
    }

    /**
     * Devolve o nome da Pessoa.
     *
     * @return nome da Pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Devolve o idade da Pessoa.
     *
     * @return idade da Pessoa
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param nome da Pessoa
     * Altera o nome original pelo que é passado por parâmetro
     *
     * @return nome alterado
     */
    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    /**
     * @param idade da Pessoa
     * Altera a idade original pela que é passada por parâmetro
     *
     * @return idade alterada
     */
    public int setIdade(int idade) {
        this.idade = idade;
        return idade;
    }
    /**
     * Devolve a descrição textual da Pessoa no formato: nome e idade
     * de ano.
     *
     * @return características da Pessoa
     */
    public String toString(){
        return String.format("%s tem %d ano(s).", nome, idade);
    }
}

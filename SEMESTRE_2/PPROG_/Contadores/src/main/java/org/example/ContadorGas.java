package org.example;

public class ContadorGas extends Contador {

    private String nome;
    private double consumo;
    private final String NOME_POR_OMISSAO = "sem nome";
    private final double CONSUMO_POR_OMISSAO = 0;


    // custo gás
    // prefixo
    // contador

    public ContadorGas(String nome, double consumo){
        this.nome = nome;
        this.consumo = consumo;
    }

    public ContadorGas(){
        nome = NOME_POR_OMISSAO;
        consumo = CONSUMO_POR_OMISSAO;
    }

    public ContadorGas(String nome){
        this.nome = nome;
        consumo = CONSUMO_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }
    public double getConsumo() {
        return consumo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String toString(){
          return nome;
    }

}

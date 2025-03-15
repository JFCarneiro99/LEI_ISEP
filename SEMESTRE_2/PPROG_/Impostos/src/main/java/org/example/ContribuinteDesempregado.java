package org.example;

public class ContribuinteDesempregado extends Contribuinte {

    private int mesesDeParagem;
    private float outrosRendimentos;
    protected float taxaSobreOutrosRendimentos;
    private final float TAXA_SOBRE_OUTROS_RENDIMENTOS_POR_OMISSAO = 2.0f;
    private final float OUTROS_RENDIMENTOS_POR_OMISSAO = 0.0f;
    private final int MESES_DE_PARAGEM_POR_OMISSAO = 0;

    public ContribuinteDesempregado(String nome, String morada, float outrosRendimentos,int  mesesDeParagem) {
        super(nome, morada);
        this.outrosRendimentos = outrosRendimentos;
        this.mesesDeParagem = mesesDeParagem;
        taxaSobreOutrosRendimentos = TAXA_SOBRE_OUTROS_RENDIMENTOS_POR_OMISSAO;
    }

    public ContribuinteDesempregado(String nome, String morada) {
        super(nome, morada);
        outrosRendimentos = OUTROS_RENDIMENTOS_POR_OMISSAO;
        mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
        taxaSobreOutrosRendimentos = TAXA_SOBRE_OUTROS_RENDIMENTOS_POR_OMISSAO;
    }

    public ContribuinteDesempregado() {
        super();
        outrosRendimentos = OUTROS_RENDIMENTOS_POR_OMISSAO;
        mesesDeParagem = MESES_DE_PARAGEM_POR_OMISSAO;
        taxaSobreOutrosRendimentos = TAXA_SOBRE_OUTROS_RENDIMENTOS_POR_OMISSAO;
    }

    public int getMesesDeParagem() {
        return mesesDeParagem;
    }

    public float getOutrosRendimentos() {
        return outrosRendimentos;
    }

    public float getTaxaSobreOutrosRendimentos() {
        return taxaSobreOutrosRendimentos;
    }

    public void setOutrosRendimentos(float outrosRendimentos) {
        this.outrosRendimentos = outrosRendimentos;
    }

    public void setMesesDeParagem(int mesesDeParagem) {
        this.mesesDeParagem = mesesDeParagem;
    }

    public void setTaxaSobreOutrosRendimentos(float taxaSobreOutrosRendimentos) {
        this.taxaSobreOutrosRendimentos = taxaSobreOutrosRendimentos;
    }

    public String toString(){
        return String.format("Contrinte Desempregado: %s " + "irá pagar %.2f € em impostos.", getNome(), calcularImpostos(outrosRendimentos, taxaSobreOutrosRendimentos));
    }

    public float calcularImpostos(float outrosRedimentos, float taxaSobreOutrosRendimentos) {
        float impostos = outrosRendimentos * (taxaSobreOutrosRendimentos/100);
        return impostos;
    }
}

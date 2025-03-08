package org.example;

import java.util.PropertyResourceBundle;

/**
 * Classe que representa um utente do ginásio.
 * Disponibiliza funcionalidades como cálculo do IMC, classificação de obesidade
 * e comparação de idades entre utentes.
 */
public class Utente {

    // Atributos
    protected String nome;
    protected String genero;
    protected int idade;
    protected double altura;
    protected double peso;
    private static int totalDeUtentes = 0;

    // Constantes para valores padrão
    protected static final String NOME_POR_OMISSAO = "Sem nome";
    protected static final String GENERO_POR_OMISSAO = "Sem genero";
    protected static final int IDADES_POR_OMISSAO = 0;
    protected static final double ALTURA_POR_OMISSAO = 0;
    protected static final double PESO_POR_OMISSAO = 0;
    protected static int LIMITE_MAGRO = 18;
    protected static int LIMITE_OBESO = 25;

    /**
     * Construtor por omissão.
     */
    public Utente() {
        this.nome = NOME_POR_OMISSAO;
        this.genero = GENERO_POR_OMISSAO;
        this.idade = IDADES_POR_OMISSAO;
        this.altura = ALTURA_POR_OMISSAO;
        this.peso = PESO_POR_OMISSAO;
        totalDeUtentes++;
    }

    /**
     * Construtor com nome e idade.
     * @param nome Nome do utente.
     * @param idade Idade do utente.
     */
    public Utente(String nome, int idade) {
        this.nome = nome;
        this.genero = GENERO_POR_OMISSAO;
        this.idade = idade;
        this.altura = ALTURA_POR_OMISSAO;
        this.peso = PESO_POR_OMISSAO;
        totalDeUtentes++;
    }

    /**
     * Construtor completo.
     * @param nome Nome do utente.
     * @param genero Género do utente.
     * @param idade Idade do utente.
     * @param altura Altura do utente em metros.
     * @param peso Peso do utente em quilogramas.
     */
    public Utente(String nome, String genero, int idade, double altura, double peso) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        totalDeUtentes++;
    }


    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }
    public String getGenero() {
        return genero;
    }
    public int getIdade() {
        return idade;
    }
    public double getAltura() {
        return altura;
    }
    public double getPeso() {
        return peso;
    }

    // Métodos de modificação (setters)
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public static void setLimiteMagro(int limite) {
        LIMITE_MAGRO = limite;
    }
    public void setLimiteObeso(int limite) {
        LIMITE_OBESO = limite;
    }

    /**
     * Retorna uma representação textual do utente.
     * @return String com a informação do utente.
     */
    public String toString() {
        return String.format("NOME: %s%nGÉNERO: %s%nIDADE: %d ano(s)%nALTURA: %.2f m%nPESO: %.2f kg%n",
                nome, genero, idade, altura, peso);
    }

    /**
     * Calcula a diferença de idades entre dois utentes.
     * @param outroUtente com quem comparar.
     * @return Diferença absoluta de idades.
     */
    public int calcularDiferenca(Utente outroUtente) {
        return Math.abs(idade - outroUtente.idade);
    }

    /**
     * Calcula o IMC do utente.
     * @return Valor do IMC.
     */
    public double calcularIMC() {
        double IMC = peso / Math.pow(altura, 2);

        return IMC;
    }

    /**
     * Determina a classificação do IMC.
     * @return Classificação do utente com base no IMC.
     */
    public String classificarIMC() {
        double IMC = calcularIMC();

        if (IMC < LIMITE_MAGRO) {
            return "Magro";
        } else if (IMC < LIMITE_OBESO) {
            return "Saudável";
        } else
            return "Obeso";
    }

    /**
     * Verifica se o utente tem classificação "Saudável".
     * @return true se for saudável, false caso contrário.
     */
    public boolean isSaudavel() {
        return classificarIMC().equals("Saudável");
    }

    /**
     * Determina o utente mais novo entre dois.
     * @param outroUtente para comparação.
     * @return O utente mais novo, ou null se tiverem a mesma idade.
     */
    public Utente maisNovo(Utente outroUtente) {
        if (this.idade < outroUtente.idade) {
            return this;
        } else if (this.idade > outroUtente.idade) {
            return outroUtente;
        } else
            return null;
    }

    /**
     * Obtém o número total de utentes criados.
     * @return Número de instâncias criadas da classe Utente.
     */
    public static int getTotalDeUtentes() {
        return totalDeUtentes;
    }
}

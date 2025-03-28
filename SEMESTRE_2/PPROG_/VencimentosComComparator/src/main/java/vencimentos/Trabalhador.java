package vencimentos;
import java.util.Comparator;

/**
 * Esta classe permite a construção de uma hierarquia de classes para
 * representarem diferentes tipos de trabalhadores. Especifica membros 
 * comuns a todas as classes da hierarquia.
 *
 * @author ISEP-DEI-PPROG
 */
public abstract class Trabalhador implements Comparable<Trabalhador> {

    /**
     * O nome do trabalhador.
     */
    protected String nome;
    /**
     * O vencimento do trabalhador.
     */
    //protected float vencimento;
    /**
     * O nome por omissão do trabalhador.
     */
    protected static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * O vencimento por omissão do trabalhador.
     */
    protected static final float VENCIMENTO_POR_OMISSAO = 0.0f;

    /**
     * Inicializa o nome do trabalhador com o nome recebido.
     *
     * @param nome  o nome do trabalhador
     */
    public Trabalhador(String nome) {
        this.nome = nome;
    }

    /**
     * Inicializa o nome do trabalhador com o nome por omissão.
     */
    public Trabalhador() {
        nome = Trabalhador.NOME_POR_OMISSAO;
    }

    /**
     * Devolve o nome do trabalhador.
     *
     * @return nome do trabalhador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do trabalhador.
     *
     * @param nome o novo nome do trabalhador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o nome do trabalhador.
     *
     * @return nome do trabalhador
     */
    @Override
    public String toString() {
        return nome;
    }

    /**
     * Permite o cálculo do vencimento do trabalhador através do polimorfismo.
     *
     * @return vencimento do trabalhador
     */
    public abstract float calcularVencimento();


    @Override
    public int compareTo(Trabalhador outro) {
        return Double.compare(this.calcularVencimento(), outro.calcularVencimento());
    }

    static class ComparatorVencimentoDesc implements Comparator<Trabalhador> {
        @Override
        public int compare(Trabalhador t1, Trabalhador t2) {
            return Double.compare(t2.calcularVencimento(), t1.calcularVencimento());
        }
    }

    static class ComparatorNome implements Comparator<Trabalhador> {
        @Override
        public int compare(Trabalhador t1, Trabalhador t2) {
            return t1.getNome().compareToIgnoreCase(t2.getNome());
        }
    }
}

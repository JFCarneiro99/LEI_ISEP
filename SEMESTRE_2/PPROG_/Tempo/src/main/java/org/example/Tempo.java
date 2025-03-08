package org.example;

/**
 * Classe que representa um tempo no formato de horas, minutos e segundos.
 */
public class Tempo {

    // Atributos
    private int horas;
    private int minutos;
    private int segundos;

    //Atributos por Omissão
    private static int HORAS_POR_OMISSAO = 0;
    private static int MINUTOS_POR_OMISSAO = 0;
    private static int SEGUNDOS_POR_OMISSAO = 0;

     /**
     * Construtor que permite definir uma hora específica.
     * @param horas Hora do tempo.
     * @param minutos Minuto do tempo.
     * @param segundos Segundo do tempo.
     */
    public Tempo(int horas, int minutos, int segundos) {
        this.horas = (horas >= HORAS_POR_OMISSAO && horas <24) ? horas : HORAS_POR_OMISSAO;
        this.minutos = (minutos >= MINUTOS_POR_OMISSAO && minutos < 60) ? minutos : MINUTOS_POR_OMISSAO;
        this.segundos = (segundos >= SEGUNDOS_POR_OMISSAO && minutos < 60) ? segundos : SEGUNDOS_POR_OMISSAO;
    }
    
    /**
    * Construtor padrão que inicia o tempo como 00:00:00.
    */
    public Tempo(){
        this.horas = HORAS_POR_OMISSAO;
        this.minutos = MINUTOS_POR_OMISSAO;
        this.segundos = SEGUNDOS_POR_OMISSAO;
    }

    // Métodos de acesso (getters)
    public int getHoras() {
        return horas;
    }
    public int getMinutos() {
        return minutos;
    }
    public int getSegundos() {
        return segundos;
    }

    // Métodos de acesso (setters)
    public void setHoras(int horas) {
        this.horas = horas;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    /**
     * Retorna o tempo formatado no formato hh:mm:ss.
     * @return String representa o tempo.
     */
    public String formato24Horas() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    /**
     * Retorna o tempo formatado no formato hh:mm:ss AM/PM.
     * @return String representa o tempo no formato de 12 horas.
     */
    public String formato12Horas() {
        int h = (horas == 0 || horas == 12) ? 12 : horas % 12;
        String parteDoDia = (horas < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", h, minutos, segundos, parteDoDia);
    }

    /**
     * Acrescenta 1 segundo ao tempo.
     */
    public void acrescentarSegundo() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
            if (minutos == 60) {
                minutos = 0;
                horas = (horas + 1) % 24;
            }
        }
    }

    /**
     * Verifica se este tempo é maior do que outro tempo.
     * @param outro Outro tempo a ser comparado.
     * @return true se este tempo for maior, false caso contrário.
     */
    public boolean isMaior(Tempo outro) {
        return (horas > outro.horas) ||
                (horas == outro.horas && minutos > outro.minutos) ||
                (horas == outro.horas && minutos == outro.minutos && segundos > outro.segundos);
    }

    /**
     * Verifica se este tempo é maior do que um tempo fornecido em valores separados.
     * @param horas Hora a ser comparada.
     * @param minutos Minuto a ser comparado.
     * @param segundos Segundo a ser comparado.
     * @return true se este tempo for maior, false caso contrário.
     */
    public boolean isMaior(int horas, int minutos, int segundos) {
        return isMaior(new Tempo(horas, minutos, segundos));
    }

    /**
     * Calcula a diferença entre dois tempos em segundos.
     * @param outro Outro tempo a ser comparado.
     * @return Diferença entre os tempos em segundos.
     */
    public int diferencaSegundos(Tempo outro) {
        int tempo1 = this.horas * 3600 + this.minutos * 60 + this.segundos;
        int tempo2 = outro.horas * 3600 + outro.minutos * 60 + outro.segundos;
        return Math.abs(tempo1 - tempo2);
    }

    /**
     * Calcula a diferença entre dois tempos e retorna um novo Tempo.
     * @param outroTempo Outro tempo a ser comparado.
     * @return Objeto Tempo representa a diferença.
     */
    public Tempo diferencaTempo(Tempo outroTempo) {
        int tempodiferenca = diferencaSegundos(outroTempo);

        int diferencaHoras = tempodiferenca / 3600;
        int diferencaMinutos = tempodiferenca % 3600 / 60;
        int diferencaSegundos = tempodiferenca % 60;
        Tempo t3 = new Tempo(diferencaHoras, diferencaMinutos, diferencaSegundos);
        return t3;
    }
}

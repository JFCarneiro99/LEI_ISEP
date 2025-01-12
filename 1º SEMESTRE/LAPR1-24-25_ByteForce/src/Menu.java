import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    private static Scanner ler = new Scanner(System.in);

    public static String[] executarModoInterativo(String[] arrayParaExecutarPrograma) throws FileNotFoundException {
        while (true) {
            System.out.printf("%n============================== ByteForceEigenfaces ==============================");
            System.out.printf("%n1. Decomposição própria de matrizes");
            System.out.printf("%n2. Reconstrução de imagens utilizando eigenfaces");
            System.out.printf("%n3. Identificação de imagens utilizando pesos das eigenfaces");
            System.out.printf("%n4. Gerar novas imagens utilizando pesos das eigenfaces");
            System.out.printf("%n5. Sair%n");

            System.out.printf("%nEscolha a funcionalidade (1, 2, 3 ou 4): ");

            String funcionalidade;
            String k = null;
            arrayParaExecutarPrograma[1] = k;
            String ficheiroEntrada = null;
            arrayParaExecutarPrograma[2] = ficheiroEntrada;
            String baseImagens = null;
            arrayParaExecutarPrograma[3] = baseImagens;
            String ficheiroSaida = null;
            arrayParaExecutarPrograma[4] = ficheiroSaida;

            int funcionalidadeP = ler.nextInt();

            switch (funcionalidadeP) {
                case 1:
                    funcionalidade = String.valueOf(funcionalidadeP);
                    arrayParaExecutarPrograma[0] = funcionalidade;
                    System.out.print("Digite o número de valores próprios a utilizar na decomposição (-1 para utilizar todos): ");
                    k = ler.next();
                    arrayParaExecutarPrograma[1] = k;
                    System.out.print("Digite a localização do ficheiro CSV: ");
                    ficheiroEntrada = ler.next();
                    arrayParaExecutarPrograma[2] = ficheiroEntrada;
//                    System.out.print("Digite o nome do ficheiro de saída: ");
//                    ficheiroSaida = ler.next();
//                    arrayParaExecutarPrograma[4] = ficheiroSaida;
                    return arrayParaExecutarPrograma;
                case 2:
                    funcionalidade = String.valueOf(funcionalidadeP);
                    arrayParaExecutarPrograma[0] = funcionalidade;
                    System.out.print("Digite o número de eigenfaces (-1 para utilizar todos): ");
                    k = ler.next();
                    arrayParaExecutarPrograma[1] = k;
                    System.out.print("Digite a localização da base de dados de imagens: ");
                    baseImagens = ler.next();
                    arrayParaExecutarPrograma[3] = baseImagens;
                    //System.out.print("Digite o nome do ficheiro de saída: ");
                    //ficheiroSaida = ler.next();
                    //arrayParaExecutarPrograma[4] = ficheiroSaida;
                    return arrayParaExecutarPrograma;
                case 3:
                    funcionalidade = String.valueOf(funcionalidadeP);
                    arrayParaExecutarPrograma[0] = funcionalidade;
                    System.out.print("Digite o número de eigenfaces (-1 para utilizar todos): ");
                    k = ler.next();
                    arrayParaExecutarPrograma[1] = k;
                    System.out.print("Digite a localização do ficheiro CSV: ");
                    ficheiroEntrada = ler.next();
                    arrayParaExecutarPrograma[2] = ficheiroEntrada;
                    System.out.print("Digite a localização da base de dados de imagens: ");
                    baseImagens = ler.next();
                    arrayParaExecutarPrograma[3] = baseImagens;
//                    System.out.print("Digite o nome do ficheiro de saída: ");
//                    ficheiroSaida = ler.next();
//                    arrayParaExecutarPrograma[4] = ficheiroSaida;
                    return arrayParaExecutarPrograma;
                case 4:
                    funcionalidade = String.valueOf(funcionalidadeP);
                    arrayParaExecutarPrograma[0] = funcionalidade;
                    System.out.print("Digite o número de eigenfaces (-1 para utilizar todos): ");
                    k = ler.next();
                    arrayParaExecutarPrograma[1] = k;
                    System.out.print("Digite a localização da base de dados de imagens: ");
                    baseImagens = ler.next();
                    arrayParaExecutarPrograma[3] = baseImagens;
//                    System.out.print("Digite o nome do ficheiro de saída: ");
//                    ficheiroSaida = ler.next();
//                    arrayParaExecutarPrograma[4] = ficheiroSaida;
                    return arrayParaExecutarPrograma;
                case 5:
                    funcionalidade = Integer.toString(funcionalidadeP);
                    arrayParaExecutarPrograma[0] = funcionalidade;
                    return arrayParaExecutarPrograma;
                default:
                    System.out.printf("%nOpção Inválida, escolha um função ou prima '5' para sair!%n");
                    break;
            }
        }
    }

    public static void executarModoNaoInterativo(String[] args) throws FileNotFoundException {

        Validacoes.validarQuantidadeDeParametros(args);

        String baseImagens = null;
        String ficheiroEntrada = null;
        String ficheiroSaida = null;
        String ficheiroSaidaTXT;
        boolean modoInterativo = false;

        int funcionalidade = Integer.parseInt(args[encontrarPosicaoDaChave(args, "-f")]);
        int k = Integer.parseInt(args[encontrarPosicaoDaChave(args, "-k")]);

        switch (funcionalidade) {
            case 1:
                ficheiroEntrada = (args[encontrarPosicaoDaChave(args, "-i")]);
                ficheiroSaidaTXT = (args[args.length - 1]);

                executarFuncionalidade(funcionalidade, k, ficheiroEntrada, baseImagens, ficheiroSaidaTXT, modoInterativo);
                break;
            case 2:
                baseImagens = (args[encontrarPosicaoDaChave(args, "-d")]);
                ficheiroSaidaTXT = (args[args.length - 1]);

                executarFuncionalidade(funcionalidade, k, ficheiroEntrada, baseImagens, ficheiroSaidaTXT, modoInterativo);
                break;
            case 3:
                ficheiroSaida = (args[encontrarPosicaoDaChave(args, "-i")]);
                baseImagens = (args[encontrarPosicaoDaChave(args, "-d")]);
                ficheiroSaidaTXT = (args[args.length - 1]);

                executarFuncionalidade(funcionalidade, k, ficheiroSaida, baseImagens, ficheiroSaidaTXT, modoInterativo);
                break;
            case 4:
                baseImagens = (args[encontrarPosicaoDaChave(args, "-d")]);

                executarFuncionalidade(funcionalidade, k, ficheiroEntrada, baseImagens, ficheiroSaida, modoInterativo);
                break;
            default:
                ler.close();
        }
    }

    public static void executarFuncionalidade(int funcionalidade, int k, String ficheiroEntrada, String baseImagens, String ficheiroSaidaTXT, boolean modoInterativo) throws FileNotFoundException {

        if (!Validacoes.validarParametros(funcionalidade, k, ficheiroEntrada, baseImagens, ficheiroSaidaTXT, modoInterativo)) {

        } else {
            switch (funcionalidade) {
                case 1:
                    Funcionalidade_1_Decomposicao.executarFuncionalidade(k, ficheiroEntrada, ficheiroSaidaTXT, modoInterativo);
                    break;
                case 2:
                    Funcionalidade_2_Reconstrucao.executarFuncionalidade(k, baseImagens, ficheiroSaidaTXT, modoInterativo);
                    break;
                case 3:
                    Funcionalidade_3_Identificacao.executarFuncionalidade(k, ficheiroEntrada, baseImagens, ficheiroSaidaTXT, modoInterativo);
                    break;
                case 4:
                    Funcionalidade_4_Gerar_Imagem.executarFuncionalidade(k, baseImagens);
                    break;
            }
        }
    }

    public static int encontrarPosicaoDaChave(String[] args, String chave) {
        int res = -1, entrada = 0;

        while (res < 0 && entrada < args.length) {
            if (args[entrada].equals(chave)) {
                res = entrada;
            }
            entrada++;
        }
        switch (res) {
            case -1:
                System.out.printf("%nErro: Os parâmetros obrigatórios não foram encontrados.");
                //O parâmetro obrigatório não foi encontrado, ou foi introduzido incorretamente
                System.exit(1);
                break;
        }
        return res + 1;
    }


}
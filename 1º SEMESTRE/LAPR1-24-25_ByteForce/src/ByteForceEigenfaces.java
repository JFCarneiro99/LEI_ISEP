import java.io.FileNotFoundException;
import java.util.Scanner;

public class ByteForceEigenfaces {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length == 0) {
            boolean modoInterativo = true;
            while (modoInterativo) {
                String[] arrayParaExecutarPrograma = new String[5];
                Menu.executarModoInterativo(arrayParaExecutarPrograma);

                int funcionalidade = Integer.parseInt(arrayParaExecutarPrograma[0]);

                if (funcionalidade == 5) {
                    System.out.printf("%nA sair...%n");
                    modoInterativo = false;
                }
                else {
                    int k = Integer.parseInt(arrayParaExecutarPrograma[1]);
                    String ficheiroEntrada = arrayParaExecutarPrograma[2];
                    String baseImagens = arrayParaExecutarPrograma[3];
                    String ficheiroSaida = arrayParaExecutarPrograma[4];

                    Menu.executarFuncionalidade(funcionalidade, k, ficheiroEntrada, baseImagens, ficheiroSaida, modoInterativo);
                }
            }
        } else {
            Menu.executarModoNaoInterativo(args);
        }
    }
}

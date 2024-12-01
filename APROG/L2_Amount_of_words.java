import java.util.Scanner;

public class L2_Amount_of_words {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        String frase = ler.nextLine();
        System.out.println(contarPalavras(frase));

    }

    public static int contarPalavras(String frase) {
        frase = frase.trim();

        if (frase.isEmpty()) {
            return 0;
        }
        String[] palavras = frase.split("\\s+");
        return palavras.length;
    }
}

package org.dei.excecaoUnchecked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestePessoa {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Pessoa p = new Pessoa();
        boolean dadosValidos = false;

        do {
            try {
                System.out.print("Nome:");
                String nome = ler.nextLine();
                p.setNome(nome);

                System.out.print("Nº de ID Civil:");
                int idCivil = ler.nextInt();
                ler.nextLine();
                p.setIDCivil(idCivil);

                dadosValidos = true;

            } catch (ArgumentoForaDosLimitesException e) {
                System.out.println("\nERRO: " + e.getMessage() + "(" + e.getClass().getSimpleName() + ")");

            } catch (IllegalArgumentException e) {
                System.out.println("\nERRO: " + e.getMessage() + "(" + e.getClass().getSimpleName() + ")");

            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Valor inválido para ID Civil (" + e.getClass().getSimpleName() + ")");
                ler.nextLine();
            }
        } while (!dadosValidos);

        System.out.println("\nDados registados com sucesso!");
    }
}
import java.util.Scanner;

public class O_Pizza {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int n, pizza, pizzaAux, ingredientes, ingredientesAux, i, digPizza, digIngrediente, cont = 0;
        boolean aprovada = true;
        ingredientes = ler.nextInt();
        n = ler.nextInt();
        ingredientesAux = ingredientes;
        if (n > 0 && ingredientes > 0) {
            for (i = 0; i < n; i++) {
                pizza = ler.nextInt();
                pizzaAux = pizza;
                while (aprovada && pizza != 0) {
                    digPizza = pizza % 10;
                    pizza = pizza / 10;
                    while (aprovada && ingredientes != 0) {
                        digIngrediente = ingredientes % 10;
                        ingredientes = ingredientes / 10;
                        if (digIngrediente == digPizza) {
                            aprovada = false;
                        }
                    }
                    ingredientes = ingredientesAux;
                }
                if (aprovada) {
                    cont++;
                    System.out.println("Suggestion #" + cont + ":" + pizzaAux);
                }
                aprovada = true;
            }
        }else if (n>0 && ingredientes==0) {
            for (i = 0; i < n; i++) {
                pizza = ler.nextInt();
                pizzaAux = pizza;
                while (aprovada && pizza != 0) {
                    digPizza = pizza % 10;
                    pizza = pizza / 10;
                    if (0 == digPizza) {
                        aprovada = false;
                    }
                }
                if (aprovada) {
                    cont++;
                    System.out.println("Suggestion #" + cont + ":" + pizzaAux);
                }
                aprovada = true;
            }
        }
    }
}


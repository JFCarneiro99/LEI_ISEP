package pt.ipp.isep.dei.esoft.labproject.slides;

/**
 * Demonstrates the use of function parameters and data types
 */
public class FunctionParameters {

    public static void main(String[] args) {
        int a = 4;
        int[] array = {2, 9};
        changeValues(a, array);
        System.out.println(a);  // The output is “4” and not “12”
        System.out.println(array[0]);  // The output is “7” and not “2”
    }

    private static void changeValues(int a, int[] array) {
        a = a * 3;
        array[0] = 7;
    }
}
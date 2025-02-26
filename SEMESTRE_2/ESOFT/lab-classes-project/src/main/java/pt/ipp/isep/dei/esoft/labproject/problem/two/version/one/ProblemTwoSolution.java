package pt.ipp.isep.dei.esoft.labproject.problem.two.version.one;

public class ProblemTwoSolution {

    public static int[] sortIntArrayAscending(int[] array) {
        if (array != null) {
            int temp = 0;

            int arraySize = array.length;
            //Sort the array in ascending order using two for loops
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        //swap elements if not in order
                        swapIntArrayElements(array, j, j + 1);
                    }
                }
            }
        }
        return array;
    }

    public static String[] sortStringArrayAscending(String[] array) {
        if (array != null) {
            int temp = 0;

            int arraySize = array.length;
            //Sort the array in ascending order using two for loops
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize - i - 1; j++) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        //swap elements if not in order
                        swapStringArrayElements(array, j, j + 1);
                    }
                }
            }
        }
        return array;
    }

    private static void swapStringArrayElements(String[] array, int indexOne, int indexTwo) {
        String temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private static void swapIntArrayElements(int[] array, int indexOne, int indexTwo) {
        int temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
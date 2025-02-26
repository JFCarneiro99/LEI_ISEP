package pt.ipp.isep.dei.esoft.labproject.problem.one.version.three;

public class ProblemOne {

    /**
     * Sort an array of integers in ascending order. Implementation (2/2)
     *
     * @param array array of integers
     * @return sorted array of integers
     */
    public static int[] sortArrayAscending(int[] array) {
        if (array != null) {

            int arraySize = array.length;
            //Sort the array in ascending order using two for loops
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize - i - 1; j++) {
                    if (firstIsHigherThanSecond(array[j], array[j + 1])) {
                        //swap elements if not in order
                        swapArrayElements(array, j, j + 1);
                    }
                }
            }
        }
        return array;
    }

    private static boolean firstIsHigherThanSecond(int first, int second) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    private static void swapArrayElements(int[] array, int indexOne, int indexTwo) {
        int temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
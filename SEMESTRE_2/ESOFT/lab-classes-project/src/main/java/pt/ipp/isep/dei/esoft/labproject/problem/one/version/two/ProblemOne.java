package pt.ipp.isep.dei.esoft.labproject.problem.one.version.two;

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
                    if (array[j] > array[j + 1]) {
                        //swap elements if not in order
                        swapArrayElements(array, j, j + 1);
                    }
                }
            }
        }
        return array;
    }

    /**
     * Swap two elements of an array.
     *
     * @param array    Array of integers.
     * @param indexOne Index of the first element.
     * @param indexTwo Index of the second element.
     */
    private static void swapArrayElements(int[] array, int indexOne, int indexTwo) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }
}
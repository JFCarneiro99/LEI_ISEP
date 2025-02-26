package pt.ipp.isep.dei.esoft.labproject.problem.one.version.one;

public class ProblemOneSolution {

    /**
     * Sort an array of integers in ascending order. Implementation (2/2).
     *
     * @param array Array of integers.
     * @return Sorted array of integers.
     */
    public static int[] sortArrayAscending(int[] array) {
        if (array != null) {
            int temp = 0;

            int arraySize = array.length;
            //Sort the array in ascending order using two for loops
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        //swap elements if not in order
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }
}
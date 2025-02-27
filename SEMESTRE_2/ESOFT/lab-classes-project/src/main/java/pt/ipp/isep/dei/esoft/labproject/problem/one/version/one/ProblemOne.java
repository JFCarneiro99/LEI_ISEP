package pt.ipp.isep.dei.esoft.labproject.problem.one.version.one;

public class ProblemOne {

    /**
     * Sort an array of integers in ascending order. Implementation (1/2).
     *
     * @param array Array of integers.
     * @return Sorted array of integers.
     */
    public static int[] sortArrayAscending(int[] array) {
        if (array != null) {
            int temp = 0;
            int arraySize = array.length;

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize -  i - 1; j++) {
                    if (array[j] > array[j + 1]) {
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
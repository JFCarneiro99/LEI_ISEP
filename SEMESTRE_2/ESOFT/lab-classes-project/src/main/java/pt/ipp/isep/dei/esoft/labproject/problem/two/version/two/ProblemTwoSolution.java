package pt.ipp.isep.dei.esoft.labproject.problem.two.version.two;

public class ProblemTwoSolution {
    public static boolean sortStudentsByAscendingNumber(int[] studentNumbers, String[] studentNames,
                                                        int[] studentGrades) {
        if ((studentNumbers == null) || (studentNames == null) || (studentGrades == null)) {
            return false;
        }

        int arraySize = studentNumbers.length;
        //Sort the studentNumbers in ascending order using two for loops
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (studentNumbers[j] > studentNumbers[j + 1]) {
                    //swap elements if not in order - in studentNumbers
                    swapIntArrayElements(studentNumbers, j, j + 1);
                    //swap elements jf not jn order - in studentNames
                    swapStringArrayElements(studentNames, j, j + 1);
                    //swap elements jf not jn order - in studentGrades
                    swapIntArrayElements(studentGrades, j, j + 1);
                }
            }
        }
        return true;
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
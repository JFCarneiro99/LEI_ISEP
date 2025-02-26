package pt.ipp.isep.dei.esoft.labproject.problem.two.version.three;

public class ProblemTwoSolution {
    public static boolean sortStudentsByAscendingNumber(Student[] students) {
        if (students == null) {
            return false;
        }

        int arraySize = students.length;
        //Sort the students in ascending order using two for loops
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (students[j].number > students[j + 1].number) {
                    //swap elements if not in order - in students
                    swapStudentArrayElements(students, j, j + 1);
                }
            }
        }
        return true;
    }

    private static void swapStudentArrayElements(Student[] array, int indexOne, int indexTwo) {
        Student temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    public static boolean sortStudentsByDescendingGrade(Student[] students) {
        if (students == null) {
            return false;
        }

        int arraySize = students.length;
        //Sort the students in ascending order using two for loops
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                if (students[j].grade < students[j + 1].grade) {
                    //swap elements if not in order - in students
                    swapStudentArrayElements(students, j, j + 1);
                }
            }
        }
        return true;
    }
}
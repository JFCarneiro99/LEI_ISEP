package pt.ipp.isep.dei.esoft.labproject.problem.three.version.one.todo;

public class ProblemThree {
    public static boolean sortStudentsByAscendingNumber(Student[] students) {
        if (students == null) {
            return false;
        }

        int arraySize = students.length;
        //Sort the students in ascending order using two for loops
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize - i - 1; j++) {
                throw new UnsupportedOperationException(); //it means that the method is not implemented yet
                //TODO: Students should fix the errors in the following code

//                if (students[j].number > students[j + 1].number) {
//                    //swap elements if not in order - in students
//                    swapStudentArrayElements(students, j, j + 1);
//                }
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
                throw new UnsupportedOperationException(); //it means that the method is not implemented yet
                //TODO: Students should fix the errors in the following code

//                if (students[j].grade < students[j + 1].grade) {
//                    //swap elements if not in order - in students
//                    swapStudentArrayElements(students, j, j + 1);
//                }
            }
        }
        return true;
    }
}
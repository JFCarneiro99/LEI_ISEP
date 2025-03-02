package pt.ipp.isep.dei.esoft.labproject.problem.three.version.two.studentListWithArray.todo;

public class StudentList {

    // Attributes
    private Student[] students;

    public StudentList() {
        this.students = new Student[0];
    }
    // Constructors
    public StudentList(Student[] students) {
        if (students == null)
            throw new IllegalArgumentException("Students array should not be null");
        this.students = copyStudentsFromArray(students, students.length);
    }

    // Operations
    public void sortByAscendingNumber() {
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students.length - i - 1; j++) {
                if (students[j].compareToByGrade(students[j + 1]) < 0) {
                    //swap elements if not in order - in students
                    swapStudentArrayElements(students, j, j + 1);
                }
            }
        }
    }

    public void sortByDescendingGrade() {
        for (int i = 0; i < this.students.length; i++) {
            for (int j = 0; j < this.students.length - i - 1; j++) {
                if (students[j].compareToByGrade(students[j + 1]) < 0) {
                    //swap elements if not in order - in students
                    swapStudentArrayElements(students, j, j + 1);
                }
            }
        }
    }

    public Student[] toArray() {
        return copyStudentsFromArray(this.students, this.students.length);
    }

    public boolean add(Student student) {
        if (student == null)
            return false;
        if (this.exists(student))
            return false;
        this.students = copyStudentsFromArray(this.students, this.students.length + 1);
        this.students[this.students.length - 1] = student;
        return true;
    }

    public boolean remove(Student student) {
        if (student == null)
            return false;
        int idx = this.getIndexOf(student);
        if (idx < 0)
            return false;
        Student[] leftSide = this.copyStudentsFromArray(this.students, idx);
        Student[] rightSide = this.copyStudentsFromArray(this.students, idx + 1, this.students.length - idx - 1);
        this.students = this.join(leftSide, rightSide);
        return true;
    }

    private Student[] copyStudentsFromArray(Student[] students, int size) {
        Student[] copyArray = new Student[size];
        for (int count = 0; (count < size) && (count < students.length); count++) {
            copyArray[count] = students[count];
        }
        return copyArray;
    }

    private Student[] copyStudentsFromArray(Student[] students, int start, int size) {
        Student[] copyArray = new Student[size];
        int count = 0;
        for (int idx = start; (count < size) && (idx < students.length); idx++) {
            copyArray[idx - start] = students[idx];
            count++;
        }
        return copyArray;
    }

    private Student[] join(Student[] students1, Student[] students2) {
        int size = students1.length + students2.length;
        Student[] copyArray = new Student[size];
        for (int idx = 0; (idx < students1.length); idx++) {
            copyArray[idx] = students1[idx];
        }
        for (int idx = 0; (idx < students2.length); idx++) {
            copyArray[idx + students1.length] = students2[idx];
        }
        return copyArray;
    }

    private void swapStudentArrayElements(Student[] array, int indexOne, int indexTwo) {
        Student temp;
        temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private boolean exists(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student))
                return true;
        }
        return false;
    }

    private int getIndexOf(Student student) {
        int notFound = -1;
        if (student == null)
            return notFound;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == student)
                return i;
        }
        return notFound;
    }
}
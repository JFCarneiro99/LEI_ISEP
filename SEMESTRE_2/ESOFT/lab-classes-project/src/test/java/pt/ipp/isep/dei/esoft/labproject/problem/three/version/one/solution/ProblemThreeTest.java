package pt.ipp.isep.dei.esoft.labproject.problem.three.version.one.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemThreeTest {

    @DisplayName("Ensure sorting null students array by number returns false")
    @Test
    public void ensureSortingNullNumbersArrayByNumberReturnsFalse() {
        //Arrange
        Student[] students = null;

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting empty array by number works")
    @Test
    public void ensureSortingEmptyArraysByNumberWorks() {
        //Arrange
        Student[] students = {};
        Student[] expectedstudents = {};

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedstudents.length, students.length);

        // check array content
        assertArrayEquals(expectedstudents, students);
    }

    @DisplayName("Ensure sorting one element array by number works")
    @Test
    public void ensureSortingOneElementArraysByNumberWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);

        Student[] students = {studentOne};
        Student[] expectedStudents = {studentOne};

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting two sorted elements array by number works")
    @Test
    public void ensureSortingTwoSortedElementArraysByNumberWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);

        Student[] students = {studentOne, studentTwo};
        Student[] expectedStudents = {studentOne, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting two unsorted elements array by number works")
    @Test
    public void ensureSortingTwoUnsortedElementArraysByNumberWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);

        Student[] students = {studentTwo, studentOne};
        Student[] expectedStudents = {studentOne, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting unsorted array by number works")
    @Test
    public void ensureSortingUnsortedArraysByNumberWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);
        Student studentThree = new Student(1190432,"Martim Gomes Costa");
        studentThree.doEvaluation(17);
        Student studentFour = new Student(1181208,"Mariana Gonçalves Mendes");
        studentFour.doEvaluation(14);

        Student[] students = {studentOne, studentTwo, studentThree, studentFour};
        Student[] expectedStudents = {studentFour, studentThree, studentOne, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByAscendingNumber(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }


    @DisplayName("Ensure sorting null students array by grade returns false")
    @Test
    public void ensureSortingNullNumbersArrayByGradeReturnsFalse() {
        //Arrange
        Student[] students = null;

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting empty array by grade works")
    @Test
    public void ensureSortingEmptyArraysByGradeWorks() {
        //Arrange
        Student[] students = {};
        Student[] expectedstudents = {};

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedstudents.length, students.length);

        // check array content
        assertArrayEquals(expectedstudents, students);
    }

    @DisplayName("Ensure sorting one element array by grade works")
    @Test
    public void ensureSortingOneElementArraysByGradeWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);

        Student[] students = {studentOne};
        Student[] expectedStudents = {studentOne};

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting two sorted elements array by grade works")
    @Test
    public void ensureSortingTwoSortedElementArraysByGradeWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);

        Student[] students = {studentOne, studentTwo};
        Student[] expectedStudents = {studentOne, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting two unsorted elements array by grade works")
    @Test
    public void ensureSortingTwoUnsortedElementArraysByGradeWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);

        Student[] students = {studentTwo, studentOne};
        Student[] expectedStudents = {studentOne, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }

    @DisplayName("Ensure sorting unsorted array by grade works")
    @Test
    public void ensureSortingUnsortedArraysByGradeWorks() {
        //Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentTwo.doEvaluation(12);
        Student studentThree = new Student(1190432,"Martim Gomes Costa");
        studentThree.doEvaluation(17);
        Student studentFour = new Student(1181208,"Mariana Gonçalves Mendes");
        studentFour.doEvaluation(14);

        Student[] students = {studentOne, studentTwo, studentThree, studentFour};
        Student[] expectedStudents = {studentThree, studentOne, studentFour, studentTwo};

        // Act
        boolean result = ProblemThree.sortStudentsByDescendingGrade(students);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudents.length, students.length);

        // check array content
        assertArrayEquals(expectedStudents, students);
    }
}
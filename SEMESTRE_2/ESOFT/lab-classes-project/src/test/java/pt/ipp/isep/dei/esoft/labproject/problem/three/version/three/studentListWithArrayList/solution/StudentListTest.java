package pt.ipp.isep.dei.esoft.labproject.problem.three.version.three.studentListWithArrayList.solution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @DisplayName("Ensure creating a studentlist works")
    @Test
    public void ensureCreateStudentListWorks() {
        // Act
        StudentList stList = new StudentList(); // StudentList empty
        Student[] result = stList.toArray();

        //Assert
        assertEquals(0, result.length); // check array
    }

    @DisplayName("Ensure creating a studentlist with some elements works")
    @Test
    public void ensureCreateStudentListWithSomeElementsWorks() {
        // Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        Student studentThree = new Student(1190432,"Martim Gomes Costa");

        Student[] students = {studentOne,studentTwo,studentThree}; // Some order
        Student[] expected = {studentOne,studentTwo,studentThree}; // A copy of students

        // Act
        StudentList stList = new StudentList(students);
        students[2] = studentOne; // change the original array
        Student[] result = stList.toArray();

        //Assert
        assertArrayEquals(expected,result); // check students are the same
        assertNotSame(students, result);
    }

    @DisplayName("Ensure sorting an unsorted array by grade works")
    @Test
    public void ensureSortingUnsortedArraysByGradeWorks() {
        // Arrange
        Student studentOne = new Student(1200001,"Ana Maria Sousa");
        studentOne.doEvaluation(16);
        Student studentTwo = new Student(1200032,"André Pinto da Silva");
        studentOne.doEvaluation(12);
        Student studentThree = new Student(1190432,"Martim Gomes Costa");
        studentThree.doEvaluation(17);

        Student[] students = {studentOne,studentTwo,studentThree}; // Unordered
        StudentList stList = new StudentList(students);
        Student[] expected = {studentThree,studentOne,studentTwo}; // Ordered

        // Act
        stList.sortByDescendingGrade();
        Student[] result = stList.toArray();

        //Assert
        assertArrayEquals(expected,result); // check students are sorted
    }

    @DisplayName("Ensure add a different student when array not empty works")
    @Test
    public void ensureAddDifferentStudentWhenArrayNotEmptyWorks(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        Student studentTwo = new Student(1200145, "Sampaio");
        StudentList stList = new StudentList();
        stList.add(studentOne);

        // Act
        boolean result = stList.add(studentTwo);
        Student[] content = stList.toArray();

        //Assert
        assertTrue(result);
        assertEquals(2,content.length);
    }

    @DisplayName("Ensure add the same student twice fails")
    @Test
    public void ensureAddSameStudentTwiceFails(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        StudentList stList = new StudentList();
        stList.add(studentOne);

        // Act
        boolean result = stList.add(studentOne);
        Student[] content = stList.toArray();

        //Assert
        assertFalse(result);
        assertEquals(1,content.length);
    }

    @DisplayName("Ensure add a student with the same number fails")
    @Test
    public void ensureAddStudentWithSameNumberFails(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        Student studentTwo = new Student(1200054, "Sampaio");
        StudentList stList = new StudentList();
        stList.add(studentOne);

        // Act
        boolean result = stList.add(studentTwo);
        Student[] content = stList.toArray();

        //Assert
        assertFalse(result);
        assertEquals(1,content.length);
    }

    @DisplayName("ensure add null fails")
    @Test
    public void ensureAddNullFails(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        StudentList stList = new StudentList();
        stList.add(studentOne);

        // Act
        boolean result = stList.add(null);
        Student[] content = stList.toArray();

        //Assert
        assertFalse(result);
        assertEquals(1,content.length);
    }

    @DisplayName("Ensure remove the middle student in several works")
    @Test
    public void ensureRemoveMiddleStudentInSeveralWorks(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        Student studentTwo = new Student(1200154, "Sampaio");
        Student studentThree = new Student(1201154, "Costa");
        Student studentFour = new Student(1201354, "Lidia");
        Student studentFive = new Student(1101354, "Maria");

        Student[] all = {studentOne,studentTwo,studentThree,studentFour,studentFive};
        Student[] expected = {studentOne,studentTwo,studentThree,studentFive};
        StudentList stList = new StudentList(all);

        // Act
        boolean result = stList.remove(studentFour);
        Student[] content = stList.toArray();

        //Assert
        assertTrue(result);
        assertArrayEquals(expected,content);
    }

    @DisplayName("Ensure remove the same student twice returns false")
    @Test
    public void ensureRemoveSameStudentTwiceReturnsFalse(){
        // Arrange
        Student studentOne = new Student(1200054, "Moreira");
        StudentList stList = new StudentList();
        stList.add(studentOne);

        // Act
        boolean resultOne = stList.remove(studentOne);
        boolean resultTwo = stList.remove(studentOne);
        Student[] content = stList.toArray();

        //Assert
        assertTrue(resultOne);
        assertFalse(resultTwo);
        assertEquals(0,content.length);
    }
}
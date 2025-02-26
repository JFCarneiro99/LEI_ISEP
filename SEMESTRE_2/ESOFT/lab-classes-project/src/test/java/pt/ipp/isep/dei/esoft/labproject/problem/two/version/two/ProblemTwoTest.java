package pt.ipp.isep.dei.esoft.labproject.problem.two.version.two;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTwoTest {

    @DisplayName("Ensure sorting all null arrays returns false")
    @Test
    @Disabled
    public void ensureSortingAllNullArraysReturnsNull() {
        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(null, null, null);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting null numbers array returns false")
    @Test
    @Disabled
    public void ensureSortingNullNumbersArrayReturnsFalse() {
        //Arrange
        int[] studentNumbers = null;
        String[] studentNames = {};
        int[] studentGrades = {};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting null names array returns false")
    @Test
    @Disabled
    public void ensureSortingNullNamesArrayReturnsFalse() {
        //Arrange
        int[] studentNumbers = {};
        String[] studentNames = null;
        int[] studentGrades = {};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting null grades array returns false")
    @Test
    @Disabled
    public void ensureSortingNullGrasedArrayReturnsFalse() {
        //Arrange
        int[] studentNumbers = {};
        String[] studentNames = {};
        int[] studentGrades = null;

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        // Assert
        assertFalse(result); // check result is null
    }

    @DisplayName("Ensure sorting all empty arrays works")
    @Test
    @Disabled
    public void ensureSortingAllEmptyArraysWorks() {
        //Arrange
        int[] studentNumbers = {};
        String[] studentNames = {};
        int[] studentGrades = {};

        int[] expectedStudentNumbers = {};
        String[] expectedStudentNames = {};
        int[] expectedStudentGrades = {};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbers.length);
        assertEquals(expectedStudentNames.length, studentNames.length);
        assertEquals(expectedStudentGrades.length, studentGrades.length);

        // check array content
        assertArrayEquals(expectedStudentNumbers, studentNumbers);
        assertArrayEquals(expectedStudentNames, studentNames);
        assertArrayEquals(expectedStudentGrades, studentGrades);
    }

    @DisplayName("Ensure sorting one element array works")
    @Test
    @Disabled
    public void ensureSortingOneElementArraysWorks() {
        //Arrange
        int number = 1200001;
        String name = "Ana Maria Sousa";
        int grade = 16;

        int[] studentNumbers = {number};
        String[] studentNames = {name};
        int[] studentGrades = {grade};

        int[] expectedStudentNumbers = {number};
        String[] expectedStudentNames = {name};
        int[] expectedStudentGrades = {grade};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbers.length);
        assertEquals(expectedStudentNames.length, studentNames.length);
        assertEquals(expectedStudentGrades.length, studentGrades.length);

        // check array content
        assertArrayEquals(expectedStudentNumbers, studentNumbers);
        assertArrayEquals(expectedStudentNames, studentNames);
        assertArrayEquals(expectedStudentGrades, studentGrades);
    }

    @DisplayName("Ensure sorting two sorted elements array works")
    @Test
    @Disabled
    public void ensureSortingTwoSortedElementArraysWorks() {
        //Arrange
        int[] studentNumbers = {1200001, 1200032};
        String[] studentNames = {"Ana Maria Sousa", "André Pinto da Silva"};
        int[] studentGrades = {16, 12};

        int[] expectedStudentNumbers = {1200001, 1200032};
        String[] expectedStudentNames = {"Ana Maria Sousa", "André Pinto da Silva"};
        int[] expectedStudentGrades = {16, 12};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbers.length);
        assertEquals(expectedStudentNames.length, studentNames.length);
        assertEquals(expectedStudentGrades.length, studentGrades.length);

        // check array content
        assertArrayEquals(expectedStudentNumbers, studentNumbers);
        assertArrayEquals(expectedStudentNames, studentNames);
        assertArrayEquals(expectedStudentGrades, studentGrades);
    }

    @DisplayName("Ensure sorting two sorted elements array works")
    @Test
    @Disabled
    public void ensureSortingTwoUnsortedElementArraysWorks() {
        //Arrange
        int[] studentNumbers = {1200032, 1200001};
        String[] studentNames = {"André Pinto da Silva", "Ana Maria Sousa"};
        int[] studentGrades = {12, 16};

        int[] expectedStudentNumbers = {1200001, 1200032};
        String[] expectedStudentNames = {"Ana Maria Sousa", "André Pinto da Silva"};
        int[] expectedStudentGrades = {16, 12};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbers.length);
        assertEquals(expectedStudentNames.length, studentNames.length);
        assertEquals(expectedStudentGrades.length, studentGrades.length);

        // check array content
        assertArrayEquals(expectedStudentNumbers, studentNumbers);
        assertArrayEquals(expectedStudentNames, studentNames);
        assertArrayEquals(expectedStudentGrades, studentGrades);
    }

    @DisplayName("Ensure sorting unsorted array works")
    @Test
    @Disabled
    public void ensureSortingUnsortedArraysWorks() {
        //Arrange
        int[] studentNumbers = {1200001, 1200032, 1190432, 1181208};
        String[] studentNames =
                {"Ana Maria Sousa", "André Pinto da Silva", "Martim Gomes Costa", "Mariana Gonçalves Mendes"};
        int[] studentGrades = {16, 12, 17, 14};

        int[] expectedStudentNumbers = {1181208, 1190432, 1200001, 1200032};
        String[] expectedStudentNames =
                {"Mariana Gonçalves Mendes", "Martim Gomes Costa", "Ana Maria Sousa", "André Pinto da Silva"};
        int[] expectedStudentGrades = {14, 17, 16, 12};

        // Act
        boolean result = ProblemTwo.sortStudentsByAscendingNumber(studentNumbers, studentNames, studentGrades);

        //Assert
        assertTrue(result);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbers.length);
        assertEquals(expectedStudentNames.length, studentNames.length);
        assertEquals(expectedStudentGrades.length, studentGrades.length);

        // check array content
        assertArrayEquals(expectedStudentNumbers, studentNumbers);
        assertArrayEquals(expectedStudentNames, studentNames);
        assertArrayEquals(expectedStudentGrades, studentGrades);
    }
}
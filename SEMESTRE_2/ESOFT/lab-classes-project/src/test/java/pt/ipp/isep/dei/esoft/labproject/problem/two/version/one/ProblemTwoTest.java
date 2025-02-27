package pt.ipp.isep.dei.esoft.labproject.problem.two.version.one;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTwoTest {

    @DisplayName("Ensure testing arrays individually fails")
    @Test
    public void ensureIndividuallyTestingArraysFails() {
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
        int[] studentNumbersResult = ProblemTwo.sortIntArrayAscending(studentNumbers);
        String[] studentNamesResult = ProblemTwo.sortStringArrayAscending(studentNames);
        int[] studentGradesResult = ProblemTwo.sortIntArrayAscending(studentGrades);

        //Assert

        // check the input array is the same as output
        assertSame(studentNumbers, studentNumbersResult);
        assertSame(studentNames, studentNamesResult);
        assertSame(studentGrades, studentGradesResult);

        //check dimension
        assertEquals(expectedStudentNumbers.length, studentNumbersResult.length);
        assertEquals(expectedStudentNames.length, studentNamesResult.length);
        assertEquals(expectedStudentGrades.length, studentGradesResult.length);

        // check array content
        assertNotEquals(expectedStudentNumbers, studentNumbersResult);
        assertNotEquals(expectedStudentNames, studentNamesResult);
        assertNotEquals(expectedStudentGrades, studentGradesResult);
    }
}
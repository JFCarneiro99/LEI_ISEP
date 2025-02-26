package pt.ipp.isep.dei.esoft.labproject.problem.one.version.two;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemOneSolutionTest {

    @DisplayName("Ensure sorting a null array returns null")
    @Test
    public void ensureSortingNullArrayReturnsNull() {
        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(null);

        // Assert
        assertNull(result); // check result is null
    }

    @DisplayName("Ensure sorting an array with two elements works")
    @Test
    public void ensureSortingAnEmptyArrayWorks() {
        // Arrange
        int[] data = {};
        int[] expected = {};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        //Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content}
    }

    @DisplayName("Ensure sorting an array with one element works")
    @Test
    public void ensureSortingOneElementArrayWorks() {
        // Arrange
        int[] data = {4};
        int[] expected = {4};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        // Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content
    }

    @DisplayName("Ensure sorting an array with two (already sorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoSortedElementsWorks() {
        // Arrange
        int[] data = {-1, 4};
        int[] expected = {-1, 4};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        //Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content
    }

    @DisplayName("Ensure sorting an array with two (unsorted) elements works.")
    @Test
    public void ensureSortingArrayWithTwoUnsortedElementsWorks() {
        // Arrange
        int[] data = {30, 25};
        int[] expected = {25, 30};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        // Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content
    }

    @DisplayName("Ensure sorting an array with two equal elements works.")
    @Test
    public void ensureSortingArrayWithTwoEqualElementsWorks() {
        // Arrange
        int[] data = {30, 30};
        int[] expected = {30, 30};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        // Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content
    }

    @DisplayName("Ensure sorting an array with several unordered elements works.")
    @Test
    public void ensureSortingArrayWithSeveralUnsortedElementsWorks() {
        // Arrange
        int[] data = {30, 25, 25, -1, 20};
        int[] expected = {-1, 20, 25, 25, 30};

        // Act
        int[] result = ProblemOneSolution.sortArrayAscending(data);

        // Assert
        assertSame(data, result); // check the input array is the same as output

        assertEquals(expected.length, result.length); // check dimension

        assertArrayEquals(expected, result); // check array content
    }
}
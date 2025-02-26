package pt.ipp.isep.dei.esoft.labproject.problem.three.version.two.studentListWithArray.todo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @DisplayName("Ensure creating a valid student works")
    @Test
    @Disabled
    public void ensureCreateValidStudentWorks(){
        // Arrange + Act
        Student student = new Student( 1190001, "Paulo");
        // Assert
        assertNotNull(student);
    }

    @DisplayName("Ensure creating a student with six digits negative number fails")
    @Test
    @Disabled
    public void ensureCreateStudentWith6DigitsNegativeNumberFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(-190001, "Paulo Maio");
        });
    }

    @DisplayName("Ensure creating a student with seven digits negative number fails")
    @Test
    @Disabled
    public void ensureCreateStudentWith7DigitsNegativeNumberFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(-1190001, "Paulo Maio");
        });
    }

    @DisplayName("Ensure creating a student with longer digits number fails")
    @Test
    @Disabled
    public void ensureCreateStudentWithLongerDigitsNumberFails(){
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(11900013, "Paulo Maio");
        });
    }

    @DisplayName("Ensure creating a student with empty name fails")
    @Test
    @Disabled
    public void ensureCreateStudentWithEmptyNameFails(){
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(1190001, "");
        });
    }

    @DisplayName("Ensure creating a student with name full of spaces fails")
    @Test
    @Disabled
    public void ensureCreateStudentWithNameFullOfSpacesFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(1190001, " ");
        });
    }

    @DisplayName("Ensure creating a student with short name length fails")
    @Test
    @Disabled
    public void ensureCreateStudentWithShortNameLengthFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(1190001, "Rui");
        });
    }

    @DisplayName("Ensure creating a student with a valid number but invalid name fails")
    @Test
    @Disabled
    public void ensureCreateStudentWithValidNumberButInvalidNameFails(){
        assertThrows(IllegalArgumentException.class, () -> {
            Student student = new Student(1980398, "Bia");
        });
    }

    @DisplayName("Ensure equals true due to the same student number")
    @Test
    @Disabled
    public void ensureEqualsTrueDueToSameNumber() {
        // Arrange
        Student studentOne = new Student( 1980398, "Beatriz");
        Student studentTwo = new Student( 1980398, "Beatriz Costa");
        // Act
        boolean result = studentOne.equals(studentTwo);
        // Assert
        assertTrue(result);
    }

    @DisplayName("Ensure equals true to itself")
    @Test
    @Disabled
    public void ensureEqualsTrueToItself() {
        // Arrange
        Student studentOne = new Student( 1980398, "Beatriz");
        // Act + Assert
        assertTrue(studentOne.equals(studentOne));
    }

    @DisplayName("Ensure equals false due to null")
    @Test
    @Disabled
    public void ensureEqualsFalseDueToNull() {
        // Arrange
        Student studentOne = new Student( 1980398, "Beatriz");
        // Act
        boolean result = studentOne.equals(null);
        // Assert
        assertFalse(result);
    }

    @DisplayName("Ensure equals false due to different type")
    @Test
    @Disabled
    public void ensureEqualsFalseDueToDifferentType() {
        // Arrange
        Student studentOne = new Student( 1980398, "Beatriz");
        // Act
        boolean result = studentOne.equals(new String("1980398"));
        // Assert
        assertFalse(result);
    }

    @DisplayName("Ensure equals false due to different numbers")
    @Test
    @Disabled
    public void ensureEqualsFalseDueToDifferentNumbers() {
        // Arrange
        Student studentOne = new Student( 1980398, "Beatriz");
        Student studentTwo = new Student( 1980399, "Beatriz Costa");
        // Act
        boolean result = studentOne.equals(studentTwo);
        // Assert
        assertFalse(result);
    }
}
package pt.ipp.isep.dei.esoft.labproject.problem.three.version.one.todo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
package pt.ipp.isep.dei.esoft.labproject.problem.three.version.three.studentListWithArrayList.solution;

public class Student {

    // Attributes
    private int number;
    private String name;
    private int grade;

    // Constructor
    public Student(int number, String name) {
        if (!this.isValidNumber(number))
            throw new IllegalArgumentException("Student number needs to be 7 digits number (e.g. 1190001).");

        if (!this.isValidName(name))
            throw new IllegalArgumentException("Student name cannot be shorter than 5 chars.");

        this.number = number;
        this.name = name.trim();
        this.grade = -1; // -1 means student hasn't been evaluated
    }

    // Operations
    public int getNumber(){
        return this.number; // type is "int" so a copy of the value is return
    }

    public int getGrade(){
        return this.grade; // type is "int" so a copy of the value is return
    }

    private boolean isValidNumber(int number) {
        if (number != Math.abs(number))
            return false;

        String strNumber = Integer.toString(number);
        return (strNumber.length() == 7);
    }

    private boolean isValidName(String name) {
        if (name == null)
            return false;

        name = name.trim();
        return !(name.length() < 5);
    }

    private boolean isValidGrade(int grade) {
        return grade >= 0 && grade <=20;
    }

    private boolean isEvaluated() {
        return this.grade!=-1;
    }

    public void doEvaluation(int grade) {
        if (!this.isEvaluated() && this.isValidGrade(grade))
            this.grade = grade;
    }

    // Operations (Behaviour)
    public boolean isApproved() {
        return (this.grade >= 10);
    }

    public int compareToByNumber(Student other) {
        if (this.number < other.number) {
            return -1; // lesser than other
        } else if (this.number > other.number) {
            return 1; // greater than other
        } else {
            return 0; // both have the same value
        }
    }

    public int compareToByGrade(Student other) {
        if (this.grade < other.grade) {
            return -1; // lesser than other
        } else if (this.grade > other.grade) {
            return 1; // greater than other
        } else {
            return 0; // both have the same value
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        Student student = (Student) other;

        return (this.number == student.number);
    }
}
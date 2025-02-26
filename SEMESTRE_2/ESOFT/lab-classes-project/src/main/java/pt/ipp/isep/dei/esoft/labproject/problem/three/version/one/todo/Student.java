package pt.ipp.isep.dei.esoft.labproject.problem.three.version.one.todo;

public class Student {

    // Attributes
    private int number;
    private String name;
    private int grade;

    // Constructor
    public Student(int number, String name) {
        throw new UnsupportedOperationException(); //it means that the constructor is not implemented yet
        //TODO: Students should implement this constructor
    }

    // Operations
    private boolean isValidNumber(int number) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }
    private boolean isValidName(String name) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    private boolean isValidGrade(int grade) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    private boolean isEvaluated() {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public void doEvaluation(int grade) {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public boolean isApproved() {
        return (this.grade >= 10);
    }
}
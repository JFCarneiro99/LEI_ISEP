package pt.ipp.isep.dei.esoft.labproject.problem.three.version.three.studentListWithArrayList.todo;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentList {

    // Attributes
    private ArrayList<Student> students;

    // Constructors
    public StudentList() {
        throw new UnsupportedOperationException(); //it means that the constructor is not implemented yet
        //TODO: Students should implement this constructor
    }

    public StudentList(Student[] students) {
        if (students == null)
            throw new IllegalArgumentException("Students arraylist should not be null");
        this.students = new ArrayList();
        for (Student st : students) {
            this.add(st);
        }
    }

    // Operations

    public void sortByAscendingNumber() {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public void sortByDescendingGrade() {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public Student[] toArray() {
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public boolean add(Student student){
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    public boolean remove(Student student){
        throw new UnsupportedOperationException(); //it means that the method is not implemented yet
        //TODO: Students should implement this method
    }

    private class SortByAscendingNumberComparator implements Comparator<Student> {
        public int compare(Student st1, Student st2) {
            throw new UnsupportedOperationException(); //it means that the method is not implemented yet
            //TODO: Students should implement this method
        }
    }
    private class SortByDescendingGradeComparator implements Comparator<Student> {
        public int compare(Student st1, Student st2) {
            throw new UnsupportedOperationException(); //it means that the method is not implemented yet
            //TODO: Students should implement this method
        }
    }
}
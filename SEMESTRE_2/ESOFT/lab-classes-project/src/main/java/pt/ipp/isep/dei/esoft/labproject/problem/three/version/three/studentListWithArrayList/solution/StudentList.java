package pt.ipp.isep.dei.esoft.labproject.problem.three.version.three.studentListWithArrayList.solution;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentList {

    // Attributes
    private ArrayList<Student> students;

    // Constructors
    public StudentList() {
        this.students = new ArrayList();
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
        this.students.sort(new SortByAscendingNumberComparator());
    }

    public void sortByDescendingGrade() {
        this.students.sort(new SortByDescendingGradeComparator());
    }

    public Student[] toArray() {
        Student[] array = new Student[this.students.size()];
        return this.students.toArray(array);
    }

    public boolean add(Student student){
        if (student == null)
            return false;
        if (this.students.contains(student))
            return false;
        return this.students.add(student);
    }

    public boolean remove(Student student){
        if (student == null)
            return false;
        if (!this.students.contains(student))
            return false;
        return this.students.remove(student);
    }

    private class SortByAscendingNumberComparator implements Comparator<Student> {
        public int compare(Student st1, Student st2) {
            return st1.compareToByNumber(st2);
        }
    }
    private class SortByDescendingGradeComparator implements Comparator<Student> {
        public int compare(Student st1, Student st2) {
            return st1.compareToByGrade(st2)*(-1);
        }
    }
}
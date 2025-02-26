package pt.ipp.isep.dei.esoft.labproject.problem.three.version.two.studentListWithArray.todo;

public class MainToEquals {

    public static void checkingObjectEquality() {
        Student st1 = new Student(1200327, "Paulo");
        st1.doEvaluation(19);

        Student st2 = st1;

        Student st3 = new Student(1200327, "Paulo");
        st3.doEvaluation(19);

        Student st4 = new Student(1200327, "Ritinha");
        st4.doEvaluation(20);

        System.out.println("st1 is equal to st2: " + (st1 == st2));
        System.out.println("st1 is equal to st3: " + (st1 == st3));
        System.out.println("st1 is equal to st4: " + (st1 == st4));
    }

    public static void checkingObjectEquality2() {
        Student st1 = new Student(1200327, "Paulo");
        st1.doEvaluation(19);

        Student st2 = st1;

        Student st3 = new Student(1200327, "Paulo");
        st3.doEvaluation(19);

        Student st4 = new Student(1200327, "Ritinha");
        st4.doEvaluation(20);

        System.out.println("st1 is equal to st2: " + (st1.equals(st2)));
        System.out.println("st1 is equal to st3: " + (st1.equals(st3)));
        System.out.println("st1 is equal to st4: " + (st1.equals(st4)));
    }

    public static void main(String[] args) {
        System.out.println("Checking Object Equality\n");
        checkingObjectEquality();

        System.out.println("\nChecking Object Equality 2\n");
        checkingObjectEquality2();
    }
}
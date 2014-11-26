package q3;

import java.text.NumberFormat;

/**
 * <p>Tests testScore methods created in Student.java.</p>
 *
 * @author Dennis Chau
 * @version 1.0
 */
public class TestStudent {
    /**
     * <p>Creates a student object and invokes setTestscore
     * and getTestScore.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {

        NumberFormat fmt = NumberFormat.getPercentInstance();
        final int test3 = 3;
        final double test1Score = 0.5;
        final double test3Score = 0.75;
        Student student = new Student();
        System.out.println("Orginal state of student:");
        System.out.println("-----------------------------");
        System.out.println(student);
        // Prevent checking of test numbers outside of 1-3
        do {
            try {
                student.setTestScore(1, test1Score);
                student.setTestScore(2, 1); 
                student.setTestScore(test3, test3Score);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter either 1, 2 or 3 for "
                        + "selecting a test.");
            }
        } while (true);
        System.out.println("\nNew state of student:");
        System.out.println("----------------------------");
        System.out.println("Get methods:");
        do {
            try {
                System.out.println("Test1: " 
                        + fmt.format(student.getTestScore(1)));
                System.out.println("Test2: " 
                        + fmt.format(student.getTestScore(2)));
                System.out.println("Test3: " 
                        + fmt.format(student.getTestScore(test3)));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter either 1, 2 or 3 for "
                        + "selecting a test.");
            }
        } while (true);
        System.out.println("Average: " + fmt.format(student.average()));
        System.out.println("\n" + student);
        System.out.println("\nQuestion three was called and ran sucessfully.");
    }

};

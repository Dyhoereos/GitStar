package q4;

import q3.Address;
import q3.Student;
/**
 * <p>This class adds Student objects to a Course object. The course's 
 * average grades and roster are then printed.</p>
 *
 * @author Dennis Chau
 * @version 1.0
 */
public class TestCourse {
    /** Course object for this class. */
    private static Course hockey101; 
    /**
     * <p>Address objects are created, which are then used to create
     * Student objects. Students are added to a Course Object. Methods
     * for calculating the Course average and roster are invoked.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        //Student test scores as fractions
        final double student1Scores = 0.33;
        final double student2Scores = 0.22;
        final double student3Scores = 0.17;
        final double student4Scores = 0.14;
        final double student5Scores = 0.20;

        hockey101 = new Course("Canucks");
        // create home addresses and one school address
        Address hHome = new Address("605 Expo Blvd.", "Vancouver", "BC",
                "V6B 1V4");
        Address dHome = new Address("4500 Still Creek Drive", "Burnaby", "BC",
                "V6B 1V5");
        Address rHome = new Address("9151 Bridgeport Road", "Richmond", "BC",
                "V6B 1V6");
        Address aHome = new Address("3550 Brighton Ave.", "Burnaby", "BC",
                "V6B 1V7");
        Address cHome = new Address("7423 King George Hwy.", "Surrey", "BC",
                "V6B 1V8");
        Address school = new Address("800 Griffiths Way", "Vancouver", "BC",
                "V6B 6G1");
        Student student1 = new Student("Henrik", "Sedin", hHome, school, 
                student1Scores, student1Scores, student1Scores);
        Student student2 = new Student("Daniel", "Sedin", dHome, school, 
                student2Scores, student2Scores, student2Scores);
        Student student3 = new Student("Radim", "Vrbata", rHome, school, 
                student3Scores, student3Scores, student3Scores);
        Student student4 = new Student("Alex", "Burrows", aHome, school, 
                student4Scores, student4Scores, student4Scores);
        Student student5 = new Student("Chris", "Higgins", cHome, school, 
                student5Scores, student5Scores, student5Scores);
        //catch an exception if more than 5 students are added
        try {
            hockey101.addStudent(student1);
            hockey101.addStudent(student2);
            hockey101.addStudent(student3);
            hockey101.addStudent(student4);
            hockey101.addStudent(student5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: class is full, "
                    + "cannot add further students.");
        }
        System.out.println("\nThe class average is " + printAverage());
        System.out.println("The students in the class are: \n" 
                + hockey101.roll()); 

        System.out.println("Question four was called and ran sucessfully.");
    }

    /** Test if no students are enrolled.
     * @return class average */ 
    private static String printAverage() {
        String average = "";
        try {
            average = hockey101.average();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Cannot find average with no students."
                    + " Enroll students first.");
        }
        return average;
    }

};

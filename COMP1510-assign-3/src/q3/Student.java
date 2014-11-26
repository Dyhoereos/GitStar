package q3;

import java.text.NumberFormat;

/**
 * Represents a college student.
 * @author Lewis Loftus
 * @author Dennis Chau
 * @version 2.0
 */
public class Student {
    /** Number of tests. */
    private static final int THREE = 3;
    /** First name of this student. */
    private String firstName;
    /** Last name of this student. */
    private String lastName;
    /** Home address of this student. */
    private Address homeAddress;
    /** School address of this student.  Can be shared by other students */
    private Address schoolAddress;
    /** Score for test 1. */
    private double testScore1;
    /** Score for test 2. */
    private double testScore2;
    /** Score for test 3. */
    private double testScore3;
    /**
    * Constructor: Sets up this student with the specified values.
    * @param first The first name of the student
    * @param last The last name of the student
    * @param home The home address of the student
    * @param school The school address of the student
    * @param score1 The first test score
    * @param score2 The second test score
    * @param score3 The third test score
    */
    public Student(String first, String last, Address home, Address school, 
            double score1, double score2, double score3) {
        firstName = first;
        lastName = last;
        homeAddress = home;
        schoolAddress = school;
        testScore1 = score1;
        testScore2 = score2;
        testScore3 = score3;
    }
    /** Zero-parameter constructor for student. Sets test scores to 0.*/ 
    public Student() { }
    /** Sets student test scores.
     * @param test Test number
     * @param score Test score as a decimal. */
    public void setTestScore(int test, double score) {
        // check if test to set is 1-3
        if (test > THREE || test < 1) {
            throw new IllegalArgumentException();
        }
        String testNum = "testScore" + test;
        if (testNum.equals("testScore1")) {
            testScore1 = score;
        } else if (testNum.equals("testScore2")) {
            testScore2 = score;
        } else if (testNum.equals("testScore3")) {
            testScore3 = score;
        }
    }
    /** Gives the student test score based on test number passed in.
     *  @param test Test number
     *  @return The requested test score  */
    public double getTestScore(int test) {
        // check if test to get is 1-3
        if (test > THREE || test < 1) {
            throw new IllegalArgumentException();
        }
        String testNum = "testScore" + test;
        if (testNum.equals("testScore1")) {
            return testScore1;
        } else if (testNum.equals("testScore2")) {
            return testScore2;
        } else if (testNum.equals("testScore3")) {
            return testScore3;
        } else {
            return 0;
        }
    }
    /** Calculates the average from all three tests. 
     * @return Average score*/ 
    public double average() {
        final int numTests = 3;
        return ((testScore1 + testScore2 + testScore3) / numTests);
    }
    /**
    * Returns a string description of this Student object.
    * @return formatted name and addresses of student
    */
    public String toString() {
        String result;
        NumberFormat fmt = NumberFormat.getPercentInstance();
        result = firstName + " " + lastName + "\n";
        result += "Home Address:\n" + homeAddress + "\n";
        result += "School Address:\n" + schoolAddress + "\n";
        result += "Test 1: " + fmt.format(testScore1) + "\n";
        result += "Test 2: " + fmt.format(testScore2) + "\n";
        result += "Test 3: " + fmt.format(testScore3) + "\n";
        result += "Average Score: " + fmt.format(average()) + "\n";
        
        return result;
    }
    /** Gets the full name of the student. 
     * @return Student full name*/
    public String getName() {
        return firstName + " " + lastName;
    }
}


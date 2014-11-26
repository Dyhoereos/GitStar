package q4;

import java.text.NumberFormat;
import java.util.ArrayList;
import q3.Student;
/**
 * Represents a college student.
 * @author Lewis Loftus
 * @author Dennis Chau
 * @version 2
 */
public class Course {
    /** Class size. */
    private static final int FIVE = 5;
    /** The name of the course. */
    private String courseName;
    /** The list of students. */
    private ArrayList<Student> enrolled = new ArrayList<Student>();
    /** Constructor for a course. 
     * @param name Course name
     */
    public Course(String name) {
        courseName = name;

    }
    /** Mutator to add a Student object to the class
     * Throws an exception if class size is at 5 or greater. 
     * @param person A Student object*/
    public void addStudent(Student person) {
        if (enrolled.size() < FIVE) {
            enrolled.add(person);
            System.out.println("The class now has " + enrolled.size() 
                    + " students.");
        } else {
            throw new IllegalArgumentException("Class is full!"); 
        }
    }
    /** Calculates the average for the class with Student.average 
     * throws an exception if class size is 0 to prevent from 
     * dividing by 0.
     * @return average score
     */
    public String average() {
        NumberFormat fmt = NumberFormat.getPercentInstance();
        double totalScore = 0;
        if (enrolled.size() == 0) {
            throw new IllegalArgumentException(); 
        }
        for (Student person : enrolled) {
            totalScore += person.average();
        }
        return fmt.format(totalScore / enrolled.size());
    }
    /** Returns the names of the Students in the Course using the
     * getName() method for Student objects.
     * @return student names
     */
    public String roll() {
        if (enrolled.size() > 0) {
            String list = "";
            for (Student person : enrolled) {
                list += person.getName() + "\n";
            }
            return list;
        } else {
            return "No students are enrolled in this class.";
        }
    }
    /** Accessor method for the name of the course.
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /** Mutator method for the name of the course.
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    /** Accessor method for the number of students in the course. 
     * @return number of students*/
    public int getNumStudents() {
        return enrolled.size();
    }
}

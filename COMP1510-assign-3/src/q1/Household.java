package q1;

import java.text.NumberFormat;


/**
 * <p>Class for creating household objects, which contain
 * ID numbers, annual income and number of people in
 * the household.</p>
 *
 * @author Dennis Chau
 * @version 1.0
 */
public class Household {
    /** Household ID number. */
    private int idNum;
    /** Household annual income. */
    private int annualIncome;
    /** Number of people in household. */
    private int householdMembers;
    /** Household constructor that takes only ID number.
     * @param id ID number. 
     * */
    public Household(int id) {
        idNum = id;
    }
    /** Household constructor that takes 
     * ID number, income and number of people. 
     * @param id the ID number.
     * @param income household income.
     * @param members number of people.
     */
    public Household(int id, int income, int members) {
        idNum = id;
        annualIncome = income;
        if (members == 0 && id != 0 && annualIncome != 0) {
            throw new IllegalArgumentException();
        }
        householdMembers = members;
    }
    /** Describes household with a string. 
     * @return household description.*/
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return idNum + "\t\t\t" + fmt.format(annualIncome) 
                + "\t" + householdMembers;
    }
    /** Gets ID number. 
     * @return ID number.*/
    public int getID() {
        return idNum;
    }
    /** Gets income. 
     * @return income.*/
    public int getIncome() {
        return annualIncome;
    }
    /** Gets number of people. 
     * @return number of people*/
    public int getMembers() {
        return householdMembers;
    }
};

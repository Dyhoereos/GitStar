package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class parses a survey stored in a text file and determines average
 * household income, number of households above the average income and
 * percentage of households below the low income cut-off level.
 * 
 * @version 1.0
 * @author Dennis Chau
 * */

public class Survey {
    

    /**
     * <p>
     * Reads text file into household objects and stores in an arraylist. The
     * households are analyzed and the results are printed to the console.
     * </p>
     *
     * @param args unused.
     * @throws FileNotFoundException when file not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        NumberFormat currencyFmt = NumberFormat.getCurrencyInstance();
        NumberFormat percentFmt = NumberFormat.getPercentInstance();
        ArrayList<Household> householdList = new ArrayList<Household>();
        Scanner fileScan = new Scanner(new File("src/q1/survey.txt"));
        Household family;
        int incomeSum = 0;
        double average;
        double belowLICO = 0;
        while (fileScan.hasNext()) {
            //prevent characters other than integers from being read in;
            //prevent entries with non-zero income with zero household members
            try {
                family = new Household(fileScan.nextInt(), fileScan.nextInt(),
                        fileScan.nextInt());
                incomeSum += family.getIncome();
                if (family.getMembers() != 0) {
                    householdList.add(family);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: there was an error with one "
                        + "household in the text file. That line and "
                        + "the lines below are omitted. Fix the "
                        + "line and rerun the app.\n");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: there cannot be a non-zero income "
                        + "with zero household members.\n");
            }
        }
        fileScan.close();
        System.out.println("There are " + householdList.size()
                + " households in the survey.\n\nIdentification Number"
                + "\tAnnual Income\tHousehold Members\n"
                + "--------------------------------------------------"
                + "-------");
        for (Household unit : householdList) {
            System.out.println(unit);
        }
        average = (double) incomeSum / householdList.size();
        System.out.println("\nAverage income: " + currencyFmt.format(average)
                + "\n\nHouseholds that exceed "
                + "the household income: \nIdentification Number"
                + "\tAnnual Income\n----------------------------------------");
        for (Household unit : householdList) {
            int income = unit.getIncome();
            int people = unit.getMembers();
            if (income > average) {
                System.out.println(unit.getID() + "\t\t\t"
                        + currencyFmt.format(unit.getIncome()));
            }
            if (determineLICO(people, income)) {
                belowLICO++;
            }
        }
        System.out.println("\n"
                + percentFmt.format(belowLICO / householdList.size())
                + " are below the LICO cutoff\n");
        System.out.println("Question one was called and ran sucessfully.");
    }

    /**
     * Determine above or below LICO.
     * 
     * @return True or false for below or above LICO.
     * @param people Size of household.
     * @param income Household income.
     */
    private static boolean determineLICO(int people, int income) {
        final int one = 22229;
        final int two = 27674;
        final int three = 34022;
        final int four = 41307;
        final int five = 46850;
        final int six = 52838;
        final int seven = 58827;
        final int minimum = 5989;
        int cutoff = 0;
        switch (people) {
        case 0:
            cutoff = 0;
            break;
        case 1:
            cutoff = one;
            break;
        case 2:
            cutoff = two;
            break;
        case 2 + 1:
            cutoff = three;
            break;
        case 2 + 2:
            cutoff = four;
            break;
        case 2 + 2 + 1:
            cutoff = five;
            break;
        case 2 + 2 + 2:
            cutoff = six;
            break;
        case 2 + 2 + 2 + 1:
            cutoff = seven;
            break;
        default:
            cutoff = seven + (minimum * (people - (2 + 2 + 2 + 1)));
        }
        return income <= cutoff;
    }
}

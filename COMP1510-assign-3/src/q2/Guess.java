package q2;

import java.util.Scanner;

/**
 * <p>This is a game of high-low. The computer chooses a number
 * and after each user guess the computer informs if the guess is too
 * high or low.</p>
 *
 * @author Dennis Chau
 * @version 1.0
 */
public class Guess {
    /** Upper range for numbers to be selected by the program. */
    private static final int UPPER_LIMIT = 100;

    /**
     * <p>Generates a random number between 0 and UPPER_LIMIT.
     * do while loops allows the user to continue playing until
     * the user chooses to quit.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String keepGoing;
        // new game loop
        do {
            int guess;
            int guesses = 0;
            int answer = (int) (Math.random() * UPPER_LIMIT) + 1;
            boolean quit = false;

            System.out.println("I'm thinking of an integer between 1 "
                    + "and " + UPPER_LIMIT + ", inclusive.");
            // guessing loop
            do {
                System.out.println("\nGuess the number or enter 0 to quit.");
                guesses++;
                guess = testNum();
                if (guess != 0) {
                    if (guess == answer) {
                        System.out.println("That's correct! It took you " 
                                + guesses + " tries to guess the number.");
                        break;
                    } else if (guess < answer) {
                        System.out.print("Nope, higher.");
                    } else if (guess > answer) {
                        System.out.print("Nope, lower");
                    }
                } else {
                    System.out.println("Oh too bad, the answer was " 
                            + answer + ".");
                    quit = true;
                }
            } while (!quit);
            System.out.println("\nDo you wish to play again? Type \"no\" "
                    + "to quit or press enter to play again.");
            keepGoing = in.nextLine();
        } while (!keepGoing.toLowerCase().equals("no"));
        in.close();

        System.out.println("Question two was called and ran sucessfully.");
    }

    /** Test for integer input. 
     * @return Guess integer*/
    @SuppressWarnings("resource")
    private static int testNum() {
        int guess = 0;
        Scanner in = new Scanner(System.in);
        try {
            guess = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("That's not an integer! Enter an integer:");
            // call testnum() until an integer is entered
            return testNum();
        }
        return guess;
    }
}



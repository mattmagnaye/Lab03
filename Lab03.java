import java.util.Random;
import java.util.Scanner;

/**
 * This is a simple guessing game. The player has 5 tries to guess a number
 * between 0 - 100. If the user cannot guess it right within 5 tries, he loses.
 * 
 * @author Matt Magnaye and Pedro Orellana
 * @since 04/07/2023
 */

public class Lab03 {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * main entry point of the program, and place where all the business logic
     * happens. no arguments required
     * 
     * @param args
     */
    public static void main(String[] args) {

        Random random = new Random();
        boolean tryAgain = true;

        System.out.println("Welcome to Matt and Pedro's guessing game!");

        while (tryAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numTries = 5;
            boolean win = false;

            System.out.println("I'm thinking of a number between 1 and 100. You have " + numTries + " tries.");

            while (numTries > 0) {
                String counter = "Guess #" + (6 - numTries) + ": ";
                System.out.print(counter);
                int guess = getUserGuess(counter);

                if (guess == numberToGuess) {
                    win = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                numTries--;
            }

            if (win) {
                System.out.println("Congratulations, you guessed it!");
            } else {
                System.out.println("Sorry, you lost. The number was " + numberToGuess + ".");
            }

            tryAgain = checkIfPlayAgain();
        }

        System.out.println("Thank you for playing! Matt and Pedro's guessing game!");
    }

    /**
     * method to make sure the player's input is an integer number
     * 
     * @param counter variable to let the player know in what try they are.
     * @return the guess the player has entered
     */

    private static int getUserGuess(String counter) {
        boolean isNumber = false;
        int guess = 0;
        while (!isNumber) {
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                isNumber = true;
            } else {
                System.out.println("Please enter only integer numbers");
                System.out.print(counter);
                scanner.next();
            }
        }

        return guess;
    }

    /**
     * method to obtain and correctly parse the input of the player to check if they
     * want to play again
     * 
     * @return true if the player wants to play again, false if the player is done
     *         playing
     */

    private static boolean checkIfPlayAgain() {
        boolean playAgain = false;
        System.out.print("Wanna try again? (y/n) ");
        char answer = scanner.next().toLowerCase().charAt(0);

        while (answer != 'y' && answer != 'n') {
            System.out.print("y/n? ");
            answer = scanner.next().toLowerCase().charAt(0);
        }

        switch (answer) {
            case 'y':
                playAgain = true;
                break;
            case 'n':
                playAgain = false;
                break;
        }
        return playAgain;
    }
}

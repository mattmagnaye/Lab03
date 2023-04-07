import java.util.Random;
import java.util.Scanner;

public class Lab03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean tryAgain = true;
        
        System.out.println("Welcome to Matt and Pedro's guessing game!");
        
        while (tryAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numTries = 5;
            boolean win = false;
            
            System.out.println("I'm thinking of a number between 1 and 100. You have " + numTries + " tries."); // lemme know your thoughts about this, we can try the one on ma'ams output example or this
            
            while (numTries > 0) {
                System.out.print("Guess #" + (6 - numTries) + ": ");
                int guess = scanner.nextInt();
                
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
            
            System.out.print("Wanna try again? (y/n) ");
            String tryAgainStr = scanner.next().toLowerCase();
            if (tryAgainStr.equals("n")) {
                tryAgain = false;
            }
        }
        
        System.out.println("Thank you for playing! Matt and Pedro's guessing game!");
    }
}

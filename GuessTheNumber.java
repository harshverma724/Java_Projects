import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 20;
        int numberToGuess = random.nextInt(max - min + 1) + min;
        int numberOfTries = 0;
        int guess;
        boolean win = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have selected a number between " + min + " and " + max + ".");
        System.out.println("Try to guess it!");

        while (!win) {
            System.out.println("Enter your guess:");
            guess = scanner.nextInt();
            numberOfTries++;

            if (guess < numberToGuess) {
                System.out.println("Your guess is too low. Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Your guess is too high. Try again.");
            } else {
                win = true;
                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}

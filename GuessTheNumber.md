# Guess The Number Game

## Description
The **Guess The Number Game** is a simple Java-based console game where the user has to guess a randomly selected number between a given range. The game provides hints if the guess is too high or too low and keeps track of the number of attempts.

## Key Features
- Random number generation for unpredictability.
- Provides hints if the guess is too high or too low.
- Keeps track of the number of attempts.
- Simple and interactive console-based game.
- Encourages logical thinking and deduction skills.

## Summary
This project is a fun and engaging number guessing game that tests a player's ability to make accurate predictions based on hints. The game generates a random number between 1 and 20, and the player has to guess it with as few attempts as possible. The game provides instant feedback on whether the guess is too high or too low and announces when the correct number is found.

## Working of the Project
1. The game starts by generating a random number between 1 and 20.
2. The player is prompted to enter their guess.
3. If the guess is lower than the number, the program hints that the guess is too low.
4. If the guess is higher than the number, the program hints that the guess is too high.
5. The player continues guessing until they find the correct number.
6. The game displays the total number of attempts taken to guess the number correctly.
7. Once the correct number is guessed, the game ends with a congratulatory message.

## Code Implementation
```java
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
```

## How to Run
1. Compile the Java file: `javac GuessTheNumber.java`
2. Run the program: `java GuessTheNumber`
3. Follow the on-screen prompts to play the game.

## License
This project is open-source and free to use under the MIT License.


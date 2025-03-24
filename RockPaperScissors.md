# Rock Paper Scissors Game

## Description
The **Rock Paper Scissors Game** is a simple console-based Java game where the player competes against the computer. The player chooses Rock, Paper, or Scissors, and the computer randomly selects one as well. The game determines the winner based on the classic Rock Paper Scissors rules.

## Key Features
- Interactive console-based gameplay.
- Randomized computer moves for fairness.
- Simple decision-making logic to determine the winner.
- Option to play multiple rounds until the user decides to exit.

## Summary
This project implements a simple yet fun **Rock Paper Scissors** game using Java. The game asks the player to input their choice while the computer randomly selects its move. Based on the rules of Rock Paper Scissors:
- Rock beats Scissors
- Scissors beats Paper
- Paper beats Rock
If both choices are the same, the round is a tie. The game continues until the player decides to exit.

## Working of the Project
1. The player is prompted to enter their move (Rock, Paper, or Scissors).
2. The computer randomly selects one of the three choices.
3. The game compares the player’s move with the computer’s move to determine the winner.
4. The result is displayed (Win, Lose, or Tie).
5. The player is given an option to play again.
6. The game continues until the player chooses to exit.

## Code Implementation
```java
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = { "Rock", "Paper", "Scissors" };
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type exit:");
            String userMove = scanner.nextLine();

            if (userMove.equalsIgnoreCase("exit")) {
                playAgain = false;
                break;
            }

            if (!userMove.equalsIgnoreCase("Rock") && !userMove.equalsIgnoreCase("Paper")
                    && !userMove.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid move, please try again.");
                continue;
            }

            int computerMoveIndex = random.nextInt(3);
            String computerMove = rps[computerMoveIndex];

            System.out.println("Computer move: " + computerMove);

            if (userMove.equalsIgnoreCase(computerMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equalsIgnoreCase("Rock")) {
                if (computerMove.equalsIgnoreCase("Scissors")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (userMove.equalsIgnoreCase("Paper")) {
                if (computerMove.equalsIgnoreCase("Rock")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            } else if (userMove.equalsIgnoreCase("Scissors")) {
                if (computerMove.equalsIgnoreCase("Paper")) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
            }

            System.out.println("Play again? (yes/no)");
            String playAgainResponse = scanner.nextLine();
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
```

## How to Run
1. Compile the Java file: `javac RockPaperScissors.java`
2. Run the program: `java RockPaperScissors`
3. Follow the on-screen prompts to play the game.

## License
This project is open-source and free to use under the MIT License.


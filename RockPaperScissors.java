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

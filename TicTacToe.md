# Tic Tac Toe Game

## Description
The **Tic Tac Toe Game** is a simple Java-based console game where two players take turns to place their marks (X or O) on a 3x3 grid. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game.

## Key Features
- Two-player mode.
- Interactive console-based gameplay.
- Checks for winning conditions after each move.
- Detects a tie if all positions are filled without a winner.
- Simple and easy-to-understand game logic.

## Summary
This project is a classic implementation of the Tic Tac Toe game using Java. The game runs in the console and allows two players to take turns making their moves. The board is displayed after every move, and the game announces the winner or a tie when applicable. This project is great for learning fundamental programming concepts such as arrays, loops, and condition checking.

## Working of the Project
1. The game starts with an empty 3x3 board.
2. Players take turns to enter the row and column number where they want to place their mark (X or O).
3. If the chosen position is already occupied, the player is asked to enter a new position.
4. The game checks if a player has won after each move.
5. If a player succeeds in placing three marks in a row, column, or diagonal, they win.
6. If the board is full and no player has won, the game ends in a tie.
7. The game then terminates after displaying the result.

## Code Implementation
```java
import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameWon) {
            int row, col;
            while (true) {
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                row = scanner.nextInt();
                col = scanner.nextInt();

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("This move is not valid");
                }
            }

            printBoard();

            gameWon = checkWin();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (isBoardFull()) {
                System.out.println("The game is a tie!");
                break;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        scanner.close();
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
```

## How to Run
1. Compile the Java file: `javac TicTacToe.java`
2. Run the program: `java TicTacToe`
3. Follow the on-screen prompts to play the game.

## License
This project is open-source and free to use under the MIT License.


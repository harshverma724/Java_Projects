import java.util.Scanner;

public class Connect_Four {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY_SLOT = '-';
    private static final char PLAYER_ONE = 'R'; // Red player
    private static final char PLAYER_TWO = 'Y'; // Yellow player

    private char[][] board = new char[ROWS][COLUMNS];
    private char currentPlayer = PLAYER_ONE;

    public Connect_Four() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY_SLOT;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isColumnFull(int column) {
        return board[0][column] != EMPTY_SLOT;
    }

    private boolean makeMove(int column) {
        if (isColumnFull(column)) {
            return false;
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY_SLOT) {
                board[i][column] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    private boolean checkForWin() {
        // Check horizontal, vertical, and diagonal conditions
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
    }

    private boolean checkHorizontalWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer &&
                    board[i][j + 1] == currentPlayer &&
                    board[i][j + 2] == currentPlayer &&
                    board[i][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVerticalWin() {
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == currentPlayer &&
                    board[i + 1][j] == currentPlayer &&
                    board[i + 2][j] == currentPlayer &&
                    board[i + 3][j] == currentPlayer) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        // Check for ascending diagonal win
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer &&
                    board[i - 1][j + 1] == currentPlayer &&
                    board[i - 2][j + 2] == currentPlayer &&
                    board[i - 3][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        // Check for descending diagonal win
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLUMNS - 3; j++) {
                if (board[i][j] == currentPlayer &&
                    board[i + 1][j + 1] == currentPlayer &&
                    board[i + 2][j + 2] == currentPlayer &&
                    board[i + 3][j + 3] == currentPlayer) {
                    return true;
                }
            }
        }

        return false;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == PLAYER_ONE) ? PLAYER_TWO : PLAYER_ONE;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        int movesCount = 0;

        System.out.println("Welcome to Connect Four!");
        printBoard();

        while (!gameWon && movesCount < ROWS * COLUMNS) {
            System.out.println("Player " + currentPlayer + "'s turn. Enter a column (0-6): ");
            int column = scanner.nextInt();

            if (column < 0 || column >= COLUMNS) {
                System.out.println("Invalid column. Please try again.");
                continue;
            }

            if (!makeMove(column)) {
                System.out.println("Column full. Please try again.");
                continue;
            }

            printBoard();
            movesCount++;

            if (checkForWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else {
                switchPlayer();
            }
        }

        if (!gameWon) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Connect_Four game = new Connect_Four();
        game.playGame();
    }
}

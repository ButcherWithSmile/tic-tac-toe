import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        printGrid(grid);
        boolean xTurn = true;
        while (true) {
            System.out.print("Enter the coordinates: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            if (grid[3 - y][x - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            grid[3 - y][x - 1] = xTurn ? 'X' : 'O';
            printGrid(grid);
            if (hasWon(grid, xTurn ? 'X' : 'O')) {
                System.out.println(xTurn ? "X wins" : "O wins");
                break;
            } else if (isDraw(grid)) {
                System.out.println("Draw");
                break;
            }
            xTurn = !xTurn;
        }
    }

    private static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean hasWon(char[][] grid, char c) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == c && grid[i][1] == c && grid[i][2] == c) return true;
            if (grid[0][i] == c && grid[1][i] == c && grid[2][i] == c) return true;
        }
        if (grid[0][0] == c && grid[1][1] == c && grid[2][2] == c) return true;
        return grid[0][2] == c && grid[1][1] == c && grid[2][0] == c;
    }

    private static boolean isDraw(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') return false;
            }
        }
        return true;
    }
}

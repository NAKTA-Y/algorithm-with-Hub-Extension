import java.util.Scanner;

public class Main {
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            char[][] board = new char[n][n];
            int max = 0;

            for (int i = 0; i < n; i++) {
                String line = sc.next();
                char[] split = line.toCharArray();

                for (int j = 0; j < split.length; j++)
                    board[i][j] = split[j];
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    swap(board, i, j, Direction.UP);
                    max = Math.max(max, countRow(board[i]));
                    max = Math.max(max, countColumn(board, j));
                    swap(board, i, j, Direction.UP);

                    swap(board, i, j, Direction.DOWN);
                    max = Math.max(max, countRow(board[i]));
                    max = Math.max(max, countColumn(board, j));
                    swap(board, i, j, Direction.DOWN);

                    swap(board, i, j, Direction.LEFT);
                    max = Math.max(max, countRow(board[i]));
                    max = Math.max(max, countColumn(board, j));
                    swap(board, i, j, Direction.LEFT);

                    swap(board, i, j, Direction.RIGHT);
                    max = Math.max(max, countRow(board[i]));
                    max = Math.max(max, countColumn(board, j));
                    swap(board, i, j, Direction.RIGHT);
                }
            }

            System.out.println(max);
        }
    }

    private static void swap(char[][] board, int i, int j, Direction direction) {
        char temp = board[i][j];
        switch (direction) {
            case UP:
                if (i == 0) break;
                board[i][j] = board[i-1][j];
                board[i-1][j] = temp;
                break;

            case DOWN:
                if (i == board.length-1) break;
                board[i][j] = board[i+1][j];
                board[i+1][j] = temp;
                break;

            case LEFT:
                if (j == 0) break;
                board[i][j] = board[i][j-1];
                board[i][j-1] = temp;
                break;

            case RIGHT:
                if (j == board[0].length-1) break;
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;
        }
    }

    private static int countRow(char[] line) {
        int sum = 0;
        int max = 0;
        char previousCandy = '$';

        for (char candy : line) {
            if (previousCandy == candy) {
                sum++;
            } else {
                sum = 1;
            }

            max = Math.max(max, sum);

            previousCandy = candy;
        }

        return max;
    }

    private static int countColumn(char[][] board, int columnIdx) {
        int sum = 0;
        int max = 0;
        char previousCandy = '$';

        for (char[] candies: board) {
            if (previousCandy == candies[columnIdx]) {
                sum++;
            } else {
                sum = 1;
            }

            max = Math.max(max, sum);

            previousCandy = candies[columnIdx];
        }

        return max;
    }
}
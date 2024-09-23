import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean[][] rowAssigned = new boolean[9][10];
    static boolean[][] colAssigned = new boolean[9][10];
    static boolean[][][] boxAssigned = new boolean[3][3][10];
    static char[][] board = new char[9][9];
    static int zeroCount = 0;
    static List<int[]> zeroPositions = new ArrayList<>();
    static boolean solved = false;

    public static void main(String[] args) throws IOException {

        // input
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 9; i++) {
                char[] row = br.readLine().replaceAll("\\s", "").toCharArray();
                board[i] = row;
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                rowAssigned[i][board[i][j] - '0'] = true;
                colAssigned[j][board[i][j] - '0'] = true;
                boxAssigned[i / 3][j / 3][board[i][j] - '0'] = true;

                if (board[i][j] == '0') {
                    zeroPositions.add(new int[]{i, j});
                    zeroCount++;
                }
            }
        }

        backtracking(0);
    }

    public static void backtracking(int index) {
        if (solved) return;
        if (index == zeroCount) {
            for (char[] row : board) {
                for (char c : row) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }

            solved = true;
            return;
        }

        int[] position = zeroPositions.get(index);
        int x = position[0];
        int y = position[1];

        for (int i = 1; i <= 9; i++) {
            if (rowAssigned[x][i] || colAssigned[y][i] || boxAssigned[x / 3][y / 3][i]) continue;

            rowAssigned[x][i] = true;
            colAssigned[y][i] = true;
            boxAssigned[x / 3][y / 3][i] = true;
            board[x][y] = Character.forDigit(i, 10);

            backtracking(index+1);

            rowAssigned[x][i] = false;
            colAssigned[y][i] = false;
            boxAssigned[x / 3][y / 3][i] = false;
            board[x][y] = '0';
        }
    }
}

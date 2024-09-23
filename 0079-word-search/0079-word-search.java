class Solution {
    public boolean isPossible = false;
    public int height;
    public int width;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        char[] charArray = word.toCharArray();

        return findWord(board, charArray, word);
    }

    public boolean findWord(char[][] board, char[] charArray, String word) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == charArray[0]) {
                    backtracking(i, j, 0, word, board);
                    if (isPossible) return true;
                }
            }
        }

        return false;
    }

    public void backtracking(int x,
                             int y,
                             int index,
                             String target,
                             char[][] board) {
        if (index == target.length()) {
            isPossible = true;
            return;
        }

        if (x < 0 || y < 0 || x >= height || y >= width) return;

        if (board[x][y] == target.charAt(index)) {
            board[x][y] ^= 256;
            backtracking(x + 1, y, index + 1, target, board);
            backtracking(x, y + 1, index + 1, target, board);
            backtracking(x - 1, y, index + 1, target, board);
            backtracking(x, y - 1, index + 1, target, board);
            board[x][y] ^= 256;
        }
    }
}
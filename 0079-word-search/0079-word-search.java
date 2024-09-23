class Solution {
    public boolean isPossible = false;
    public int height;
    public int width;

    public boolean exist(char[][] board, String word) {
        height = board.length;
        width = board[0].length;
        char[] charArray = word.toCharArray();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == charArray[0]) {
                    if (backtracking(i, j, 0, word, board)) return true;
                }
            }
        }

        return false;
    }

    public boolean backtracking(int x,
                                int y,
                                int index,
                                String target,
                                char[][] board) {

        if (index == target.length()) return true;
        if (x < 0 || y < 0 || x >= height || y >= width) return false;
        if (board[x][y] != target.charAt(index)) return false;

        board[x][y] ^= 256;
        boolean isPossible = backtracking(x + 1, y, index + 1, target, board) ||
                backtracking(x, y + 1, index + 1, target, board) ||
                backtracking(x - 1, y, index + 1, target, board) ||
                backtracking(x, y - 1, index + 1, target, board);
        board[x][y] ^= 256;

        return isPossible;
    }
}
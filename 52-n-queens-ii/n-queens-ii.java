class Solution {
    public boolean isSafe(int row, int col, char[][] board) {
        // horizontal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper left
        int r = row;
        for (int c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower left
        r = row;
        for (int c = col; r < board.length && c >=0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public int helper(char[][] board, int col, int count) {
        if (col == board.length) {
            return count+1;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                count = helper(board, col+1, count);
                board[row][col] = '.';
            }
        }

        return count;
    }

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        return helper(board, 0, 0);
    }
}
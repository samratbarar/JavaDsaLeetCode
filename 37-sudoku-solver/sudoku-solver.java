class Solution {
    static boolean solver(char[][] board, int row, int col) {
        if (row == board.length) {
            for (char[] boardRow : board) {
                for (char cell : boardRow) {
                    System.out.print(cell);
                }

                System.out.println();
            }
            System.out.println();
            return true;
        }
        
        if (col == board[0].length) {
            return solver(board, row + 1, 0);
        }

        if (board[row][col] == '.') {
            for (int k = 1; k <= 9; k++) {
                char value = (char)(k + '0');
                if (isSafe(board, value, row, col)) {
                    board[row][col] = value;

                    if (solver(board, row, col + 1)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
        } else {
            return solver(board, row, col + 1);
        }

        return false;
    }

    private static boolean isSafe(char[][] board, char value, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        int gridRowStart = row - (row % 3), gridColStart = col - (col % 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[gridRowStart + i][gridColStart + j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        if(!solver(board, 0, 0)) {
            System.out.println("Cannot solve this sudoku");
        }
    }
}
class Solution {
    public int countNegatives(int[][] grid) { 
        int count = 0;
        int row = grid.length - 1, col = 0;

        while (true) {
            if (row < 0) {
                break;
            }

            if (col == grid[row].length) {
                break;
            }

            if (grid[row][0] < 0) {
                count += grid[row].length;
                row--;
                continue;
            }

            if (row >= 0 && grid[row][col] >= 0) {
                col++;
                
            } else if (row >= 0 && col < grid[row].length && grid[row][col] < 0) {
                count += grid[row].length - col;
                row--;
            }
        }

        return count;
    }
}
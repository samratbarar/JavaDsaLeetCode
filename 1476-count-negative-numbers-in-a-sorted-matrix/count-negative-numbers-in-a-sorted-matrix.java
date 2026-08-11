class Solution {
    public int countNegatives(int[][] grid) { 
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int start = 0, end = grid[i].length - 1;

            if (grid[i][0] < 0) {
                count += grid[i].length;
                continue;
            }

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (mid >= 1 && grid[i][mid] < 0 && grid[i][mid - 1] >= 0) {
                    count += grid[i].length - mid;
                    break;
                } else if (grid[i][mid] < 0) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return count;
    }
}
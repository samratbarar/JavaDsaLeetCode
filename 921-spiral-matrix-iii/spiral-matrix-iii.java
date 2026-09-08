class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        int count = 0;

        int currRow = rStart;
        int currCol = cStart;
        int steps = 1;

        while (count != (rows * cols)) {
            // right
            for (int i = 0; i < steps; i++) {
                if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols) {
                    ans[count][0] = currRow;
                    ans[count][1] = currCol;
                    count++;
                }
                currCol++;
            }

            if (count == (rows * cols)) {
                break;
            }

            // down
            for (int i = 0; i < steps; i++) {
                if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols) {
                    ans[count][0] = currRow;
                    ans[count][1] = currCol;
                    count++;
                }
                currRow++;
            }

            if (count == (rows * cols)) {
                break;
            }

            steps++;

            // left
            for (int i = steps; i > 0; i--) {
                if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols) {
                    ans[count][0] = currRow;
                    ans[count][1] = currCol;
                    count++;
                }
                currCol--;
            }

            if (count == (rows * cols)) {
                break;
            }

            // up
            for (int i = steps; i > 0; i--) {
                if (currRow >= 0 && currRow < rows && currCol >= 0 && currCol < cols) {
                    ans[count][0] = currRow;
                    ans[count][1] = currCol;
                    count++;
                }
                currRow--;
            }

            steps++;
        }

        return ans;
    }
}
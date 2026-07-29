class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int rowStart = 0, rowEnd = n - 1;
        int colStart = 0, colEnd = n - 1;
        int count = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans[rowStart][i] = count++;
            }

            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {
                ans[i][colEnd] = count++;
            }

            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans[rowEnd][i] = count++;
                }

                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans[i][colStart] = count++;
                }

                colStart++;
            }
        }

        return ans;
    }
}
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ((mat.length * mat[0].length) != (r*c)) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int row = 0, col = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (row < r && col < c) {
                    ans[row][col++] = mat[i][j];
                } else if (row < r) {
                    col = 0;
                    row++;
                    j--;                    
                }
            }
        }

        return ans;
    }
}
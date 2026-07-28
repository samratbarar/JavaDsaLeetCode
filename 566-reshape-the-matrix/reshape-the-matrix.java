class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if ((mat.length * mat[0].length) != (r*c)) {
            return mat;
        }

        int[][] ans = new int[r][c];

        int idx = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                ans[idx / c][idx % c] = mat[i][j];
                idx++;
            }
        }

        return ans;
    }
}
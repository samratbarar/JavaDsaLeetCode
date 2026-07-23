class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < indices[i].length; j++) {
                int inc = indices[i][j];
                if (j == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        matrix[inc][k]++;
                    }
                } else {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][inc]++;
                    }
                }
            }
        }

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
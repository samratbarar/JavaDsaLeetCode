class Solution {
    public void rotation(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i + 1; j > i && j < mat.length; j++) {
            int temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
            }
        }
        
        for (int[] arr : mat) {
            for (int j = 0; j < mat.length / 2; j++) {
                int temp = arr[j];
                arr[j] = arr[mat.length - 1 - j];
                arr[mat.length - 1 - j] = temp;
            }
        }
    } 

    public boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                } 
            }
        }

        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 1; i <= 4; i++) {
            if (isEqual(mat, target)) {
                return true;
            }
            rotation(mat);
        }

        return false;
    }
}
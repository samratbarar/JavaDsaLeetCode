class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int colIdxMin = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][colIdxMin] > matrix[i][j]) {
                    colIdxMin = j;
                }
            }

            int maxEle = matrix[i][colIdxMin];
            boolean isLargest = true;

            for (int j = 0; j < matrix.length; j++) {
                if (maxEle < matrix[j][colIdxMin]) {
                    isLargest = false;
                }
            }

            if (isLargest) {
                ans.add(maxEle);
            }
        }

        return ans;
    }
}
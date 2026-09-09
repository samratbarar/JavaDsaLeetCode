class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> zerosRow = new HashSet<>(); 
        HashSet<Integer> zerosCols = new HashSet<>(); 

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zerosRow.add(i);
                    zerosCols.add(j);
                }
            }
        }

        Iterator<Integer> iterator = zerosRow.iterator();

        while (iterator.hasNext()) {
            int currRow = iterator.next();

            for (int i = 0; i < matrix[0].length; i++) {
                matrix[currRow][i] = 0;
            }

            iterator.remove(); 
        }

        iterator = zerosCols.iterator();

        while (iterator.hasNext()) {
            int currCol = iterator.next();

            for (int i = 0; i < matrix.length; i++) {
                matrix[i][currCol] = 0;
            }

            iterator.remove();
        }
        
    }
}
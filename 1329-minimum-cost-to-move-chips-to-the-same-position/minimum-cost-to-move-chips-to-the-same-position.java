class Solution {
    public int minCostToMoveChips(int[] position) {
        int costEven = 0, costOdd = 0;

        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                costOdd++;
            } else {
                costEven++;
            }
        }

        return Integer.min(costEven, costOdd);
    }
}
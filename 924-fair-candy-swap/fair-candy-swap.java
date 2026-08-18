class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        HashSet<Integer> set = new HashSet<>();

        int sumAlice = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            sumAlice += aliceSizes[i];
        }

        int sumBob = 0;
        for (int i = 0; i < bobSizes.length; i++) {
            sumBob +=bobSizes[i];
        }

        for (int i = 0; i < bobSizes.length; i++) {
            set.add(bobSizes[i]);
        }

        int diff = (sumAlice - sumBob) / 2;

        for (int i = 0; i < aliceSizes.length; i++) {
            if (set.contains(aliceSizes[i] - diff)) {
                return new int[] {aliceSizes[i], aliceSizes[i] - diff};
            }
        }

        return new int[] {-1, -1};
    }
}
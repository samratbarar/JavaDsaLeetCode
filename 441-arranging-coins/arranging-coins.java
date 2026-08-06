class Solution {
    public int arrangeCoins(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long coins = (long)mid * (mid + 1) / 2;

            if (coins > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
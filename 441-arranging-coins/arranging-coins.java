class Solution {
    public int arrangeCoins(int n) {
        int start = 1, end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long numN = (long)mid * (mid + 1) / 2;
            long numNminusOne = (long)(mid - 1) * (mid) / 2;

            if (numN == n) {
                return mid;
            }

            if (numN > n && numNminusOne < n) {
                return (mid - 1);
            }

            if (numN > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
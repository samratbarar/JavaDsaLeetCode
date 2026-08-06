class Solution {
    public boolean isPerfectSquare(int num) {
        int start = 1, end = num / 2 + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long)mid * mid;

            if (square == num) {
                return true;
            }

            if (square > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}
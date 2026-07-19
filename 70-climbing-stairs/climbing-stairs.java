class Solution {
    public int climbStairs(int n) {
        int prev = 0, curr = 1;
        for (int i = 1; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
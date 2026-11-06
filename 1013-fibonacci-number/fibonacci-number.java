class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int first = 0, second = 1;
        int next = first + second;

        for (int i = 3; i <= n; i++) {
            first = second;
            second = next;
            next = first + second;
        }

        return next;
    }
}
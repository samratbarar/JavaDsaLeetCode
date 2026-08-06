class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        } 
        
        return false;
    }

    private int findSquare(int num) {
        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }

        return sum;
    }
}
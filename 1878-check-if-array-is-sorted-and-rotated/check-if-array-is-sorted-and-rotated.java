class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return true;
        }

        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i % len] > nums[(i + 1) % len]) {
                count++;
            }
        }

        return count < 2;
    }
}
class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return true;
        }

        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len]) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
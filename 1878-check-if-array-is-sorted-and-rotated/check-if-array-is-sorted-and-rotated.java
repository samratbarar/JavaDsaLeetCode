class Solution {
    public boolean check(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return true;
        }

        int start = 0;

        while (start < len - 1 && nums[start] <= nums[start + 1]) {
            start++;
        }

        start++;

        for (int i = 0; i < len - 1; i++) {
            int idx = (start + i) % len;
            int nextIdx = (idx + 1) % len;
            if (nums[idx] > nums[nextIdx]) {
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int pre = 1;
        int suffix = 1;

        for (int i = 0; i < len; i++) {
            prefix[i] = pre;
            pre *= nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = prefix[i] * suffix;
            suffix *= temp;
        }

        return nums;
    }
}
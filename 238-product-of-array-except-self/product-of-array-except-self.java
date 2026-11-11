class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prefix = new int[len];
        int pre = 1;
        int[] suffix = new int[len];
        int suf = 1;

        for (int i = 0; i < len; i++) {
            prefix[i] = pre;
            pre *= nums[i];

            suffix[len - i - 1] = suf;
            suf *= nums[len - i - 1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
}
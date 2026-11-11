class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            nums[i] = prefix;
            prefix *= temp;
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = ans[i];
            ans[i] = nums[i] * suffix;
            suffix *= temp;
        }

        return ans;
    }
}
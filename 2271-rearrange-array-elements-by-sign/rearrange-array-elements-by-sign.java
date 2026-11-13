class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int idxPostive = 0;
        int idxNegative = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[idxPostive] = nums[i];
                idxPostive += 2;
            } else {
                ans[idxNegative] = nums[i];
                idxNegative += 2;
            }
        }

        return ans;
    }
}
class Solution {
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;

        if (len < 2) {
            return;
        }

        int idx = len - (k % len);

        reverse(nums, 0, idx - 1);
        reverse(nums, idx, len - 1);
        reverse(nums, 0, len - 1);
    }
}
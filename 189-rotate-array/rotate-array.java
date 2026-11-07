class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        if (len < 2) {
            return;
        }

        int idx = len - (k % len);

        for (int i = 0; i < idx / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[idx - i - 1];
            nums[idx - i - 1] = temp;
        }

        int left = idx;
        int right = len - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }
}
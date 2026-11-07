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

        int dec = 0;

        for (int i = idx; i < (idx + len) / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - dec - 1];
            nums[len - dec - 1] = temp;
            dec++;
        }
        
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[idx];
                nums[idx] = 0;
                idx++;
            }
        }

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[idx];
                nums[idx] = 1;
                idx++;
            }
        }    
    }
}
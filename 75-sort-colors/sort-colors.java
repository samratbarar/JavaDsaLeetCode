class Solution {
    public void sortColors(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }

        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 2 && i != idx) {
        //         int temp = nums[i];
        //         nums[i] = nums[idx];
        //         nums[idx] = temp;
        //         idx++;
        //     }
        // }    
    }
}
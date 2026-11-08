class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length; j++) {
                    if (j != nums.length - 1) {
                        nums[j] = nums[j + 1];
                    }
                }

                nums[nums.length - 1] = 0;
            }
        }
    }
}
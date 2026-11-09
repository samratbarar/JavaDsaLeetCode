class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int idxZero = -1;

        for (int i = 0; i < nums.length; i++) {
            if (idxZero == -1 && nums[i] == 0) {
                idxZero = i;
            } 

            if (idxZero != -1 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[idxZero];
                nums[idxZero] = temp;
                idxZero++;
            }
        }
    }
}
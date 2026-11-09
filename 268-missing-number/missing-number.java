class Solution {
    public int missingNumber(int[] nums) {
        boolean isZeroPresent = false;

        for (int num : nums) {
            if (num == 0) {
                isZeroPresent = true;
                break;
            }
        }

        if (isZeroPresent) {
            int i = 0;

            while (i < nums.length) {
                int correct = nums[i];

                if (correct < nums.length && correct != nums[correct]) {
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                } else {
                    i++;
                }
            }

            for (i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }

            return nums.length;
        }

        return 0;
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int multi = 1;
        int noOfZeros = 0;
        int len = nums.length;

        for (int num : nums) {
            if (num != 0) {
                multi *= num;
            } else {
                noOfZeros++;
            }
        }

        if (noOfZeros > 1) {
            for (int i = 0; i < len; i++) {
                nums[i] = 0;
            }
            return nums;
        }

        for (int i = 0; i < len; i++) {
            if (noOfZeros == 1) {
                if (nums[i] == 0) {
                    nums[i] = multi;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = multi / nums[i];
            }
        }

        return nums;
    }
}
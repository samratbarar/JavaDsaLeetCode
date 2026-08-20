class Solution {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        boolean isFound = false;

        for (int i = 0; i < nums.length; i++) {
            max1 = Math.max(nums[i], max1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max1) {
                max2 = Math.max(nums[i], max2);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max2) {
                isFound = true;
                max3 = Math.max(nums[i], max3);
            }
        }

        if (!isFound) {
            return max1;
        }

        return max3;
    }
}
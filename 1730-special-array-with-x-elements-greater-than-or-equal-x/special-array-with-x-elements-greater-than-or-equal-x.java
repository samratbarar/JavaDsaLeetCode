class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int start = 0;
            int end = nums.length - 1;
            int x = 0;
            
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (nums[mid] >= i) {
                    x = nums.length - mid;
                }

                if (nums[mid] < i) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (x == i) {
                return x;
            }
        }

        return -1;
    }
}
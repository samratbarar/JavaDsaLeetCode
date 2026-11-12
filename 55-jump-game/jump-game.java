class Solution {
    // public boolean jump(int[] nums, int idx) {
    //     if (idx >= nums.length - 1) {
    //         return true;
    //     }

    //     if (nums[idx] == 0) {
    //         return false;
    //     }

    //     boolean nextJump = false;

    //     for (int i = 1; i <= nums[idx]; i++) {
    //         if (idx + i >= nums.length - 1) {
    //             return true;
    //         }

    //         nextJump = jump(nums, idx + i);

    //         if (nextJump) {
    //             break;
    //         }
    //     }

    //     return nextJump;
    // }

    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            } 

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true;
            }    
        }

        return true;
    }
}
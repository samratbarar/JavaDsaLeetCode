class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> setNums = new LinkedHashSet<>();
        int i;

        for (i = 0; i < nums.length; i++) {
            setNums.add(nums[i]);
        }

        for (i = 0; !setNums.isEmpty(); i++) {
            nums[i] = setNums.removeFirst();
        }

        return (i);
    }
}
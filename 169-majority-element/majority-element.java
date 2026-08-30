class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> keys = map.keySet();

        for (int k : keys) {
            if ((n / 2) < map.get(k)) {
                return k;
            }
        }

        return -1;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
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
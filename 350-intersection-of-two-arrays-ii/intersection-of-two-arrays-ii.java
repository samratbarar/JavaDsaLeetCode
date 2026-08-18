class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int value = map.get(nums1[i]);
                map.put(nums1[i], value+1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                ans.add(num);
                int val = map.get(num);
                map.put(num, val-1);
            }
        }

        int[] finalAns = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = (int)ans.get(i);
        }

        return finalAns;
    }
}
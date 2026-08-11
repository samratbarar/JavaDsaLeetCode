class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        int[] finalAns = ans.stream().mapToInt(Integer::intValue).toArray();

        return finalAns;
    }
}
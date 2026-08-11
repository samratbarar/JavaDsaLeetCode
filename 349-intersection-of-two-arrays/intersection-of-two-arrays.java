class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Arrays.sort(nums2);

        for (int i = 0; i < nums2.length; i++) {
            if (i != 0 && nums2[i] == nums2[i - 1]) {
                continue;
            }

            if (set.contains(nums2[i])) {
                ans[idx++] = nums2[i];
            }
        }

        int[] finalAns = new int[idx];

        for (int i = 0; i < idx; i++) {
            finalAns[i] = ans[i];
        }

        return finalAns;
    }
}
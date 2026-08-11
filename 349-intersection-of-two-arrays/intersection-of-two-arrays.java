class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int idx2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (i != 0 && nums1[i] == nums1[i - 1]) {
                continue;
            }

            for (int j = idx2; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[idx++] = nums1[i];
                    idx2 = j + 1;
                    break;
                }
            }

            if (idx == nums2.length) {
                break;
            }
        }

        int[] finalAns = new int[idx];

        for (int i = 0; i < idx; i++) {
            finalAns[i] = ans[i];
        }

        return finalAns;
    }
}
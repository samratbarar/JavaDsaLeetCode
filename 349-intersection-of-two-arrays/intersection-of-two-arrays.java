class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.min(nums1.length, nums2.length)];
        int idx = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length < nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                int start = 0, end = nums2.length - 1;
                if (i != 0 && nums1[i] == nums1[i - 1]) {
                    continue;
                }

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (nums1[i] == nums2[mid]) {
                        ans[idx++] = nums1[i];
                        break;
                    }

                    if (nums2[mid] < nums1[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                int start = 0, end = nums1.length - 1;
                if (i != 0 && nums2[i] == nums2[i - 1]) {
                    continue;
                }

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (nums2[i] == nums1[mid]) {
                        ans[idx++] = nums2[i];
                        break;
                    }

                    if (nums1[mid] < nums2[i]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }

        int[] finalAns = new int[idx];

        for (int i = 0; i < idx; i++) {
            finalAns[i] = ans[i];
        }

        return finalAns;
    }
}
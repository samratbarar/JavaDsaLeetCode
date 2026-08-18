class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                int value = map1.get(nums1[i]);
                map1.put(nums1[i], value+1);
            } else {
                map1.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                int value = map2.get(nums2[i]);
                map2.put(nums2[i], value+1);
            } else {
                map2.put(nums2[i], 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int times = Math.min(entry.getValue(), map2.get(entry.getKey()));
                for (int j = 0; j < times; j++) {
                    ans.add(entry.getKey());
                }
            }
        }

        int[] finalAns = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = (int)ans.get(i);
        }

        return finalAns;
    }
}
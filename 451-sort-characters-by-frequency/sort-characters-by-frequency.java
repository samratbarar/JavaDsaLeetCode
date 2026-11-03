class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = len; i > 0; i--) {
            if (map.isEmpty()) {
                break;
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();

                if (value == i) {
                    for (int j = 0; j < value; j++) {
                        ans.append(key);
                    }
                }
            }
        }

        return ans.toString();
    }
}
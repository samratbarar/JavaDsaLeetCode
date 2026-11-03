class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder ans = new StringBuilder("");

        while (!map.isEmpty()) {
            int lar = Integer.MIN_VALUE;
            char keyL = 'a'; 

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();

                if (value > lar) {
                    lar = value;
                    keyL = key;
                }
            }

            map.remove(keyL);

            for (int i = 0; i < lar; i++) {
                ans.append(keyL);
            }
        }

        return ans.toString();
    }
}
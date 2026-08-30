class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
            map.put(tChar, map.getOrDefault(tChar, 0) - 1);
        }

        for (char k : map.keySet()) {
            if (map.get(k) != 0) {
                return false;
            }
        }

        return true;
    }
}
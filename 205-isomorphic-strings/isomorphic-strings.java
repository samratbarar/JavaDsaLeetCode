class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (map.containsKey(chS)) {
                char val = map.get(chS);

                if (val != chT) {
                    return false;
                }
            }

            if (map.containsValue(chT) && !map.containsKey(chS)) {
                return false;
            }

            map.put(chS, chT);
        }

        return true;
    }
}
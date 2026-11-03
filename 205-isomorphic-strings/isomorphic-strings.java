class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (map1.containsKey(chS)) {
                char val = map1.get(chS);

                if (val != chT) {
                    return false;
                }
            }

            if (map2.containsKey(chT)) {
                char val = map2.get(chT);

                if (val != chS) {
                    return false;
                }
            }

            map1.put(chS, chT);
            map2.put(chT, chS);
        }

        return true;
    }
}
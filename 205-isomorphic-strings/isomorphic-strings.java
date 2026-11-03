class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            Character key1 = map1.get(chS);
            Character key2 = map2.get(chT);

            if (key1 != null && key1 != chT) {
                return false;
            }

            if (key2 != null && key2 != chS) {
                return false;
            }

            map1.put(chS, chT);
            map2.put(chT, chS);
        }

        return true;
    }
}
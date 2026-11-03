class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int len = s.length();
        int lar = 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (lar < map.get(ch)) {
                lar = map.get(ch);
            }
        }

        ArrayList<Character>[] characters = new ArrayList[lar + 1];

        for (int i = 0; i < lar + 1; i++) {
            characters[i] = new ArrayList<>();
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();

            characters[value].add(key);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = lar; i > 0; i--) {
            ArrayList<Character> list = characters[i];

            for (char key : list) {
                for (int k = 0; k < i; k++) {
                    ans.append(key);
                }
            }
        }

        return ans.toString();
    }
}
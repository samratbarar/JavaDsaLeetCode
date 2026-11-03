class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();

        if (len != goal.length()) {
            return false;
        }

        char starting = goal.charAt(0);
        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == starting) {
                indexes.add(i);
            }
        }

        while (!indexes.isEmpty()) {
            int idx = indexes.remove(0);
            boolean isSame = true;

            for (int i = 0; i < len; i++) {
                if (s.charAt(idx) != goal.charAt(i)) {
                    isSame = false;
                    break;
                }


                idx = (idx + 1) % len;
            }

            if (isSame) {
                return true;
            }
        }


        return false;
    }
}
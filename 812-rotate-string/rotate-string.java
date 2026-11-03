class Solution {
    public boolean rotateString(String s, String goal) {
        int len = s.length();

        if (len != goal.length()) {
            return false;
        }

        if (len == 0) {
            return true;
        }

        char starting = goal.charAt(0);

        s += s;

        for (int i = 0; i < 2*len; i++) {
            char ch = s.charAt(i);

            if (ch == starting) {
                boolean isSame = true;
                int idx = 0;

                for (int j = i; j < i + len; j++) {
                    if (j == 2*len) {
                        return false;
                    }
                    
                    if (s.charAt(j) != goal.charAt(idx)) {
                        isSame = false;
                        break;
                    } 
                    idx++;
                }

                if (isSame) {
                    return true;
                }
            }
        }

        return false;
    }
}
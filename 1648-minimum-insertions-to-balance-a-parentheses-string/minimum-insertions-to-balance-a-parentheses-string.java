class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '(') {
                open++;
            } else {
                if (open != 0) {
                    open--;

                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') { 
                        i++;
                    } else {
                        count++;
                    }

                } else {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i++;
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
        }

        return 2 * open + count;
    }
}
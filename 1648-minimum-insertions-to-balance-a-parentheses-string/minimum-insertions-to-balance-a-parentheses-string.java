class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '(') {
                stack.push(currChar);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();

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

        return 2 * stack.size() + count;
    }
}
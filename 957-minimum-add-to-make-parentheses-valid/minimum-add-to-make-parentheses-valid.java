class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            if (currChar == '(') {
                stack.push(currChar);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }

        return stack.size() + count;
    }
}
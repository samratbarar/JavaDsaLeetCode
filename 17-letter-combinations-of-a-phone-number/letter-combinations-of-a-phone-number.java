class Solution {
    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits, String combination) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) {
            List<String> com = new ArrayList<>();
            com.add(combination);
            return com;
        }

        int digit = digits.charAt(0) - '0';

        for (int i = 0; i < map[digit].length(); i++) { 
            List<String> combinations = letterCombinations(digits.substring(1), combination + map[digit].charAt(i));
            ans.addAll(combinations);
        }

        return ans;
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return letterCombinations(digits, "");
    }
}
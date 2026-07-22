class Solution {
    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void letterCombinations(String digits, String combination, List<String> ans) {
        if (digits.isEmpty()) {
            ans.add(combination);
            return;
        }

        int digit = digits.charAt(0) - '0';

        for (int i = 0; i < map[digit].length(); i++) { 
            letterCombinations(digits.substring(1), combination + map[digit].charAt(i), ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();

        letterCombinations(digits, "", ans);

        return ans;
    }
}
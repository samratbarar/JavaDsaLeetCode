class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if ((leftChar < 97 || leftChar > 122) && (leftChar > 57 || leftChar < 48)) {
                left++;
                continue;
            }

            if ((rightChar < 97 || rightChar > 122) && (rightChar > 57 || rightChar < 48)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
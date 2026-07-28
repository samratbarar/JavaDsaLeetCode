class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int uniNum = 1;
        if (n % 2 == 0) {
            for (int i = 0; i < n; i += 2) {
                ans[i] = uniNum;
                ans[i + 1] = -1 * uniNum;
                uniNum++;
            }
        } else {
            ans[0] = 0;

            for (int i = 1; i < n; i += 2) {
                ans[i] = uniNum;
                ans[i + 1] = -1 * uniNum;
                uniNum++;
            }
        }

        return ans;
    }
}
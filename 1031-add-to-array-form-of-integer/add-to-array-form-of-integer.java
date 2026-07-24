class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();

        int i;

        for (i = num.length - 1; i >= 0 && k > 0; i--) {
            int sum = num[i] + k;
            ans.add(0, sum % 10);
            k = sum / 10;
        }

        for (; i >= 0; i--) {
            ans.add(0, num[i]);
        }

        while (k > 0) {
            ans.add(0, k % 10);
            k /= 10;
        }

        return ans;
    }
}
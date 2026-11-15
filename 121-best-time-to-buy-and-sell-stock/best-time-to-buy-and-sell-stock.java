class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int miniBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - miniBuy);
            miniBuy = Math.min(miniBuy, prices[i]);
        }

        return ans;
    }
}
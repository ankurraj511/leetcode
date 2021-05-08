class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = -1 * prices[0];
        int sell = 0;
        for (int i = 1 ; i < n ; i++) {
            int b = Math.max(buy , sell - prices[i]);
            int s = Math.max(sell , buy + prices[i] - fee);
            buy = b;
            sell = s;
        }
        return sell;
    }
}

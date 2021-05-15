class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length , res = 0;
        int[] sum = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) 
            sum[i] = sum[i - 1] + cardPoints[i - 1];
        if (k == n)
            return sum[n];
        for (int i = 0 ; i <= k ; i++) 
            res = Math.max(res , sum[i] + sum[n] - sum[n - k + i]);
        return res;
    }
}

class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2 ; i < n + 1 ; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1 ; j <= (int)Math.sqrt(i) ; j++) {
                if (j == 1)
                    res = Math.min(res , dp[j] + i / j);
                else if (i % j == 0) 
                    res = Math.min(res , Math.min(dp[i / j] + j , dp[j] + i / j));
            }
            dp[i] = res;
        }
        return dp[n];
    }
}

class Solution {
    int[] dp;
    int dfs(int sum , int n) {
        if (sum > n)
            return 0;
        if (dp[sum] != 0)
            return dp[sum];
        int res = 1;
        for (int i = 1 ; i <= n - sum ; i++) 
            res = Math.max(res , i * dfs(sum + i , n));        
        return dp[sum] = res;
    }
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        dp = new int[n + 1];
        return dfs(0 , n); 
    }
}

class Solution {
    int mod = 1000000007;
    long[][] dp; 
    long dfs(int pos , int d , int f , int target) {    
        if (pos == d && target == 0)
            return 1;
        if (pos == d || target <= 0)
            return 0;
        if (dp[pos][target] != -1)
            return dp[pos][target];
        long res = 0L;
        for (int i = 1 ; i <= f ; i++) 
            res += dfs(pos + 1 , d , f , target - i);
        return dp[pos][target] = res % mod;
    }
    
    public int numRollsToTarget(int d, int f, int target) {
        dp = new long[d][target + 1];
        for (int i = 0 ; i < d ; i++) 
            for (int j = 0 ; j <= target ; j++) 
                dp[i][j] = -1;
        return (int)(dfs(0 , d , f , target) % mod);
    }
}

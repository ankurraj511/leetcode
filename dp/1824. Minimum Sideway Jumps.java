class Solution {
    int n;
    int[][] dp;
    int helper(int[] obs , int pos , int lane) {
        if (dp[pos][lane - 1] != -1)
            return dp[pos][lane - 1];
        while(pos < n && obs[pos] != lane) 
            pos += 1;
        pos -= 1;
        if (pos == n - 1)
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 1 ; i < 4 ; i++) {
            if (obs[pos] != i && obs[pos + 1] != i)
                ans = Math.min(ans , 1 + helper(obs , pos + 1 , i));                
        }
        return dp[pos][lane - 1] = ans;
    }
    public int minSideJumps(int[] obs) {
        n = obs.length;
        dp = new int[n][3];
        for (int i = 0 ; i < n ; i++)
            for (int j = 0 ; j < 3 ; j++)
                dp[i][j] = -1;
        return helper(obs , 0 , 2);
    }
}

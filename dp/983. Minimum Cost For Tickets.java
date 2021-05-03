class Solution {
    int dfs(int[] days, int[] costs , int[] dp , int pos) {
        if (pos == days.length)
            return 0;
        if (dp[pos] != 0)
            return dp[pos];
        int res = costs[0] + dfs(days , costs , dp , pos + 1);
        int i = pos;
        while (i < days.length && days[i] < days[pos] + 7)
            i += 1;
        res = Math.min(res , costs[1] + dfs(days , costs , dp , i));
        while (i < days.length && days[i] < days[pos] + 30)
            i += 1;
        res = Math.min(res , costs[2] + dfs(days , costs , dp , i));
        return dp[pos] = res;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return dfs(days , costs , dp , 0);
    }
}

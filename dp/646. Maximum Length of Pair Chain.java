class cmp implements Comparator<int[]> {
    public int compare(int[] a1 , int[] a2) {
        if (a1[1] > a2[1])
            return 1;
        else if (a1[1] == a2[1])
            if (a1[0] > a2[0])
                return 1;
        return -1;
    }
}
class Solution {
    int[] dp;
    int n;
    int dfs(int[][] pairs , int pos) {
        if (pos == n - 1) 
            return dp[pos] = 1;
        if (dp[pos] != 0)
            return dp[pos];
        int res = 0;
        for (int i = pos + 1 ; i < n ; i++) {
            if (pairs[pos][1] < pairs[i][0])
                res = Math.max(res , dfs(pairs, i));
        }
        return dp[pos] = res + 1;
    }
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        Arrays.sort(pairs , new cmp());
        dp = new int[n];
        int res = 0;
        for (int i = 0 ; i < n ; i++) { 
            dfs(pairs, i);
            res = Math.max(res , dp[i]);
        }
        return res;
    }
}

class Solution {
    int[] arr;
    int[][] dp;
    public int help(int pos , int M) {
        if (pos >= arr.length)
            return 0;
        if (pos + (2 * M) >= arr.length) {
            if (pos != 0)
                return arr[arr.length - 1] - arr[pos - 1];
            return arr[arr.length - 1];
        }
        if (dp[pos][M] != 0)
            return dp[pos][M];
        int res = 0;
        for (int i = pos ; i < (pos + (2 * M)) && i < arr.length ; i++) {
            int ans = Integer.MAX_VALUE;
            int m = Math.max(i - pos + 1 , M); 
            for (int j = i + 1 ; j < (i + 1 + (2 * m)) && j < arr.length ; j++) {
                ans = Math.min(ans , help(j + 1 , Math.max(j - i , m)));    
            }
            ans += arr[i]; 
            if (pos != 0)
                ans -= arr[pos - 1];
            res = Math.max(ans , res);
        }
        dp[pos][M] = res;
        return dp[pos][M];
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        arr = new int[n];
        dp = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            if (i == 0)
                arr[i] = piles[i];
            else
                arr[i] = arr[i - 1] + piles[i];
        }
        return help(0 , 1);
    }
}

class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length , m = arr[0].length , res = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (i == 0)
                    dp[i][j] = arr[i][j];
                else {
                    int v1 = Integer.MAX_VALUE , v3 = Integer.MAX_VALUE;
                    if (j >= 1)
                        v1 = dp[i - 1][j - 1];
                    if (j < n - 1)
                        v3 = dp[i - 1][j + 1];
                    dp[i][j] = Math.min(dp[i - 1][j] , Math.min(v1 , v3)) + arr[i][j];        
                }
                if (i == n - 1)
                    res = Math.min(res , dp[i][j]);
            }
        }
        return res;
    }
}

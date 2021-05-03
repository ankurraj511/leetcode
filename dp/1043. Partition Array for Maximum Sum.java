class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int[][] max = new int[k][n];
        for (int i = 0 ; i < k ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (i == 0 || j == 0) 
                    max[i][j] = arr[j];
                else 
                    max[i][j] = Math.max(max[i - 1][j - 1] , arr[j]);
            }
        }
        for (int i = 0 ; i < k ; i++) 
            dp[i] = max[k - 1][i] * (i + 1);
        for (int i = k ; i < n ; i++) {
            for (int j = 0 ; j < k ; j++) 
                dp[i] = Math.max(dp[i] , (max[j][i] * (j + 1)) + dp[i - j - 1]);
        }
        return dp[n - 1];
    }
}

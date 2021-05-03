class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int max = 0;
            for (int j = 0 ; i >= j && j < k ; j++) {
                max = Math.max(max , arr[i - j]);
                if (i == j) 
                    dp[i] = Math.max(dp[i] , max * (j + 1));
                else 
                    dp[i] = Math.max(dp[i] , (max * (j + 1)) + dp[i - j - 1]);
            }
        }
        return dp[n - 1];
    }
}

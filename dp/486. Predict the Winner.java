class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0 ; i < n ; i++)
            dp[i][i] = nums[i];
        for (int i = 1 ; i < n ; i++)
            dp[i - 1][i] = Math.abs(nums[i - 1] - nums[i]);
        for (int k = 2 ; k < n ; k++) { 
            for (int i = 0 , j = k ; j < n ; i++ , j++) {
                int op1 = Math.min(dp[i + 2][j] + nums[i] - nums[i + 1] , dp[i + 1][j - 1] + nums[i] - nums[j]);
                int op2 = Math.min(dp[i][j - 2] + nums[j] - nums[j - 1] , dp[i + 1][j - 1] + nums[j] - nums[i]);
                dp[i][j] = Math.max(op1 , op2);    
            }
        }
        return dp[0][n - 1] >= 0 ? true : false;
    }
}

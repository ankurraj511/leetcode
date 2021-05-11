class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int[] dp = new int[10001];
        for (int i = 0 ; i < n ; i++) 
            dp[nums[i]] += nums[i];
        for (int i = 2 ; i < 10001 ; i++) {
            if (i == 2)
                dp[i] = Math.max(dp[i] , dp[i - 1]);
            else
                dp[i] = Math.max(dp[i - 2] + dp[i] , Math.max(dp[i - 1] , dp[i - 3] + dp[i]));
        }
        return dp[10000];
    }
}

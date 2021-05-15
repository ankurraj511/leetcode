class Solution {
    int n;
    int[] dp;
    int dfs(int[] nums , int target) {
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        if (dp[target] != -1)
            return dp[target];
        int res = 0;
        for (int i = 0 ; i < n ; i++) 
            res += dfs(nums , target - nums[i]);
        return dp[target] = res;
    }
    public int combinationSum4(int[] nums, int target) {
        n = nums.length;
        dp = new int[target + 1];
        for (int i = 0 ; i <= target ; i++) 
            dp[i] = -1;
        return dfs(nums , target);
    }
}

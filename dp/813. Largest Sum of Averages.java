class Solution {
    double[][] dp;
    int n;
    int[] sum;
    double dfs(int pos , int k) {
        if (pos == n)
            return Integer.MIN_VALUE;
        if (k == 1) {
            double val = sum[n - 1] , no = n - pos;
            if (pos != 0)
                val -= sum[pos - 1];
            return dp[pos][k] = val / no;
        }
        if (dp[pos][k] != 0)
            return dp[pos][k];
        double res = 0.0;
        for (int i = pos ; i < n ; i++) {
            double val = sum[i] , no = i - pos + 1;
            if (pos != 0)
                val -= sum[pos - 1];
            val = val / no;
            res = Math.max(res , val + dfs(i + 1 , k - 1));
        }
        return dp[pos][k] = res;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;
        sum = new int[n];
        for (int i = 0 ; i < n ; i++){
            sum[i] = nums[i];
            if (i != 0)
                sum[i] += sum[i - 1];
        }
        dp = new double[n][k + 1];
        return dfs(0 , k);
    }
}

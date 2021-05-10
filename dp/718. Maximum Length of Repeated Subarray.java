class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length , m = nums2.length , res = 0;
        int[][] dp = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (nums1[i] == nums2[j]) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else 
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res , dp[i][j]);   
            }
        }
        return res;
    }
}

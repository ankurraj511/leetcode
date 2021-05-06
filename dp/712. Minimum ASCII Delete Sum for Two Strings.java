class Solution {
    int[][] dp;
    int dfs(String s1 , String s2, int i , int j) {
        int res = 0;
        if (i == s1.length() && j == s2.length())
            return res;
        if (i == s1.length()) {
            while (j < s2.length())
                res += s2.charAt(j++);
            return res;
        }
        if (j == s2.length()) {
            while (i < s1.length())
                res += s1.charAt(i++);
            return res;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            res = dfs(s1 , s2, i + 1 , j + 1);
        else {
            res = dfs(s1 , s2 , i + 1 , j) + s1.charAt(i);
            res = Math.min(res , dfs(s1 , s2 , i , j + 1) + s2.charAt(j));
        }
        return dp[i][j] = res; 
    }
    /*
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()][s2.length()];
        for (int i = 0 ; i < s1.length() ; i++) 
            for (int j = 0 ; j < s2.length() ; j++) 
                dp[i][j] = -1;
        return dfs(s1 , s2 , 0 , 0);
    }
    */
    
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1 ; i <= s1.length() ; i++) 
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        for (int j = 1 ; j <= s2.length() ; j++)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1 ; i <= s1.length() ; i++) { 
            for (int j = 1 ; j <= s2.length() ; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1) , dp[i][j - 1] + s2.charAt(j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

class Solution {
    int n , m;
    int[][] dp;
    int dfs(int[][] books , int pos , int left , int max_h) {
        if (pos == n)
            return max_h;
        if (dp[pos][left] != 0)
            return dp[pos][left];
        int val1 = 10000000;
        if (left != m) {
            val1 = max_h + dfs(books , pos , m , 0);
            if (books[pos][0] > left)
                return dp[pos][left] = val1;
        }
        int val2 = dfs(books , pos + 1 , left - books[pos][0] , Math.max(max_h , books[pos][1]));
        return dp[pos][left]= Math.min(val1 , val2);
    }
    public int minHeightShelves(int[][] books, int sw) {
        n = books.length;
        m = sw;
        dp = new int[n][m + 1];
        return dfs(books , 0 , sw , 0);
    }
}

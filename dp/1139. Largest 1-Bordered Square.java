class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length , m = grid[0].length , min = 0;
        int[][] t_b = new int[n + 1][m + 1];
        int[][] l_r = new int[n + 1][m + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                t_b[i][j] = t_b[i - 1][j] + grid[i - 1][j - 1];
                l_r[i][j] = l_r[i][j - 1] + grid[i - 1][j - 1];
            }
        }
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= m ; j++) {
                int v = min;
                for (int k = v + 1 ; k <= Math.min(i , j) ; k++) {
                    boolean v1 = t_b[i][j] - t_b[i - k][j] == k;
                    boolean v2 = l_r[i][j] - l_r[i][j - k] == k;
                    boolean v3 = l_r[i - k + 1][j] - l_r[i - k + 1][j - k] == k;
                    boolean v4 = t_b[i][j - k + 1] - t_b[i - k][j - k + 1] == k;
                    if (v1 && v2 && v3 && v4)
                        min = k;
                }
            }
        }
        return min * min;
    }
}

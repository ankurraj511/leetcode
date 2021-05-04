class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int[] res = new int[m];
        for (int ball = 0 ; ball < m ; ball++) {
            int i , j = ball;
            for (i = 0 ; i < n ; i++) {
                if (grid[i][j] == 1) {
                    j += 1;
                    if (j >= m || grid[i][j] != 1)
                        break;
                } else {
                    j -= 1;
                    if (j < 0 || grid[i][j] != -1)
                        break;
                }
            }
            if (i == n) 
                res[ball] = j;
            else
                res[ball] = -1;
        }
        return res;
    }
}

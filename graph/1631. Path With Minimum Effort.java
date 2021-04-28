class Solution {
    public int n , m;
    public boolean[][] visited;
    public boolean dfs(int[][] h , int x , int y , int mid) {
        if (x == n - 1 && y == m - 1)
            return true;
        if (visited[x][y])
            return false;
        visited[x][y] = true;
        int[] dir_x = {1 , -1 , 0 , 0};
        int[] dir_y = {0 , 0 , 1 , -1};
        boolean res = false;
        for (int i = 0 ; i < 4 ; i++) {
            int new_x = x + dir_x[i];
            int new_y = y + dir_y[i];
            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && Math.abs(h[new_x][new_y] - h[x][y]) <= mid) 
                res = res || dfs(h , new_x , new_y , mid);
            if (res)
                return res;
        }
        return false;
    }
    public int minimumEffortPath(int[][] h) {
        n = h.length;
        m = h[0].length;
        int low = 0 , high = 1000000 , mid;
        while (high > low) {
            mid = low + ((high - low) >> 2);
            visited = new boolean[n][m];
            if (dfs(h , 0 , 0 , mid))
                high = mid;
            else
                low = mid + 1;
        }
        return high;
    }
}

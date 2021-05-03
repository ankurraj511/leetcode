class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n = mat.length , m = mat[0].length;
        int[][] arr = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (i == 0 && j == 0) 
                    arr[i][j] = mat[i][j];
                else if (i == 0) 
                    arr[i][j] = arr[i][j - 1] + mat[i][j];
                else if (j == 0)
                    arr[i][j] = arr[i - 1][j] + mat[i][j];
                else 
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + mat[i][j];
            }
        }
        int[][] res = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {                
                int top = Math.max(0 , i - k);
                int bottom = Math.min(n - 1 , i + k);
                int left = Math.max(0 , j - k);
                int right = Math.min(m - 1 , j + k);
                if (top == 0 && left == 0) 
                    res[i][j] = arr[bottom][right];
                else if (top == 0) 
                    res[i][j] = arr[bottom][right] - arr[bottom][left - 1];
                else if (left == 0) 
                    res[i][j] = arr[bottom][right] - arr[top - 1][right];
                else 
                    res[i][j] = arr[bottom][right] - arr[bottom][left - 1] - arr[top - 1][right] + arr[top - 1][left - 1];                                
            }
        }
        return res;
    }
}

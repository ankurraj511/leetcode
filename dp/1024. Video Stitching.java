class cmp implements Comparator<int[]> {
    public int compare(int[] a1 , int[] a2) {
        if (a1[0] > a2[0])
            return 1;
        else if (a1[0] == a2[0])
            if (a1[1] > a2[1])
                return 1;
        return -1;
    }
}
class Solution {
    int n;
    int[][] dp;
    int dfs(int[][] clips , int pos , int t) {
        if (t >= dp[0].length - 1)
            return 0;
        if (pos == n)
            return 1000;
        if (dp[pos][t] != 0)
            return dp[pos][t];
        int res = 1000;
        for (int i = pos ; i < n ; i++) {
            if (clips[i][0] > t)
                break;
            res = Math.min(res , 1 + dfs(clips , i + 1 , clips[i][1]));
        }
        return dp[pos][t] = res;
    }
    public int videoStitching(int[][] clips, int T) {
        n = clips.length;
        Arrays.sort(clips , new cmp());        
        dp = new int[n][T + 1];
        int res = dfs(clips , 0 , 0);
        return  res > 200 ?  -1 : res;
    }
}

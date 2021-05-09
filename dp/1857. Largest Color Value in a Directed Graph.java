class Pair {
    boolean isCycle;
    int[] arr;
    Pair(boolean val , int[] a) {
        isCycle = val;
        arr = new int[26];
        for (int i = 0 ; i < 26 ; i++)
            arr[i] = a[i];
    }
}
class Solution {
    int[] visited;
    int[][] dp;
    ArrayList<ArrayList<Integer>> graph;
    Pair dfs(String colors , int pos) {        
        if (visited[pos] == 1) 
            return new Pair(true , dp[pos]);
        if (visited[pos] == 2) 
            return new Pair(false , dp[pos]);
        visited[pos] = 1;
        for (int i : graph.get(pos)) {
            Pair ele = dfs(colors , i);
            if (ele.isCycle)
                return new Pair(true , dp[pos]);
            for (int j = 0 ; j < 26 ; j++) {
                if (ele.arr[j] > dp[pos][j])
                    dp[pos][j] = ele.arr[j];
            }    
        }
        dp[pos][colors.charAt(pos) - 'a'] += 1;
        visited[pos] = 2;
        return new Pair(false , dp[pos]);
    }
    
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        dp = new int[n][26];
        graph = new ArrayList<>();
        visited = new int[n];
        for (int i = 0 ; i < n ; i++) 
            graph.add(new ArrayList<>());
        for (int i = 0 ; i < edges.length ; i++) 
            graph.get(edges[i][0]).add(edges[i][1]);
        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == 0) {
                Pair ele = dfs(colors , i);
                if (ele.isCycle)
                    return -1;
                for (int j = 0 ; j < 26 ; j++) 
                    res = Math.max(res , ele.arr[j]);
            }
        }
        return res;
    }
}

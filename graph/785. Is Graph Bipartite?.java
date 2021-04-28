class Solution {
    public int n;
    public boolean[] visited;
    public int[] colour;
    public boolean dfs(int pos , int c , int[][] graph) {
        visited[pos] = true;
        colour[pos] = c;
        for (int i = 0 ; i < graph[pos].length ; i++) {
            int child = graph[pos][i];
            if (! visited[child]) {
                if (! dfs(child , c == 1 ? 2 : 1 , graph))
                    return false;
            } else if (colour[pos] == colour[child])
                return false;        
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        visited = new boolean[n];
        colour = new int[n];
        boolean res = false;
        for (int i = 0 ; i < n ; i++) {
            if(! visited[i])
                res = dfs(i , 1 , graph);
            if (! res)
                return res;
        }
        return true;    
    }
}

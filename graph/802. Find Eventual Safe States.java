class Solution {
    public int[] visited;
    public List<Integer> res;
    public boolean dfs(int[][] graph , int pos) {
        if (visited[pos] == 2)  
            return true;
        if (visited[pos] == 1) 
            return false;
        visited[pos] = 2;
        boolean curr = false;
        for (int i = 0 ; i < graph[pos].length ; i++) {
            curr = dfs(graph , graph[pos][i]) || curr;
        }
        if (! curr) { 
            res.add(pos);
            visited[pos] = 1;
        }
        return curr;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        visited = new int[graph.length];
        res = new ArrayList<>();
        for (int i = 0 ; i < graph.length ; i++) {
            if (visited[i] == 0)
                dfs(graph , i);
        }
        Collections.sort(res);
        return res;
    }
}

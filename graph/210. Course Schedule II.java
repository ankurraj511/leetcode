class Solution {
    int[] res;
    int k;
    int[] visited;
    boolean dfs(List<List<Integer>> graph , int pos) {
        if (visited[pos] == 2)
            return false;
        if (visited[pos] == 1)
            return true;
        visited[pos] = 2;
        for (int i : graph.get(pos)) {
            boolean res = dfs(graph , i);
            if (! res)
                return false;
        }
        visited[pos] = 1;
        res[k] = pos;
        k -= 1;
        return true;
    }
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) 
            graph.add(new ArrayList<>());
        for (int[] i : prerequisites) 
            graph.get(i[1]).add(i[0]);
        visited = new int[n];
        res = new int[n];
        k = n - 1;
        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == 0) { 
                if (! dfs(graph , i)) 
                    return new int[0];
            }
        }
        return res;
    }
}

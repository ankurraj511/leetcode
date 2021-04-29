class Solution {
    int[] visited;
    boolean dfs(List<List<Integer>> graph , int pos) {
        if (visited[pos] == 2)
            return false;
        if (visited[pos] == 1)
            return true;
        visited[pos] = 2;
        boolean res = false;
        for (int i = 0 ; i < graph.get(pos).size() ; i++) {
            res = dfs(graph , graph.get(pos).get(i));
            if (! res)
                return false;
        }
        visited[pos] = 1;
        return true;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        visited = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) 
            graph.add(new ArrayList<>());
        for (int[] i : prerequisites) 
            graph.get(i[0]).add(i[1]);
        boolean res = false;
        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == 0) {
                res = dfs(graph , i);
                if (! res)
                    return false;
            }
        }
        return true;
    }
}

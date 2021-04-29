class Solution {
    boolean[] visited;
    void dfs(List<Set<Integer>> graph , int pos , List<Integer> ls) {
        if (visited[pos]) {
            for (int i : graph.get(pos))
                ls.add(i);
            return ;
        }
        visited[pos] = true;
        List<Integer> newList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i : graph.get(pos)) {
            newList = new ArrayList<>();
            dfs(graph , i , newList);
            for (int j : newList) 
                list.add(j); 
        }
        for (int i : list)
            graph.get(pos).add(i);
        for (int i : graph.get(pos))
            ls.add(i);
        ls.add(pos);
        
    }
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) 
            graph.add(new HashSet<>());
        for (int i = 0 ; i < prerequisites.length ; i++)
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        visited = new boolean[n];
        for (int i = 0 ; i < n ; i++) {
            if (! visited[i])
                dfs(graph , i , new ArrayList<Integer>());
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0 ; i < queries.length ; i++) {
            if (graph.get(queries[i][0]).contains(queries[i][1]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}

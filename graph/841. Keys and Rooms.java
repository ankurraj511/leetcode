class Solution {
    public boolean[] visited;
    public void dfs(List<List<Integer>> rooms , int pos) {
        if (visited[pos] == true) 
            return ;
        visited[pos] = true;
        for (int i = 0 ; i < rooms.get(pos).size() ; i++)
            dfs(rooms , rooms.get(pos).get(i));
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms , 0);
        for (int i = 0 ; i < n ; i++) {
            if (! visited[i])
                return false;
        }
        return true;
    }
}

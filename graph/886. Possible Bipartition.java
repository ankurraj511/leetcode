class Solution {
    public int[] colour;
    public boolean dfs(List<List<Integer>> graph , int pos , int c) {
        if (colour[pos] != 0) {
            if (colour[pos] == c)
                return true;
            return false;
        }
        colour[pos] = c;
        boolean res = false;
        for (int i = 0 ; i < graph.get(pos).size() ; i++) {
            res = dfs(graph , graph.get(pos).get(i) , c == 1 ? 2 : 1);
            if (! res)
                return false;
        }
        return true;
    }
    
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i <= N ; i++) 
            graph.add(new ArrayList<>());
        for (int i = 0 ; i < dislikes.length ; i++) {
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
        }
        colour = new int[N + 1];
        boolean res = false;
        for (int i = 1 ; i <= N ; i++) {
            if (colour[i] == 0) {
                res = dfs(graph , i , 1);
                if (! res)
                    return false;
            }
        }
        return true;
    }
}

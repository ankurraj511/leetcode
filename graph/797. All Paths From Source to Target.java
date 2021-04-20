class Solution {
    List<List<Integer>> res = new ArrayList();
    public void helper(int[][] graph , int pos , List<Integer> ls) {
        ls.add(pos);
        if (pos == graph.length - 1) {
            res.add(new ArrayList<Integer>(ls));
            ls.remove(ls.size() - 1);    
            return ;
        }
        for (int i = 0 ; i < graph[pos].length ; i++) 
            helper(graph , graph[pos][i] , ls);
        ls.remove(ls.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph , 0 , new ArrayList<>());
        return res;
    }
}

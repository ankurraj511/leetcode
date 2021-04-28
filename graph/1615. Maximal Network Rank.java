class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) 
            graph.add(new HashSet<Integer>());
        for (int i = 0 ; i < roads.length ; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                int len = graph.get(i).size() + graph.get(j).size(); 
                if (graph.get(i).contains(j))
                    len -= 1;
                res = Math.max(res , len);
            }
        }
        return res;
    }
}

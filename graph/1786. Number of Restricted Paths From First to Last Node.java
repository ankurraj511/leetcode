class Node {
    int val;
    int cost;
    Node (int _val , int _cost) {
        val = _val;
        cost = _cost;
    }
}
class cmp implements Comparator<Node> {
    public int compare(Node n1 , Node n2) {
        if (n1.cost > n2.cost)
            return 1;
        return -1;
    }
}
class Solution {
    int mod = 1000000007;
    int[] distance;
    int[] dp;
    boolean[] visited;
    int dfs(List<List<Node>> graph , int pos) {
        if (pos == distance.length - 1)
            return 1;
        if (dp[pos] != -1)
            return dp[pos];
        int ans = 0;
        for (Node i : graph.get(pos)) {
            if (distance[i.val] < distance[pos])
                ans = (ans + dfs(graph , i.val)) % mod;
        }
        dp[pos] = ans;
        return dp[pos];
    }
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        dp = new int[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0 ; i <=  n ; i++) {
            graph.add(new ArrayList<>());
            dp[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
        for (int[] i : edges) {
            graph.get(i[0]).add(new Node(i[1] , i[2]));
            graph.get(i[1]).add(new Node(i[0] , i[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new cmp());
        pq.add(new Node(n , 0));
        distance[n] = 0;
        while (pq.size() > 0) {
            Node ele = pq.remove();
            visited[ele.val] = true;
            for (Node i : graph.get(ele.val)) { 
                if (! visited[i.val] && ele.cost + i.cost < distance[i.val]) {                                       pq.add(new Node(i.val , ele.cost + i.cost));
                    distance[i.val] = ele.cost + i.cost;
                }
            }
        }
        return dfs(graph , 1);
    }
}

class Node {
    int a;
    double b;
    Node(int a , double b) {
        this.a = a;
        this.b = b;
    }
    Node() {}
}
class Solution {
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) 
            graph.add(new ArrayList<>());
        for (int i = 0 ; i < edges.length ; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1] , succProb[i]));
            graph.get(edges[i][1]).add(new Node(edges[i][0] , succProb[i]));
        }
        Queue<Node> queue = new LinkedList<>();
        double[] visited = new double[n];
        queue.add(new Node(start , 1.0));
        double res = 0.0;
        while (queue.size() > 0) {
            Node ele = queue.remove();
            if (ele.a == end) {
                res = Math.max(res , ele.b);
            } else {
                for (Node i : graph.get(ele.a)) {
                    if (ele.b * i.b > visited[i.a]) {
                        queue.add(new Node(i.a , ele.b * i.b));
                        visited[i.a] = ele.b * i.b;
                    }
                }
            }
        }
        return res;
    }
}

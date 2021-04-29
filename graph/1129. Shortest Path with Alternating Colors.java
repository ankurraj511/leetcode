class Node {
    int a; 
    int b;
    int c;
    Node(int a , int b , int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
class Solution {
    int bfs(int n , List<List<Integer>> red_graph , List<List<Integer>> blue_graph , int c , int end) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][2];
        visited[0][c - 1] = true;
        queue.add(new Node(0 , 0 , c));
        while (queue.size() > 0) {
            Node ele = queue.remove();
            if (ele.a == end) 
                return ele.b;
            else {
                if (ele.c == 1) {
                    for (int j : blue_graph.get(ele.a)) {
                        if (! visited[j][ele.c - 1]) {
                            queue.add(new Node(j , ele.b + 1 , 2));
                            visited[j][ele.c - 1] = true;
                        }
                    }
                } else {
                    for (int j : red_graph.get(ele.a)) {
                        if (! visited[j][ele.c - 1]) {
                            queue.add(new Node(j , ele.b + 1 , 1));
                            visited[j][ele.c - 1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<List<Integer>> red_graph = new ArrayList<>();
        List<List<Integer>> blue_graph = new ArrayList<>();
        int[] res = new int[n];
        for (int i = 0 ; i < n ; i++) {
            red_graph.add(new ArrayList<>());
            blue_graph.add(new ArrayList<>());
        }
        for (int i = 0 ; i < red_edges.length ; i++) 
            red_graph.get(red_edges[i][0]).add(red_edges[i][1]);
        for (int i = 0 ; i < blue_edges.length ; i++) 
            blue_graph.get(blue_edges[i][0]).add(blue_edges[i][1]);
        int start = 0;
        for (int end = 1 ; end < n ; end++) {
            int v1 = bfs(n , red_graph , blue_graph , 1 , end);
            int v2 = bfs(n , red_graph , blue_graph , 2 , end);
            if (v1 == -1 && v2 == -1)
                res[end] = -1;
            else if (v1 == -1)
                res[end] = v2;
            else if (v2 == -1)
                res[end] = v1;
            else
                res[end] = Math.min(v1 , v2);
        }
        return res;
    } 
}

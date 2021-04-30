class Node {
    String des;
    boolean ticket;
    Node (String _des , boolean _ticket) {
        des = _des;
        ticket = _ticket;
    }
}
class cmp implements Comparator<Node> {
    public int compare(Node n1 , Node n2) {
        int i = 0;
        while (i < 3 && n1.des.charAt(i) == n2.des.charAt(i)) 
            i += 1;
        if (i < 3 && n1.des.charAt(i) - 'A' > n2.des.charAt(i) - 'A') 
            return 1;
        return -1;
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    boolean dfs(Map<String , List<Node>> graph , String pos , int count) {
        res.add(pos);
        if (count == 0)
            return true;
        for (int i = 0 ; i < graph.get(pos).size() ; i++)  {
            Node temp = graph.get(pos).get(i);
            if (temp.ticket) { 
                temp.ticket = false;
                if (dfs(graph , temp.des , count - 1))
                    return true;
                temp.ticket = true;
            }
        }
        res.remove(res.size() - 1);
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String , List<Node>> graph = new HashMap<>();
        for (List<String> i : tickets) {
            if (graph.containsKey(i.get(0))) {
                graph.get(i.get(0)).add(new Node(i.get(1) , true));
            } else {
                List<Node> ls = new ArrayList<>();
                ls.add(new Node(i.get(1) , true));
                graph.put(i.get(0) , ls);
            }
            if (! graph.containsKey(i.get(1)))
                graph.put(i.get(1) , new ArrayList<>());
        }
        for (String i : graph.keySet()) 
            Collections.sort(graph.get(i) , new cmp());
        dfs(graph , "JFK" , tickets.size());
        // for (String i : graph.keySet()) {
        //     System.out.print(i + " = ");
        //     for (Node j : graph.get(i)) {
        //         System.out.print(j.des + " ");
        //     }
        //     System.out.println();
        // }
        
        return res;    
    }
}

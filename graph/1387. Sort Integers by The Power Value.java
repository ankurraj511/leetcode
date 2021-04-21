class Node {
    int a;
    int b;
    Node (int a , int b) {
        this.a = a;
        this.b = b;
    }
}
class cmp implements Comparator<Node> {
    public int compare(Node n1 , Node n2) {
        if (n1.b == n2.b) {
            if (n1.a > n2.a) 
                return 1;
            return -1;
        } 
        if (n1.b > n2.b)
            return 1;
        return -1;
    }
}
class Solution {
    public int countPower(int num) {
        int step = 0;
        while (num != 1) {
            if (num % 2 == 0) 
                num = num / 2;
            else 
                num = (3 * num) + 1;
            step += 1;
        }
        return step;
    }
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1 , j = 0;
        Node[] arr = new Node[n];
        for (int i = lo ; i <= hi ; i++) {
            arr[j] = new Node(i , countPower(i));
            
            j += 1;
        }
        Arrays.sort(arr , new cmp());
        return arr[k - 1].a;
    }
}

class Node {
    int a;
    int b;
    Node(int a , int b) {
        this.a = a;
        this.b = b; 
    }
}
class Solution {
    Node[] arr;
    Node dfs(int[] lc , int[] rc , int pos) {
        if (pos == -1)
            return new Node(0 , 1);
        if (arr[pos].b == -1)
            return new Node(arr[pos].a , -1);
        if (arr[pos].b == 1)
            return new Node(arr[pos].a , 1);
        arr[pos].b = -1;
        Node left = dfs(lc , rc , lc[pos]);
        Node right = dfs(lc , rc , rc[pos]);
        if (left.b != -1 && right.b != -1)
            arr[pos].b = 1;
        arr[pos].a = left.a + right.a + 1;
        return arr[pos];
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        arr = new Node[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = new Node(0 , 0);
        }
        for (int i = 0 ; i < n ; i++) {
            Node res = dfs(leftChild , rightChild , i);
            if (res.a == n && res.b == 1)
                return true;
        }
        return false;
    }
}

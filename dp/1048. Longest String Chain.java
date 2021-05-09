class Pair {
    String str;
    int len;
    Pair(String s , int l) {
        str = s;
        len = l;
    }
}
class Solution {
    ArrayList<ArrayList<Pair>> ls;
    boolean isChain(String s1 , String s2) {
        for (int i = 0 ; i < s2.length() ; i++) {
            int j = 0 , k = 0;
            while (j < s1.length()) {
                if (k == i) 
                    k += 1;
                if (s1.charAt(j) != s2.charAt(k))
                    break;
                j += 1;
                k += 1;
            }
            if (j == s1.length())
                return true;
        }
        return false;
    }
    int dfs(int len, int pos) {
        if (len == 15)
            return 1;
        String curr = ls.get(len).get(pos).str;
        int curr_len = ls.get(len).get(pos).len;
        if (curr_len != 0)
            return curr_len;
        for (int i = 0 ; i < ls.get(len + 1).size() ; i++) {
            String next = ls.get(len + 1).get(i).str;
            if (isChain(curr , next)) {
                curr_len = Math.max(curr_len , dfs(len + 1 , i));
            }
        }
        curr_len += 1;
        return ls.get(len).get(pos).len = curr_len;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        ls = new ArrayList();
        for (int i = 0 ; i < 16 ; i++)
            ls.add(new ArrayList());
        for (int i = 0 ; i < n ; i++) 
            ls.get(words[i].length() - 1).add(new Pair(words[i] , 0));
        int res = 0;
        for (int i = 0 ; i < 16 ; i++) 
            for (int j = 0 ; j < ls.get(i).size() ; j++) 
                res = Math.max(res , dfs(i , j));
        return res;
    }
}

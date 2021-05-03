class Solution {
    int helper(int i , int j , String s) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i -= 1;
            j += 1;
            count += 1;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            res += helper(i , i , s);
            res += helper(i , i + 1 , s);
        }
        return res;
    }
}

class Solution {
    Set<Integer> set = new HashSet<>();
    Map<Integer , Integer> map = new HashMap<>();
    
    int helper(int prev , int count) {
        if (count == 0)
            return 1;
        int res = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > 0 && set.contains(prev + i)) {
                map.put(i , map.get(i) - 1);
                res += helper(i , count - 1);    
                map.put(i , map.get(i) + 1);    
            }
        }
        return res;
    }
    
    public int numSquarefulPerms(int[] A) {
        for (int i = 0 ; i * i <= 2000000000 ; i++) 
            set.add(i * i);
        for (int i = 0 ; i < A.length ; i++) {
            if (map.containsKey(A[i])) 
                map.put(A[i] , map.get(A[i]) + 1);
            else 
                map.put(A[i] , 1);
        }
        int res = 0;
        for (int i : map.keySet()) {
            map.put(i , map.get(i) - 1);
            res += helper(i , A.length - 1);    
            map.put(i , map.get(i) + 1);
        }
        return res;
    }
}

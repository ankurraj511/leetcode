class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n = arr.length , res = 0;
        HashMap<Integer , Integer> map = new HashMap();
        for (int i = 0 ; i < n ; i++) {
            int val = arr[i] - diff;
            if (map.containsKey(val)) 
                map.put(arr[i] , map.get(val) + 1);
            else 
                map.put(arr[i] , 1); 
            res = Math.max(res , map.get(arr[i]));
        }
        return res;
    }
}

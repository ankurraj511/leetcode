class Solution {
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        ArrayList<HashMap<Integer , Integer>> arr = new ArrayList<>();
        for (int i = 0 ; i < A.length ; i++) {
            arr.add(new HashMap());
            for (int j = i - 1 ; j >= 0 ; j--) {
                int diff = A[i] - A[j];
                if (! arr.get(i).containsKey(diff)) {
                    if (arr.get(j).containsKey(diff))
                        arr.get(i).put(diff , arr.get(j).get(diff) + 1);
                    else 
                        arr.get(i).put(diff , 2);
                }
                res = Math.max(res , arr.get(i).get(diff));   
            }
        }
        return res;    
    }
}



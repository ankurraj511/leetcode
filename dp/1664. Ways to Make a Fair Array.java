class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length , count = 0;
        int[] le = new int[n];
        int[] lo = new int[n];
        int[] re = new int[n];
        int[] ro = new int[n];
        for (int i = 0 ; i < n ; i++) {
            if (i % 2 == 0) { 
                if (i == 0)
                    le[i] = nums[i];
                else {
                    le[i] = le[i - 1] + nums[i];
                    lo[i] = lo[i - 1];
                }
            } else {
                le[i] = le[i - 1];
                lo[i] = lo[i - 1] + nums[i];
            }
        }
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (i % 2 == 0) { 
                if (i == n - 1)
                    re[i] = nums[i];
                else {
                    re[i] = re[i + 1] + nums[i];
                    ro[i] = ro[i + 1];
                }
            } else {
                if (i == n - 1)
                    ro[i] = nums[i];
                else {
                    ro[i] = ro[i + 1] + nums[i];
                    re[i] = re[i + 1];
                }
            }
        }
        for (int i = 0 ; i < n ; i++) {
            int les = 0 , los = 0 , res = 0 , ros = 0;
            if (i != 0) {
                les = le[i - 1];
                los = lo[i - 1];
            }
            if (i != n - 1) {
                res = re[i + 1];
                ros = ro[i + 1];
            }
            if (les + ros == los + res)
                count += 1;
        }
        return count;
    }
}

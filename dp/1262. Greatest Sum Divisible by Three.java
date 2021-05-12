class Solution {
    public int maxSumDivThree(int[] nums) {
        int val0 = 0 , val1 = 0 , val2 = 0;
        int curr_val0 = 0 , curr_val1 = 0 , curr_val2 = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] % 3 == 0) {
                curr_val0 += nums[i];
                curr_val1 += nums[i];
                curr_val2 += nums[i];
            } else if (nums[i] % 3 == 1) {
                curr_val0 = Math.max(val0 , val2 % 3 != 0 ? val2 + nums[i] : 0); 
                curr_val1 = Math.max(val1 , val0 + nums[i]);
                curr_val2 = Math.max(val2 , val1 % 3 != 0 ? val1 + nums[i] : 0);
            } else {
                curr_val0 = Math.max(val0 , val1 % 3 != 0 ? val1 + nums[i] : 0); 
                curr_val1 = Math.max(val1 , val2 % 3 != 0 ? val2 + nums[i] : 0);
                curr_val2 = Math.max(val2 , val0 + nums[i]);
            }
            val0 = curr_val0;
            val1 = curr_val1;
            val2 = curr_val2;
        }
        return val0;
    }
}

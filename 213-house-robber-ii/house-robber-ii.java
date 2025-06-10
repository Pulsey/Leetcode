class Solution {
    public int rob(int[] nums) {

        if ( nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length -1));
        
    }

    public int helper( int[] nums, int start, int end){
        int[] dp =  new int[end - start + 1];
        dp[0] = nums[start];
        if (dp.length > 1)
        dp[1] = Math.max(nums[start], nums[start+1]);
        int i = 0;
        for(i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], nums[start + i] + dp[i-2]);
        } 
        return dp[dp.length - 1];
    }
}
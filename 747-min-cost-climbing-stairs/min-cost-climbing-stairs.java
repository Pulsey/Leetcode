class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        int i=0;
        if(cost.length == 0) return 0;
        if(cost.length == 1) return 0;
        for(i = 2; i<= cost.length; i++){
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[i-1];
    }
}

class Solution {
    public int climbStairs(int n) {
        int n1 = 1;
        int n2 = 2;
        if( n == 1) return 1;
        if(n == 2) return 2;
        int res = 0;
        for(int i = 3; i <= n; i++){
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}
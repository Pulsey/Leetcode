class Solution {
    public int singleNumber(int[] nums) {
        // here the trick is XOR ^

        int result = 0;
        for(int num: nums){
            result = result ^ num;
        }
        return result;
    }
}

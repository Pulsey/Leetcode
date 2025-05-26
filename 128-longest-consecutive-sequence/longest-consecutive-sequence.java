class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for( int num : nums){
            set.add(num);
        }
        int max = 0;
        int count=0;

        for( int num : nums){
            if(!set.contains(num-1)){
                while(set.contains(num++)){
                    set.remove(num-1);
                    count++;
                }
            }
        max = Math.max(max, count);
        count  = 0;
        }
        return max;
    }
}

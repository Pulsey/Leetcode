class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int length = nums.length;
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        List<Integer> subset = new ArrayList<Integer>();
        backtrack(nums, 0, result, subset);
        return result;
    }

    public void backtrack(int[] nums, int i, List<List<Integer>> result, List<Integer> subset){
        if( i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, i+1, result, subset);
        subset.remove(subset.size() - 1);
        backtrack(nums, i+1, result, subset);
    }
}
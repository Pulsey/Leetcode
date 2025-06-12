class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(nums, subset, 0 );
        return result;
    }
    public void backtrack(int[] nums, List<Integer> subset, int start){
        result.add(new ArrayList<>(subset));
        for(int i = start; i < nums.length; i++ ){

            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            backtrack(nums, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
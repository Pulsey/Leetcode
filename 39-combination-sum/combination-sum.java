class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        backtrack(nums, 0,  result, combo, target);
        return result;
    }
    public void backtrack(int[] nums, int i, List<List<Integer>> result, List<Integer> combo, int target){
        if(target == 0){
            result.add(new ArrayList<>(combo));
            return;
        }
          if (target < 0 || i >= nums.length) {
            return;
        }
        combo.add(nums[i]);
        backtrack(nums, i, result, combo, target - nums[i]);
        combo.remove(combo.size() - 1);
        backtrack(nums, i+1, result, combo, target);

    }
}

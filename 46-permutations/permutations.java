class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        boolean[] seen = new boolean[nums.length];

        backtrack(nums, seen, result, perm);
        return result;
    }
    public void backtrack(int[] nums, boolean[] seen, List<List<Integer>> result, List<Integer> perm){
        if(perm.size() == nums.length){
            result.add(new ArrayList<>(perm));
            return;
        }
        for(int j = 0; j <nums.length; j++){
            if(!seen[j]){      
                perm.add(nums[j]);
                seen[j] = true;
            
            backtrack(nums, seen, result, perm);
            perm.remove(perm.size() - 1);
            seen[j] = false;
            }
        }
    }
}

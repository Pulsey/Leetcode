class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combo = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, result, combo);

        return result;
    }

    public void backtrack(int[] candidates, int target, int i,List<List<Integer>> result, List<Integer> combo){
        if( target == 0){
            result.add(new ArrayList<>(combo));
            return;
        }

        if(target < 0 || i >= candidates.length){
            return;
        }

        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j- 1]) continue;
            if(candidates[j] > target) break;
        combo.add(candidates[j]);
        backtrack(candidates, target - candidates[j], j+1, result, combo);
        combo.remove(combo.size() - 1);
        }
    }
}

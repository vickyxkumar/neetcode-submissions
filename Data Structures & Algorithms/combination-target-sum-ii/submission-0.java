class Solution {
    
    public void dfs(int [] candidate, int idx, int target, int sum, List<Integer> lst, List<List<Integer>> ans){
        if(target == sum){
            ans.add(new ArrayList<>(lst));
        }

        if(target < sum || idx == candidate.length){
            return;
        }

        for(int i = idx; i < candidate.length; i++){
            if(i > idx && candidate[i] == candidate[i-1]) continue;
            lst.add(candidate[i]);
            dfs(candidate, i+1, target, sum + candidate[i], lst, ans);
            lst.remove(lst.size()-1);
        } 
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(candidates, 0, target, 0, new ArrayList<>(), ans);

        return ans;
    }
}

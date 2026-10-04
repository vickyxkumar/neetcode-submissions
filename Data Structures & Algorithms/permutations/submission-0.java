class Solution {
    public void dfs(int [] nums, boolean []isTaken, List<Integer> list, List<List<Integer>> ans){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i< nums.length; i++){
            if(isTaken[i]) continue;
            isTaken[i] = true;
            list.add(nums[i]);
            dfs(nums, isTaken, list, ans);
            isTaken[i] = false;
            list.remove(list.size()-1);
        }

        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);

        return ans;
    }
}

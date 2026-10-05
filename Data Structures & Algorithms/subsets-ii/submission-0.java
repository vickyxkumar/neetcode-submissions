class Solution {
    public void dfs(int[] nums, int idx, List<Integer> lst, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(lst));

        for (int i = idx; i < nums.length; i++) {
            if (idx < i && nums[i] == nums[i - 1])
                continue;
            lst.add(nums[i]);
            dfs(nums, i + 1, lst, ans);
            lst.remove(lst.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), ans);

        return ans;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        lst.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= lst.get(lst.size()-1)){
                // find the correct index and put that idx
                int idx = Collections.binarySearch(lst, nums[i]);
                int realIdx = idx;
                if(idx < 0){
                    realIdx = Math.abs(idx + 1);
                }
                // System.out.println(realIdx);
                lst.set(realIdx, nums[i]);

            }else{
                lst.add(nums[i]);
            }
        }

        return lst.size();
    }
}

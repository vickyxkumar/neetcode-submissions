class Solution {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 != 0) return false;

        int target = sum/2;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int ele : nums){
             Set<Integer> currentElements = new HashSet<>(set);
            for(int i : currentElements){
                set.add(i+ele);
            }
        }

        return set.contains(target);

    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int[] ans = new int[n-k+1];
        

        int i = 0;
        while (i < n) { 
            pq.offer(new int[]{i, nums[i]});

            while(!pq.isEmpty() && (i - k) >= pq.peek()[0]){
                pq.poll();
            }

            if(i >= k-1){
                ans[i-k+1] = pq.peek()[1];
            }
            

            i++;
        }

        return ans;
    }
}

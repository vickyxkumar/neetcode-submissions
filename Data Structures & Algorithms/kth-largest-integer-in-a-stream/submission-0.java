class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }
        int lastVal = 0;
        // PriorityQueue<Integer> dummyPq = new PriorityQueue<>();
        // while (!pq.isEmpty()){
        //     lastVal = pq.poll();
        //     dummyPq.add(lastVal);
        // }

        // pq = dummyPq;

        return pq.peek();
    }
}

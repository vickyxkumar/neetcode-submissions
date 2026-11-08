class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // insert in the decreasing order
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));

        for(int[] point: points){
            double dis = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            pq.add(new double[]{dis, (double) point[0], (double) point[1]});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            double [] poll = pq.poll();
            ans[i] = new int[]{ (int) poll[1], (int) poll[2]};
            i++;
        }

        return ans;


    }
}

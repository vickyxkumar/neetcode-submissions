class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int stone : stones){
            pq.add(stone);
        }

        while(!pq.isEmpty()){
            if(pq.size() == 1){
                break;
            }

            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if(firstStone != secondStone){
                pq.add(Math.abs(firstStone - secondStone));
            }

        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}

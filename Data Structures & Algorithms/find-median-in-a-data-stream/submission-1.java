class MedianFinder {

    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {
        nums.add(num);
    }
    
    public double findMedian() {
        int len = nums.size();
        Collections.sort(nums);

        return len % 2 == 0 ? ((double) (nums.get((len/2)) + nums.get((len/2)-1)))/2 : (double)(nums.get(len/2));

    }
}

class MedianFinder {

    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {

        
        int idx = Collections.binarySearch(nums, num);
        if(idx < 0){
            nums.add(Math.abs(idx+1), num);
        }else{
            nums.add(idx, num);
        }
    }
    
    public double findMedian() {
        int len = nums.size();

        return len % 2 == 0 ? ((double) (nums.get((len/2)) + nums.get((len/2)-1)))/2 : (double)(nums.get(len/2));

    }
}

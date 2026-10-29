class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int count = 0;
        int[] lastInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (lastInterval[1] > intervals[i][0]) {

                lastInterval = intervals[i][1] < lastInterval[1] ? intervals[i] : lastInterval;
                
                count++;
            } else {
                lastInterval = intervals[i];
            }
        }

        return count;
    }
}

class Solution {
    // does this arrays is sorted
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] newInterval = ans.get(ans.size() - 1);
            if (intervals[i][0] > newInterval[1]) {
                ans.add(intervals[i]);
            } else {
                ans.remove(ans.size() - 1);
                ans.add(new int[] {Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i][1], newInterval[1])});
            }
        }

        int result[][] = new int[ans.size()][2];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}

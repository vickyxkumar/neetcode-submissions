class Solution {
    public int merged(int interval, int val) {
        if (interval > val) {
            return val;
        }

        return interval;
    }

    public boolean insertable(int[] interval, int val) {
        if (interval[0] > val || (interval[0] < val && interval[1] > val)) {
            return true;
        }

        return false;
    }

    public int[][] converter(List<List<Integer>> ans) {
        int n = ans.size();

        int result[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                ans.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));
                for (int j = i; j < intervals.length; j++) {
                    ans.add(new ArrayList<>(List.of(intervals[j][0], intervals[j][1])));
                }
                return converter(ans);
            } else if (newInterval[0] > intervals[i][1]) {
                ans.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }

        ans.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));

        return converter(ans);
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int upperLimit[] = new int[n];
        int lowerLimit[] = new int[n];

        Stack<Integer> st = new Stack<>();
        lowerLimit[0] = 0;
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                lowerLimit[i] = i;
            }

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                lowerLimit[i] = lowerLimit[st.pop()];
            }

            st.add(i);
        }

        upperLimit[n - 1] = n - 1;

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = n-1; i >= 0; i--) {
            if (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                upperLimit[i] = i;
            }

            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                upperLimit[i] = upperLimit[st.pop()];
            }

            st.add(i);
        }

        int area = 0;

        for(int i = 0; i< n; i++){
            area = Math.max(area, heights[i] * (upperLimit[i] - lowerLimit[i] + 1));
        }

        return area;
    }
}

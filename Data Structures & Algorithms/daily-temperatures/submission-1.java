class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nge = new Stack<>();
        int n = temperatures.length;
        int ans[] = new int[n];

        for(int i = n-1; i >=0; i--){
            if(i == n-1){
                ans[i] = 0;
                nge.push(i);
            }else{
                while(!nge.isEmpty() && temperatures[nge.peek()] <= temperatures[i]){
                    nge.pop();
                }

                ans[i] = nge.isEmpty() ? 0 : nge.peek() - i;
                nge.push(i);
            }
        }

        return ans;
    }
}

class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int table[] = new int [n+1];
        table[1] = 1;
        table[2] = 2;
        for(int i = 3; i<= n; i++){
            table[i] = table[i-2] + table[i-1]; 
        }

        return table[n];
    }
}
